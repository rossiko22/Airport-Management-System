package airportproject.start.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Timestamp;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class BookingAdditionalDto {

    private Long loyalityProgramId;
    private Long flightId;
    private Integer reservedSeat;
    private String firstName;
    private String lastName;
    private String gender;
    private Integer age;
    private String citizenship;
    private String passportId;

    private Timestamp bookingTime;


    public Long getId(){
        return flightId;
    }

}
