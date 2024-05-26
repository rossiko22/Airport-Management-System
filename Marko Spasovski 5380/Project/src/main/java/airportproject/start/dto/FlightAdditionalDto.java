package airportproject.start.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Time;
import java.sql.Timestamp;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class FlightAdditionalDto {

    public Long flightProviderId;
    public Long originAirportId;
    public Long destinationAirportId;
    public Long airplaneId;
    public Timestamp arrivalTime;
    public Timestamp departureTime;
    private Long price;

}
