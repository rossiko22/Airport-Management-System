package airportproject.start.service;

import airportproject.start.dto.AirplaneDto;
import airportproject.start.dto.FlightDto;
import airportproject.start.entity.Flight;
import airportproject.start.exception.FlightDestinationException;
import airportproject.start.repo.FlightRepo;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class FlightService {
    @Autowired
    private FlightRepo flightRepository;

    public Optional<FlightDto> findFlight(Long flightId){
        return flightRepository.findFlight(flightId);
    }

    public List<FlightDto> getAllFlights(){
        return flightRepository.getAllFlights();
    }

    public AirplaneDto getAirplaneInfoByFlightId(Long flightId) {
        return flightRepository.getAirplaneInfoByFlightId(flightId);
    }
    public Optional<Flight> findFlightById(Long flightId){
        return flightRepository.findById(flightId);
    }

    public List<FlightDto> findAllFlightsFromTo(String originCountry, String destinationCountry) {
        List <FlightDto> flightDto = flightRepository.findAllFlightsFromTo(originCountry, destinationCountry);

        if(flightDto.isEmpty()){
            throw new FlightDestinationException("There are no flights for this line currently , try again later.");
        }else{
            return flightDto;
        }
    }

    public List<Flight> getFlights(){
        return flightRepository.findAll();
    }

    public Flight updateFlight(Flight flight) {
        return flightRepository.save(flight);
    }

    public Flight create(Flight flight){
        return flightRepository.save(flight);
    }

    public void delete(Long flightId) {
        flightRepository.deleteById(flightId);
    }
}
