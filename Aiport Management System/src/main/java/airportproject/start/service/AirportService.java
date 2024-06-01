package airportproject.start.service;

import airportproject.start.dto.AirportDto;
import airportproject.start.entity.Airport;
import airportproject.start.repo.AirportRepo;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class AirportService {

    @Autowired
    AirportRepo airportRepository;

    public List<AirportDto> findAllAirports(){
        return airportRepository.findAllAirports();
    }

    public List<AirportDto> findAllAirportsByCountryName(String countryName) {
        return airportRepository.findAllAirportsByCountryName(countryName);
    }

    public Airport create(Airport airport){
        return airportRepository.save(airport);
    }

    public Airport update(Airport airport){
        return airportRepository.save(airport);
    }

    public Optional<Airport> findAirportById(Long airportId){
        return airportRepository.findById(airportId);
    }
}
