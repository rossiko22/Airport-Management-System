package airportproject.start.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Timestamp;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Table(name = "flight")
@Entity
public class Flight {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long flightId;

    @ManyToOne
    @JoinColumn(name = "flightProvider_id")
    FlightProvider flightProvider;

    @ManyToOne
    @JoinColumn(name = "originAirport")
    Airport originAirport;

    @ManyToOne
    @JoinColumn(name = "destinationAirport")
    Airport destinationAirport;

    private Timestamp arrivalTime;
    private Timestamp departureTime;

    @ManyToOne
    @JoinColumn(name = "airplane_id")
    Airplane airplane;

    private Long price;
}
