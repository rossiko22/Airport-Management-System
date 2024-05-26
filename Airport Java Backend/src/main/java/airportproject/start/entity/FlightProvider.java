package airportproject.start.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Table(name = "flightProvider")
@Entity
public class FlightProvider {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long flightProviderId;
    private String flightProviderName;
}
