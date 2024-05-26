package airportproject.start.controller;

import airportproject.start.dto.*;
import airportproject.start.entity.*;
import airportproject.start.exception.BookingException;
import airportproject.start.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

import java.util.Optional;

@RestController
@RequestMapping("/create")
public class CreateController
{
    @Autowired
    LoyalityProgramService loyalityProgramService;
    @Autowired
    CountryService countryService;
    @Autowired
    FlightProviderService flightProviderService;
    @Autowired
    AirplaneModelService airplaneModelService;
    @Autowired
    AirplaneTypeService airplaneTypeService;
    @Autowired
    SeatsService seatsService;
    @Autowired
    AirportService airportService;
    @Autowired
    AirplaneService airplaneService;
    @Autowired
    FlightService flightService;
    @Autowired
    BookingService bookingService;

    @PostMapping("/loyality-program")
    public LoyalityProgram create(@RequestBody LoyalityProgram loyalityProgram){
        return loyalityProgramService.create(loyalityProgram);
    }

    //{
    //    "loyalityProgram" : "50% discount",
    //    "discountProcent" : 50
    //}

    @PostMapping("/country")
    public Country create(@RequestBody Country country){
        return countryService.create(country);
    }

    //{
    //    "countryName" : "Sweden"
    //}

    @PostMapping("/flight-provider")
    public FlightProvider create(@RequestBody FlightProvider flightProvider){
        return flightProviderService.create(flightProvider);
    }

    //{
    //    "flightProviderName" : "Sweden"
    //}

    @PostMapping("/airplane-model")
    public AirplaneModel create(@RequestBody AirplaneModel airplaneModel){
        return airplaneModelService.create(airplaneModel);
    }

    //{
    //    "airplaneModelName" : "Boeing 787 Jetliner"
    //}

    @PostMapping("/airplane-type")
    public AirplaneType create(@RequestBody AirplaneTypeDto airplaneTypeDto){
        Optional<AirplaneModel> optionalAirplaneModel = airplaneModelService.findAirplaneModelById(airplaneTypeDto.airplaneModelId);
        AirplaneModel airplaneModel = optionalAirplaneModel.get();
        AirplaneType airplaneType = new AirplaneType();

        airplaneType.setAirplaneModel(airplaneModel);
        airplaneType.setAirplaneTypeName(airplaneTypeDto.getAirplaneTypeName());
        return airplaneTypeService.create(airplaneType);
    }

    //{
    //    "airplaneModelId": 3,
    //    "airplaneTypeName": "JetLiner"
    //}

    @PostMapping("/{numberOfSeats}/seats")
    public Seats create(@PathVariable("numberOfSeats") Integer numberOfSeats){
        List<Boolean> booleanList = new ArrayList<Boolean>(numberOfSeats);
        for(int i = 0; i < numberOfSeats; i++){
            booleanList.add(false);
        }
        Seats seats = new Seats();
        seats.setReservedSeats(booleanList);
        return seatsService.create(seats);
    }

    //http://localhost:8080/create/50/seats

    @PostMapping("/airport")
    Airport create(@RequestBody AirportAdditionalDto airportAdditionalDto){
        Long countryId = airportAdditionalDto.getCountryId();
        Optional<Country> optionalCountry = countryService.findCountryById(countryId);

        Country country = optionalCountry.get();
        Airport airport = new Airport();

        airport.setAirportCity(airportAdditionalDto.getAirportCity());
        airport.setAirportName(airportAdditionalDto.getAirportName());
        airport.setCountry(country);

        return airportService.create(airport);
    }

    //{
    //    "countryId": 3,
    //    "airportName" : "Stockholm Arlanda Airport",
    //    "airportCity" : "Stockholm"
    //}

    @PostMapping("/airplane")
    Airplane create(@RequestBody AirplaneAdditionalDto airplaneAdditionalDto){
        Optional<AirplaneType> optionalAirplaneType = airplaneTypeService.getAirplaneTypeById(airplaneAdditionalDto.getAirplaneTypeId());
        Optional<Seats> optionalSeats = seatsService.getSeatsById(airplaneAdditionalDto.getSeatsId());

        AirplaneType airplaneType = optionalAirplaneType.get();
        Seats seats = optionalSeats.get();

        Airplane airplane = new Airplane();

        airplane.setAirplaneType(airplaneType);
        airplane.setSeats(seats);

        return airplaneService.create(airplane);
    }

    //{
    //    "airplaneTypeId": 4,
    //    "seatsId" : 3
    //}

    @PostMapping("/flight")
    Flight create(@RequestBody FlightAdditionalDto flightAdditionalDto){
        Optional<FlightProvider> optionalFlightProvider = flightProviderService.getFlightProviderById(flightAdditionalDto.getFlightProviderId());
        Optional<Airport> optionalOriginAirport = airportService.findAirportById(flightAdditionalDto.getOriginAirportId());
        Optional<Airport> optionalDestinationAirport = airportService.findAirportById(flightAdditionalDto.getDestinationAirportId());
        Optional<Airplane> optionalAirplane = airplaneService.findById(flightAdditionalDto.getAirplaneId());

        FlightProvider flightProvider = optionalFlightProvider.get();
        Airport originAirport = optionalOriginAirport.get();
        Airport destinationAiport = optionalDestinationAirport.get();
        Airplane airplane = optionalAirplane.get();

        Flight flight = new Flight();

        flight.setFlightProvider(flightProvider);
        flight.setOriginAirport(originAirport);
        flight.setDestinationAirport(destinationAiport);
        flight.setAirplane(airplane);

        flight.setArrivalTime(flightAdditionalDto.getArrivalTime());
        flight.setDepartureTime(flightAdditionalDto.getDepartureTime());
        flight.setPrice(flightAdditionalDto.getPrice());

        return flightService.create(flight);

    }

    //{
    //    "flightProviderId": 1,
    //    "originAirportId" : 3,
    //    "destinationAirportId" : 2,
    //    "airplaneId" : 3,
    //    "arrivalTime" : "2024-05-12T19:30:00.000+00:00",
    //    "departureTime" : "2024-05-12T19:30:00.000+00:00",
    //    "price":1350
    //}


    @PostMapping("/booking")
    Booking create(@RequestBody BookingAdditionalDto bookingAdditionalDto){
        Optional<LoyalityProgram> optionalLoyalityProgram = loyalityProgramService.getById(bookingAdditionalDto.getLoyalityProgramId());
        Optional<Flight> optionalFlight = flightService.findFlightById(bookingAdditionalDto.getId());

        Booking booking = new Booking();


        LoyalityProgram loyalityProgram = optionalLoyalityProgram.get();
        Flight flight = optionalFlight.get();
        Airplane airplane = flight.getAirplane();

        if(!optionalLoyalityProgram.isPresent()){
            booking.setLoyalityProgram(null);
        }else{
            booking.setLoyalityProgram(loyalityProgram);
        }

        booking.setFlight(flight);

        booking.setFirstName(bookingAdditionalDto.getFirstName());
        booking.setLastName(bookingAdditionalDto.getLastName());
        booking.setGender(bookingAdditionalDto.getGender());
        booking.setAge(bookingAdditionalDto.getAge());
        booking.setCitizenship(bookingAdditionalDto.getCitizenship());
        booking.setPassportId(bookingAdditionalDto.getPassportId());

        if(airplane.getSeats().getReservedSeats().get(bookingAdditionalDto.getReservedSeat() - 1) != true){
            booking.setReservedSeat(bookingAdditionalDto.getReservedSeat());
            airplane.getSeats().getReservedSeats().set(bookingAdditionalDto.getReservedSeat(), true);
        }else{
            throw new BookingException("The seat is not available.");
        }

        if(optionalLoyalityProgram.isPresent()){
            Long discount = loyalityProgram.getDiscountProcent();
            Long price = flight.getPrice();

            Long totalPrice = price - (price / 100 * discount);

            booking.setPrice(totalPrice);
        }

        return bookingService.save(booking);

    }

    //Da se sredi kd ima null loyality program shto da pravi //
    
    //{
    //  "loyalityProgramId": 5,
    //  "flightId": 9,
    //  "reservedSeat": 12,
    //  "firstName": "John",
    //  "lastName": "Doe",
    //  "gender": "M",
    //  "age": 30,
    //  "citizenship": "USA",
    //  "passportId": "123456789",
    //  "bookingTime": "2023-03-14T12:34:56Z"
    //}
}
