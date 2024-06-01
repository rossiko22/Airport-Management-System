package airportproject.start.controller;

import airportproject.start.dto.AirplanesDto;
import airportproject.start.entity.Airplane;
import airportproject.start.service.AirplaneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class AirplaneController {

    @Autowired
    AirplaneService airplaneService;

    @GetMapping("/airplanes")
    List<AirplanesDto> getAllAirplanes(){
        return airplaneService.getAllAirplanes();
    }

    @GetMapping("/airplane/{id}")
    AirplanesDto findAirplaneById(@PathVariable("id") Long airplaneId){
        return airplaneService.findAirplaneById(airplaneId);
    }
}
