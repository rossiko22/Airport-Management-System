package airportproject.start.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Timestamp;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class FlightCancelation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long flightCancelationId;

    private String flightProvider;
    private String airplaneModel;

    private String originCountry;
    private String destinationCountry;

    private String originAirport;
    private String destinationAirport;

    private String originAirportLocation;
    private String destinationAirportLocation;

    private Timestamp arrivalTime;
    private Timestamp departureTime;

    private Timestamp cancelationTime;

    //Raboti samo ima bugovi malce kd ne uspee flight cancel u svak slucaj gu sejvnue iako ne treba

 // Da se smisli kako da se napravi cancelation time da bide u vreme kd e kreirana entity , ili kd e izbrisan let da se setne;

}
