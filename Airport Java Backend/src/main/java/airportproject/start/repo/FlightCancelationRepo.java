package airportproject.start.repo;

import airportproject.start.entity.FlightCancelation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FlightCancelationRepo extends JpaRepository<FlightCancelation, Long> {


    //Da sejvne kd ga izbrise za kd se izbrise da ga snema ama da se addne u flight canclations
}
