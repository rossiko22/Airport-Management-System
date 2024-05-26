package airportproject.start.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AirplanesDto {
    private Long airplaneId;
    private String airplaneType;
    private String airplaneModel;
}
