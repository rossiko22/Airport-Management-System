package airportproject.start.service;

import airportproject.start.entity.LoyalityProgram;
import airportproject.start.repo.LoyalityProgramRepo;
import jakarta.transaction.Transactional;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Transactional
public class LoyalityProgramService {

    @Autowired
    LoyalityProgramRepo loyalityProgramRepository;

    public Optional<LoyalityProgram> getById(Long loyalityProgramId){
        return loyalityProgramRepository.findById(loyalityProgramId);
    }
    public LoyalityProgram create(LoyalityProgram loyalityProgram){
        return loyalityProgramRepository.save(loyalityProgram);
    }

    public List<LoyalityProgram> getAllLoyalityPrograms() {
        return loyalityProgramRepository.findAll();
    }
}
