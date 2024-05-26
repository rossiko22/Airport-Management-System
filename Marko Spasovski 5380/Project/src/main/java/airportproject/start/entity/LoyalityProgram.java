package airportproject.start.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "loyalityProgram")
public class LoyalityProgram {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long loyalityProgramId;

    private String loyalityProgram; // '20% discount, 30.. to 60% discount'

    private Long discountProcent;
}
