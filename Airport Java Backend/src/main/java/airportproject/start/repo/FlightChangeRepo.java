package airportproject.start.repo;

import airportproject.start.entity.FlightChange;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FlightChangeRepo extends JpaRepository<FlightChange, Long> {
}
