package airportproject.start.controller;

import airportproject.start.entity.Country;
import airportproject.start.service.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;
@RestController
public class CountryController {

    @Autowired
    CountryService countryService;

    @GetMapping("/countries")
    List<Country> getAllCountries(){
        return countryService.getAllCountries();
    }
}
