package airportproject.start.controller;

import airportproject.start.entity.FlightProvider;
import airportproject.start.service.FlightProviderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
public class FlightProviderController {

    @Autowired
    FlightProviderService flightProviderService;

    @GetMapping("flight-providers")
    List<FlightProvider> getAllFlightProviders(){
        return flightProviderService.getAllFlightProviders();
    }
}
