package airportproject.start.repo;

import airportproject.start.dto.AirplaneDto;
import airportproject.start.dto.FlightDto;
import airportproject.start.entity.Flight;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface FlightRepo extends JpaRepository<Flight, Long> {

    @Query("SELECT new airportproject.start.dto.AirplaneDto (p.flightId , p.airplane.airplaneId, p.airplane.airplaneType.airplaneTypeName , p.airplane.airplaneType.airplaneModel.airplaneModelName) FROM Flight p WHERE p.flightId = :flightId")
    AirplaneDto getAirplaneInfoByFlightId(@Param("flightId") Long flightId);

    @Query("SELECT new airportproject.start.dto.FlightDto(p.flightId, p.flightProvider.flightProviderName, " +
            "p.airplane.airplaneType.airplaneModel.airplaneModelName, " +
            "o.country.countryName, d.country.countryName, " +
            "o.airportName, d.airportName, o.airportCity, d.airportCity , p.arrivalTime, p.departureTime, p.price) " +
            "FROM Flight p " +
            "JOIN p.originAirport o " +
            "JOIN p.destinationAirport d")
    List<FlightDto> getAllFlights();

    @Query("SELECT new airportproject.start.dto.FlightDto(p.flightId, p.flightProvider.flightProviderName, " +
            "p.airplane.airplaneType.airplaneModel.airplaneModelName, " +
            "o.country.countryName, d.country.countryName, " +
            "o.airportName, d.airportName, o.airportCity, d.airportCity , p.arrivalTime, p.departureTime, p.price) " +
            "FROM Flight p " +
            "JOIN p.originAirport o " +
            "JOIN p.destinationAirport d " +
            "WHERE p.flightId = :flightId")
    Optional<FlightDto> findFlight(@Param("flightId") Long flightId);

    @Query("SELECT new airportproject.start.dto.FlightDto(p.flightId, p.flightProvider.flightProviderName, " +
            "p.airplane.airplaneType.airplaneModel.airplaneModelName, " +
            "o.country.countryName, d.country.countryName, " +
            "o.airportName, d.airportName, o.airportCity, d.airportCity , p.arrivalTime, p.departureTime, p.price) " +
            "FROM Flight p " +
            "JOIN p.originAirport o " +
            "JOIN p.destinationAirport d " +
            "WHERE o.country.countryName = :originCountry AND d.country.countryName = :destinationCountry")
    List<FlightDto> findAllFlightsFromTo(@Param("originCountry") String originCountry,@Param("destinationCountry") String destinationCountry);

}
