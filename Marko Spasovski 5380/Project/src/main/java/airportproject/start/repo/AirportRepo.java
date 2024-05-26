package airportproject.start.repo;

import airportproject.start.dto.AirportDto;
import airportproject.start.entity.Airport;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

public interface AirportRepo extends JpaRepository<Airport,Long> {

    @Query("SELECT new airportproject.start.dto.AirportDto(a.airportId, a.airportName, c.countryName, a.airportCity) " +
            "FROM Airport a " +
            "JOIN a.country c")
    List<AirportDto> findAllAirports();

    @Query("SELECT new airportproject.start.dto.AirportDto(a.airportId, a.airportName, c.countryName, a.airportCity) " +
            "FROM Airport a " +
            "JOIN a.country c " +
            "WHERE c.countryName = :countryName")
    List<AirportDto> findAllAirportsByCountryName(@Param("countryName") String countryName);
}
