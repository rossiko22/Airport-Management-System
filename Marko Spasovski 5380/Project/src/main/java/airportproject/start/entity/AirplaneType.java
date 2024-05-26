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
@Table(name = "airplaneType")
public class AirplaneType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long airplaneTypeId;
    private String airplaneTypeName;

    @ManyToOne
    @JoinColumn(name = "airplaneModel_id")
    AirplaneModel airplaneModel;

}
