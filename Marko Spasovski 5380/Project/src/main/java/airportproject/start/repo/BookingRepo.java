package airportproject.start.repo;

import airportproject.start.dto.BookingDto;
import airportproject.start.entity.Booking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookingRepo extends JpaRepository<Booking, Long> {

@Query("SELECT new airportproject.start.dto.BookingDto(p.flight.flightId ,p.bookingId, p.reservedSeat ,p.firstName , " +
        "p.lastName, p.gender, p.age, p.citizenship, p.passportId, p.bookingTime, p.loyalityProgram.loyalityProgram, p.price) " +
        "FROM Booking p WHERE p.flight.flightId = :flightId") // ss toj flight.flightId ga selektiramo foreign key i selektiramo od foreign key flightId row
    List<BookingDto> findBookingByFlightsId(@Param("flightId") Long flightId);

}
