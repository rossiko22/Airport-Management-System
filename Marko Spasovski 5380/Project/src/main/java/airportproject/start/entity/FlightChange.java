package airportproject.start.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Timestamp;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class FlightChange {

    //Ovoj da se dzirne samo test e ne e dobro

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long flightChangeId;

    private Long flightId;
    private Long flightProvider;
    private Long airplaneId;
    private Long originAirport;
    private Long destinationAirport;
    private Timestamp newArrivalTime;
    private Timestamp newDepartureTime;
}
