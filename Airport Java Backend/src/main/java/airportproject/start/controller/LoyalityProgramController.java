package airportproject.start.controller;

import airportproject.start.entity.LoyalityProgram;
import airportproject.start.service.LoyalityProgramService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;
@RestController
public class LoyalityProgramController {

    @Autowired
    LoyalityProgramService loyalityProgramService;

    @GetMapping("/loyality-programs")
    List<LoyalityProgram> getAllLoyalityPrograms(){
        return loyalityProgramService.getAllLoyalityPrograms();
    }
}
