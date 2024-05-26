package airportproject.start.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Timestamp;

@Setter
@Getter
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "booking")
public class Booking {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long bookingId;

    private Integer reservedSeat;
    private String firstName;
    private String lastName;
    private String gender;
    private Integer age;
    private String citizenship;
    private String passportId;

    private Timestamp bookingTime;

    private Long price;

    @ManyToOne
    @JoinColumn(name = "loyalityProgramId")
    LoyalityProgram loyalityProgram;

    @ManyToOne
    @JoinColumn(name = "flight_id")
    Flight flight;

    public Long getId(){
        return flight.getFlightId();
    }

    public Long getDiscount(){
        return loyalityProgram.getDiscountProcent();
    }
}
