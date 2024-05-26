package airportproject.start.service;

import airportproject.start.dto.BookingDto;
import airportproject.start.entity.Booking;
import airportproject.start.repo.BookingRepo;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class BookingService {

    @Autowired
    BookingRepo bookingRepository;

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

    public void delete(Long bookingId) {
        bookingRepository.deleteById(bookingId);
    }
}
