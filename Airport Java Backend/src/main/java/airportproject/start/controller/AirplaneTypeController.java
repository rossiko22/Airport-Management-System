package airportproject.start.controller;

import airportproject.start.entity.AirplaneType;
import airportproject.start.service.AirplaneTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
public class AirplaneTypeController {

    @Autowired
    AirplaneTypeService airplaneTypeService;

    @GetMapping("/airplane-types")
    List<AirplaneType> getAllAirplaneTypes(){
        return airplaneTypeService.getAllAirplaneTypes();
    }
}
