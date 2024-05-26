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

@Table(name = "airplane")
@Entity
public class Airplane {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long airplaneId;

    @ManyToOne
    @JoinColumn(name = "airplaneType_id")
    AirplaneType airplaneType;

    @ManyToOne
    @JoinColumn(name = "seats_id")
    Seats seats;

}