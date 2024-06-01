package airportproject.start.controller;


import airportproject.start.dto.AirportDto;
import airportproject.start.service.AirportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;


@RestController
public class AirportController {

    @Autowired
    AirportService airportService;

    @GetMapping("/airports")
    List<AirportDto> findAllAirports(){
        return airportService.findAllAirports();
    }

    @GetMapping("/airports/{countryName}")
    List<AirportDto> findAllAirportByCountryName(@PathVariable String countryName){
        return airportService.findAllAirportsByCountryName(countryName);
    }
}
