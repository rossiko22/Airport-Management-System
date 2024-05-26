package airportproject.start.repo;

import airportproject.start.entity.LoyalityProgram;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LoyalityProgramRepo extends JpaRepository<LoyalityProgram, Long> {
}
