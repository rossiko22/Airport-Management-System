package airportproject.start.repo;

import airportproject.start.entity.AirplaneModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AirplaneModelRepo extends JpaRepository<AirplaneModel, Long> {
}
