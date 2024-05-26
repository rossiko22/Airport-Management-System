package airportproject.start.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AirportAdditionalDto {
    public Long countryId;
    public String airportName;
    public String airportCity;
}
