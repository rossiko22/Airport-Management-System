package airportproject.start.service;

import airportproject.start.dto.AirplanesDto;
import airportproject.start.entity.Airplane;
import airportproject.start.repo.AirplaneRepo;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class AirplaneService {

    @Autowired
    AirplaneRepo airplaneRepo;

    public AirplanesDto findAirplaneById(Long airplaneId){
        return airplaneRepo.findAirplaneById(airplaneId);
    }

    public List<AirplanesDto> getAllAirplanes(){
        return airplaneRepo.getAllAirplanes();
    }

    public List<Airplane> getAllTest(){
        return airplaneRepo.findAll();
    }

    public Airplane create(Airplane airplane){
        return airplaneRepo.save(airplane);
    }

    public Airplane update(Airplane airplane){
        return airplaneRepo.save(airplane);
    }

    public Optional<Airplane> findById(Long airplaneId){
        return airplaneRepo.findById(airplaneId);
    }
}
