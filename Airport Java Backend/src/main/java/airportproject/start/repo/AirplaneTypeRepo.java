package airportproject.start.repo;

import airportproject.start.entity.AirplaneType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AirplaneTypeRepo extends JpaRepository<AirplaneType, Long> {
}
