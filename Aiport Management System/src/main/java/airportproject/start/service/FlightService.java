package airportproject.start.service;

import airportproject.start.dto.AirplaneDto;
import airportproject.start.dto.FlightDto;
import airportproject.start.entity.Airplane;
import airportproject.start.entity.Airport;
import airportproject.start.entity.Flight;
import airportproject.start.entity.FlightProvider;
import airportproject.start.exception.FlightDestinationException;
import airportproject.start.repo.AirplaneRepo;
import airportproject.start.repo.AirportRepo;
import airportproject.start.repo.FlightProviderRepo;
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
    @Autowired
    private FlightProviderRepo flightProviderRepository;
    @Autowired
    private AirportRepo airportRepository;
    @Autowired
    private AirplaneRepo airplaneRepository;

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

        Optional<Flight> optionalExistingFlight = flightRepository.findById(flight.getFlightId());
        Optional<FlightProvider> optionalFlightProvider = flightProviderRepository.findById(flight.getFlightProvider().getFlightProviderId());
        Optional<Airport> optionalOriginAirport = airportRepository.findById(flight.getOriginAirport().getAirportId());
        Optional<Airport> optionalDestinationAirport = airportRepository.findById(flight.getOriginAirport().getAirportId());
        Optional<Airplane> optionalAirplane = airplaneRepository.findById(flight.getAirplane().getAirplaneId());

        Flight existingFlight = optionalExistingFlight.get();
        FlightProvider flightProvider = optionalFlightProvider.get();
        Airport originAirport = optionalOriginAirport.get();
        Airport destinationAirport = optionalDestinationAirport.get();
        Airplane airplane = optionalAirplane.get();

        existingFlight.setFlightProvider(flightProvider);
        existingFlight.setOriginAirport(originAirport);
        existingFlight.setDestinationAirport(destinationAirport);
        existingFlight.setAirplane(airplane);
        existingFlight.setArrivalTime(flight.getArrivalTime());
        existingFlight.setDepartureTime(flight.getDepartureTime());
        existingFlight.setPrice(flight.getPrice());
        return flightRepository.save(existingFlight);
    }

    public Flight create(Flight flight){
        return flightRepository.save(flight);
    }

    public String delete(Long flightId) {

        if(flightRepository.existsById(flightId)){
            flightRepository.deleteById(flightId);
            return "Flight with id " + flightId + " successfully deleted.";
        }
        return "Flight with that id does not exist.";
    }
}
