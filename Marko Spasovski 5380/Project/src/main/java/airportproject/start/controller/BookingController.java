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


//    @PostMapping("/flight")
//    public Booking create(@RequestBody Booking booking) {
//        Optional<Flight> flightOptional = flightService.findFlightById(booking.getId());
//        if (!flightOptional.isPresent()) {
//            throw new BookingException("Flight not found");
//        }
//        Flight flight = flightOptional.get();
//
//        Optional<LoyalityProgram> loyalityProgramOptional = loyalityProgramService.getById(booking.getLoyalityProgram().getLoyalityProgramId());
//        LoyalityProgram loyalityProgram = loyalityProgramOptional.orElse(null);
//
//        booking.setBookingTime(Timestamp.from(Instant.now()));
//
//        long price = flight.getPrice();
//        if (loyalityProgram != null) {
//            long discountPercentage = loyalityProgram.getDiscountProcent();
//            price -= (price / division) * discountPercentage;
//        }
//        booking.setPrice(price);
//
//        Airplane airplane = flight.getAirplane();
//        if (airplane.getSeats().getReservedSeats().get(booking.getReservedSeat() - 1)) {
//            throw new BookingException("The seat " + booking.getReservedSeat() + " is already reserved");
//        } else {
//            airplane.getSeats().getReservedSeats().set(booking.getReservedSeat() - 1, true);
//        }
//
//        return bookingService.save(booking);
//    }
//
//    private static final int division = 100;

}