package airportproject.start.repo;


import airportproject.start.dto.AirplanesDto;
import airportproject.start.entity.Airplane;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface AirplaneRepo extends JpaRepository<Airplane, Long> {

    @Query("SELECT new airportproject.start.dto.AirplanesDto(" +
            "a.airplaneId, at.airplaneTypeName, amm.airplaneModelName) " +
            "FROM Airplane a " +
            "JOIN a.airplaneType at " +
            "JOIN at.airplaneModel amm "
    )
    List<AirplanesDto> getAllAirplanes();


    @Query("SELECT new airportproject.start.dto.AirplanesDto("+
            "a.airplaneId, at.airplaneTypeName,amm.airplaneModelName) " +
            "FROM Airplane a " +
            "JOIN a.airplaneType at " +
            "JOIN at.airplaneModel amm " +
            "WHERE a.airplaneId = :airplaneId" )
    AirplanesDto findAirplaneById(@Param("airplaneId") Long airplaneId);

}
