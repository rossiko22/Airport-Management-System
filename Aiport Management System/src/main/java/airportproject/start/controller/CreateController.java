package airportproject.start.controller;

import airportproject.start.dto.*;
import airportproject.start.entity.*;
import airportproject.start.exception.BookingException;
import airportproject.start.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;
import java.time.Instant;
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

    @PostMapping("/country")
    public Country create(@RequestBody Country country){
        return countryService.create(country);
    }


    @PostMapping("/flight-provider")
    public FlightProvider create(@RequestBody FlightProvider flightProvider){
        return flightProviderService.create(flightProvider);
    }


    @PostMapping("/airplane-model")
    public AirplaneModel create(@RequestBody AirplaneModel airplaneModel){
        return airplaneModelService.create(airplaneModel);
    }


    @PostMapping("/airplane-type")
    public AirplaneType create(@RequestBody AirplaneTypeDto airplaneTypeDto){
        Optional<AirplaneModel> optionalAirplaneModel = airplaneModelService.findAirplaneModelById(airplaneTypeDto.airplaneModelId);
        AirplaneModel airplaneModel = optionalAirplaneModel.get();
        AirplaneType airplaneType = new AirplaneType();

        airplaneType.setAirplaneModel(airplaneModel);
        airplaneType.setAirplaneTypeName(airplaneTypeDto.getAirplaneTypeName());
        return airplaneTypeService.create(airplaneType);
    }


    @PostMapping("/{numberOfSeats}/seats")
    public Seats create(@PathVariable("numberOfSeats") Integer numberOfSeats){
        return seatsService.create(numberOfSeats);
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


    @PostMapping("/booking")
    Booking create(@RequestBody BookingAdditionalDto bookingAdditionalDto){
        Optional<LoyalityProgram> optionalLoyalityProgram;

        if(bookingAdditionalDto.getLoyalityProgramId() != null){
            optionalLoyalityProgram = loyalityProgramService.getById(bookingAdditionalDto.getLoyalityProgramId());
        }else{
            optionalLoyalityProgram = loyalityProgramService.getById(1L);
        }

        Optional<Flight> optionalFlight = flightService.findFlightById(bookingAdditionalDto.getId());

        Booking booking = new Booking();


        LoyalityProgram loyalityProgram = optionalLoyalityProgram.get();
        Flight flight = optionalFlight.get();
        Airplane airplane = flight.getAirplane();

        booking.setFlight(flight);

        booking.setFirstName(bookingAdditionalDto.getFirstName());
        booking.setLastName(bookingAdditionalDto.getLastName());
        booking.setGender(bookingAdditionalDto.getGender());
        booking.setAge(bookingAdditionalDto.getAge());
        booking.setCitizenship(bookingAdditionalDto.getCitizenship());
        booking.setPassportId(bookingAdditionalDto.getPassportId());
        booking.setLoyalityProgram(loyalityProgram);
        booking.setBookingTime(Timestamp.from(Instant.now()));

        if(airplane.getSeats().getReservedSeats().get(bookingAdditionalDto.getReservedSeat() - 1) != true){
            booking.setReservedSeat(bookingAdditionalDto.getReservedSeat());
            airplane.getSeats().getReservedSeats().set(bookingAdditionalDto.getReservedSeat() - 1, true);
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
}
