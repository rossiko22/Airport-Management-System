package airportproject.start.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Timestamp;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class FlightDto {
    private Long flightId;
    private String flightProvider;
    private String airplaneModel;

    private String originCountry;
    private String destinationCountry;

    private String originAirport;
    private String destinationAirport;

    private String originAirportLocation;
    private String destinationAirportLocation;

    private Timestamp arrivalTime;
    private Timestamp destinationTime;

    private Long price;
}
