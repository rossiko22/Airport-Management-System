package airportproject.start.repo;

import airportproject.start.entity.FlightProvider;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FlightProviderRepo extends JpaRepository<FlightProvider, Long> {
}
