package airportproject.start.controller;

import airportproject.start.entity.Seats;
import airportproject.start.service.SeatsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
public class SeatsController {

    @Autowired
    SeatsService seatsService;

    @GetMapping("/seats")
    List<Seats> getAllSeats(){
        return seatsService.getAllSeats();
    }
}
