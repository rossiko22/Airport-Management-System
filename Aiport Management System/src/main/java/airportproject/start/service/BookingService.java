package airportproject.start.service;

import airportproject.start.dto.BookingDto;
import airportproject.start.entity.Booking;
import airportproject.start.entity.Flight;
import airportproject.start.repo.BookingRepo;
import airportproject.start.repo.FlightRepo;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class BookingService {

    @Autowired
    BookingRepo bookingRepository;

    @Autowired
    FlightRepo flightRepository;


    public List<BookingDto> getBookingByFlightsId(Long flightId) {
        List<BookingDto> booking = bookingRepository.findBookingByFlightsId(flightId);
        return bookingRepository.findBookingByFlightsId(flightId);
    }

    public List<Booking> findAllBookings(){
        return bookingRepository.findAll();
    }

    public Booking create(Booking booking){
        return bookingRepository.save(booking);
    }

    public String checkSeatAvailability(Long flightId) {
        return null;
    }

    public Booking save(Booking booking) {
        return bookingRepository.save(booking);
    }

    public String delete(Long bookingId) {
        if(bookingRepository.existsById(bookingId)){
            bookingRepository.deleteById(bookingId);
            return "Booking with id " + bookingId + " successfully deleted.";
        }
        return "Booking with id " + bookingId + " does not exist";
    }




}
