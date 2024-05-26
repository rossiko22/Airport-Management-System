package airportproject.start.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AirplaneDto {
    private Long flightId;
    private Long airplaneId;
    private String airplaneType;
    private String airplaneModel;
}
