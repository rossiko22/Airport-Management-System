package airportproject.start.service;


import airportproject.start.dto.BookingDto;
import airportproject.start.entity.Flight;
import airportproject.start.entity.FlightCancelation;
import airportproject.start.repo.BookingRepo;
import airportproject.start.repo.FlightCancelationRepo;
import airportproject.start.repo.FlightRepo;
import jakarta.transaction.Transactional;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Transactional

public class FlightCancelationService {
    @Autowired
    FlightRepo flightRepository;

    @Autowired
    BookingRepo bookingRepository;

    @Autowired
    FlightCancelationRepo flightCancelationRepository;

    public void cancelFlight(Long flightId){
        Optional<Flight> flight = flightRepository.findById(flightId);
        List<BookingDto> bookings = bookingRepository.findBookingByFlightsId(flight.get().getFlightId());
        for(BookingDto bookingDto : bookings){
            bookingRepository.deleteById(bookingDto.getBookingId());
        }
        flightRepository.deleteById(flightId);
    }

    public FlightCancelation saveToCanceledFlights(FlightCancelation flightCancelation){
        return flightCancelationRepository.save(flightCancelation);
    }

    public List<FlightCancelation> getAllCancelledFlights() {
        return flightCancelationRepository.findAll();
    }

    public Boolean getFlightExistation(Long flightId){
        return flightRepository.existsById(flightId);
    }
}
