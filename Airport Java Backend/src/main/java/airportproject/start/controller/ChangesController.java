package airportproject.start.controller;

import airportproject.start.entity.Flight;
import airportproject.start.entity.FlightChange;
import airportproject.start.service.FlightChangeService;
import airportproject.start.service.FlightService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/change")
public class ChangesController {

    @Autowired
    FlightChangeService flightChangeService;

    @Autowired
    FlightService flightService;

    @PutMapping("/flight")
    @Transactional
    Flight flightChange(@RequestBody Flight flight){

        FlightChange flightChange = new FlightChange();

        flightChange.setFlightId(flight.getFlightId());
        flightChange.setFlightProvider(flight.getFlightProvider().getFlightProviderId());
        flightChange.setOriginAirport(flight.getOriginAirport().getAirportId());
        flightChange.setDestinationAirport(flight.getDestinationAirport().getAirportId());
        flightChange.setAirplaneId(flight.getAirplane().getAirplaneId());
        flightChange.setNewArrivalTime(flight.getArrivalTime()); // ovoj treba da se smisli kako kje pisue dali vreme kd e smeneto ili na kolko
        flightChange.setNewDepartureTime(flight.getDepartureTime());


        flightChangeService.saveFlightInFlightChanges(flightChange);
        return flightService.updateFlight(flight);
    }
}
