package airportproject.start.service;

import airportproject.start.entity.FlightChange;
import airportproject.start.repo.FlightChangeRepo;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class FlightChangeService {

    @Autowired
    FlightChangeRepo flightChangeRepository;

    public FlightChange saveFlightInFlightChanges(FlightChange flightChange){
        return flightChangeRepository.save(flightChange);
    }

    public List<FlightChange> getAllFlightChanges(){
        return flightChangeRepository.findAll();
    }


}
