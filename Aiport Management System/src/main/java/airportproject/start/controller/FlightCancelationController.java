package airportproject.start.controller;

import airportproject.start.entity.Flight;
import airportproject.start.entity.FlightCancelation;
import airportproject.start.service.FlightCancelationService;
import airportproject.start.service.FlightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Timestamp;
import java.time.Instant;
import java.util.List;
import java.util.Optional;

@RestController
public class FlightCancelationController {

    @Autowired
    FlightCancelationService flightCancelationService;

    @Autowired
    FlightService flightService;

    @GetMapping("/cancel/flight/{flightId}")
    String cancelFlight(@PathVariable Long flightId){
        if(flightCancelationService.getFlightExistation(flightId)){
            Optional<Flight> flight = flightService.findFlightById(flightId);
            FlightCancelation flightCancelation = new FlightCancelation();

            flightCancelation.setFlightProvider(flight.get().getFlightProvider().getFlightProviderName());
            flightCancelation.setAirplaneModel(flight.get().getAirplane().getAirplaneType().getAirplaneModel().getAirplaneModelName());
            flightCancelation.setOriginCountry(flight.get().getOriginAirport().getCountry().getCountryName());
            flightCancelation.setDestinationCountry(flight.get().getDestinationAirport().getCountry().getCountryName());
            flightCancelation.setOriginAirport(flight.get().getOriginAirport().getAirportName());
            flightCancelation.setDestinationAirport(flight.get().getDestinationAirport().getAirportName());
            flightCancelation.setOriginAirportLocation(flight.get().getOriginAirport().getAirportCity());
            flightCancelation.setDestinationAirportLocation(flight.get().getDestinationAirport().getAirportCity());
            flightCancelation.setArrivalTime(flight.get().getArrivalTime());
            flightCancelation.setDepartureTime(flight.get().getDepartureTime());

            flightCancelation.setCancelationTime(Timestamp.from(Instant.now()));

            flightCancelationService.saveToCanceledFlights(flightCancelation);
            flightCancelationService.cancelFlight(flightId);
            return "Flight " + flightId + " cancelled.";
        }

        return "Flight with " + flightId + " does not exist";

    }

    @GetMapping("/flights-cancellations")
    List<FlightCancelation> getAllCancelledFlights(){
        return flightCancelationService.getAllCancelledFlights();
    }
}
