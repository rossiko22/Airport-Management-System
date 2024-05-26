package airportproject.start.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table(name = "airplaneModel")
public class AirplaneModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long airplaneModel_id;

    private String airplaneModelName;
}
