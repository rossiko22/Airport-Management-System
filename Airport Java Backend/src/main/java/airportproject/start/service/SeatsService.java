package airportproject.start.service;

import airportproject.start.entity.Seats;
import airportproject.start.repo.SeatsRepo;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class SeatsService {

    @Autowired
    SeatsRepo seatsRepository;

    public List<Seats> getAllSeats(){
        return seatsRepository.findAll();
    }

    public Seats create(Integer numberOfSeats){

        List<Boolean> booleanList = new ArrayList<Boolean>(numberOfSeats);
        for(int i = 0; i < numberOfSeats; i++){
            booleanList.add(false);
        }

        Seats seats = new Seats();
        seats.setReservedSeats(booleanList);

        return seatsRepository.save(seats);
    }

    public Seats update(Seats seats){
        return seatsRepository.save(seats);
    }

    public Optional<Seats> getSeatsById(Long seatsId) {
        return seatsRepository.findById(seatsId);
    }
}
