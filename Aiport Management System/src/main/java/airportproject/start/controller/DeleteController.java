package airportproject.start.controller;

import airportproject.start.entity.Country;
import airportproject.start.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/delete")
public class DeleteController {


    @Autowired
    FlightService flightService;
    @Autowired
    BookingService bookingService;


    @DeleteMapping("/flight/{id}")
    public String deleteFlight(@PathVariable("id") Long flightId){
        flightService.delete(flightId);
        return "Flight with id " + flightId + " successfully deleted.";
    }

    @DeleteMapping("/booking/{id}")
    public String deleteBooking(@PathVariable("id") Long bookingId){
        bookingService.delete(bookingId);
        return "Booking with id " + bookingId + " successfully deleted.";
    }

}
