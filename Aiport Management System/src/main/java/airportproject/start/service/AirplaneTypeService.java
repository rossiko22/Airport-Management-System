package airportproject.start.service;

import airportproject.start.entity.AirplaneType;
import airportproject.start.repo.AirplaneTypeRepo;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Transactional
@Service
public class AirplaneTypeService {

    @Autowired
    AirplaneTypeRepo airplaneTypeRepository;

    public List<AirplaneType> getAllAirplaneTypes(){
        return airplaneTypeRepository.findAll();
    }

    public AirplaneType create(AirplaneType airplaneType){
        return airplaneTypeRepository.save(airplaneType);
    }

    public AirplaneType update(AirplaneType airplaneType){
        return airplaneTypeRepository.save(airplaneType);
    }

    public Optional<AirplaneType> getAirplaneTypeById(Long airplaneTypeId) {
        return airplaneTypeRepository.findById(airplaneTypeId);
    }
}

