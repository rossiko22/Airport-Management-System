package airportproject.start.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Timestamp;
import java.time.*;

@Getter
@Setter
@NoArgsConstructor
public class BookingDto {
    private Long flightId;
    private Long bookingId;
    private Integer reservedSeat;
    private String firstName;
    private String lastName;
    private String gender;
    private Integer age;
    private String citizenship;
    private String passportId;
    private LocalDateTime bookingTime;
    private String loyalProgram;
    private Long price;


    public BookingDto(Long flightId, Long bookingId, Integer reservedSeat, String firstName, String lastName, String gender, Integer age, String citizenship, String passportId, Timestamp bookingTime, String loyalProgram, Long price) {
        this.flightId = flightId;
        this.bookingId = bookingId;
        this.reservedSeat = reservedSeat;
        this.firstName = firstName;
        this.lastName = lastName;
        this.gender = gender;
        this.age = age;
        this.citizenship = citizenship;
        this.passportId = passportId;
        this.bookingTime = LocalDateTime.now();
        this.loyalProgram = loyalProgram;
        this.price = price;
    }
}
