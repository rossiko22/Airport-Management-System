package airportproject.start.controller;

import airportproject.start.dto.AirplaneDto;
import airportproject.start.dto.FlightDto;
import airportproject.start.dto.BookingDto;
import airportproject.start.dto.SeatsDto;
import airportproject.start.entity.Flight;
import airportproject.start.entity.FlightChange;
import airportproject.start.service.BookingService;
import airportproject.start.service.FlightChangeService;
import airportproject.start.service.FlightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class FlightController {

    @Autowired
    private FlightService flightService;

    @Autowired
    private BookingService bookingService;

    @Autowired
    private FlightChangeService flightChangeService;


    @GetMapping("/flights/{originCountry}/{destinationCountry}")
    List<FlightDto> findAllFlightsFromTo(@PathVariable String originCountry,@PathVariable String destinationCountry){
        return flightService.findAllFlightsFromTo(originCountry, destinationCountry);
    }

    @GetMapping("/flights")
    List<FlightDto> getAllFlights(){
        return flightService.getAllFlights();
    }

    @GetMapping("/flight/{id}")
    Optional<FlightDto> findFlights(@PathVariable("id") Long flightId){
        return flightService.findFlight(flightId);
    }

    @GetMapping("/flight/{flightId}/bookings")
    public List<BookingDto> getBookingByFlightsId(@PathVariable Long flightId) {
        return bookingService.getBookingByFlightsId(flightId);
    }

    @GetMapping("/flight/{flightId}/airplane")
    public AirplaneDto getAirplaneInfoByFlightId(@PathVariable Long flightId) {
        return flightService.getAirplaneInfoByFlightId(flightId) ;
    }

    @GetMapping("/flight/{flightId}/check-seat-availability/{seatId}")
    public String checkSeatAvailability(@PathVariable Long flightId, @PathVariable Long seatId) {
        Optional<Flight> flight = flightService.findFlightById(flightId);
        if(flight.isPresent()){
            if(!flight.get().getAirplane().getSeats().getReservedSeats().get(Math.toIntExact(seatId - 1))){
                return "The seat is available";
            }
        }
        return "The seat is not available";
    }

    @GetMapping("/flight/{flightId}/seats-availability")
    public SeatsDto getAvailableSeats(@PathVariable Long flightId){
        Optional<Flight> flight = flightService.findFlightById(flightId);
        if(flight.isPresent()){
            SeatsDto availableSeats = new SeatsDto();
            availableSeats.setReservedSeats(flight.get().getAirplane().getSeats().getReservedSeats());

            return availableSeats;
            }
            return null;
        }

    @GetMapping("/flight-changes")
    List<FlightChange> flightChanges(){
       return flightChangeService.getAllFlightChanges();
    }
    }
