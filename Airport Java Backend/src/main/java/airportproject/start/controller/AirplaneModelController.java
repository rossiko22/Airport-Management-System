package airportproject.start.controller;

import airportproject.start.entity.AirplaneModel;
import airportproject.start.service.AirplaneModelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
public class AirplaneModelController {

    @Autowired
    AirplaneModelService airplaneModelService;

    @GetMapping("/airplane-models")
    List<AirplaneModel> getAllAirplaneModels(){
        return airplaneModelService.getAllAirplaneModels();
    }

}
