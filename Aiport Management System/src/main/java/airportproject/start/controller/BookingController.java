package airportproject.start.controller;

import airportproject.start.dto.BookingAdditionalDto;
import airportproject.start.entity.Airplane;
import airportproject.start.entity.Booking;
import airportproject.start.entity.Flight;
import airportproject.start.entity.LoyalityProgram;
import airportproject.start.exception.BookingException;
import airportproject.start.service.BookingService;
import airportproject.start.service.FlightService;
import airportproject.start.service.LoyalityProgramService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;
import java.time.Instant;
import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/book")
public class BookingController {

    @Autowired
    BookingService bookingService;

    @Autowired
    FlightService flightService;

    @Autowired
    LoyalityProgramService loyalityProgramService;

    @GetMapping
    List<Booking> findAll(){
        return bookingService.findAllBookings();
    }


}