package airportproject.start.repo;

import airportproject.start.entity.Seats;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SeatsRepo extends JpaRepository<Seats, Long> {
}
