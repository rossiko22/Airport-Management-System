package airportproject.start.service;

import airportproject.start.entity.FlightProvider;
import airportproject.start.repo.FlightProviderRepo;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Transactional
@Service
public class FlightProviderService {
    @Autowired
    FlightProviderRepo flightProviderRepository;

    public List<FlightProvider> getAllFlightProviders(){
        return flightProviderRepository.findAll();
    }

    public FlightProvider create(FlightProvider flightProvider){
        return flightProviderRepository.save(flightProvider);
    }

    public FlightProvider update(FlightProvider flightProvider){
        return flightProviderRepository.save(flightProvider);
    }

    public Optional<FlightProvider> getFlightProviderById(Long flightProviderId){
        return flightProviderRepository.findById(flightProviderId);
    }
}
