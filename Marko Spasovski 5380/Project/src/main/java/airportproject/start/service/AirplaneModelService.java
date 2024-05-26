package airportproject.start.service;

import airportproject.start.entity.AirplaneModel;
import airportproject.start.repo.AirplaneModelRepo;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class AirplaneModelService {

    @Autowired
    AirplaneModelRepo airplaneModelRepository;

    public List<AirplaneModel> getAllAirplaneModels(){
        return airplaneModelRepository.findAll();
    }

    public AirplaneModel create(AirplaneModel airplaneModel){
        return airplaneModelRepository.save(airplaneModel);
    }

    public Optional<AirplaneModel> findAirplaneModelById(Long airplaneModelId){
        return airplaneModelRepository.findById(airplaneModelId);
    }

    public AirplaneModel update(AirplaneModel airplaneModel){
        return airplaneModelRepository.save(airplaneModel);
    }
}
