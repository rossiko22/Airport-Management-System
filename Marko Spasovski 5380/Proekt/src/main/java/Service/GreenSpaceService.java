package Service;

import Repository.GreenSpaceRepository;
import com.example.greenspacereservation.model.GreenSpace;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class GreenSpaceService {

    private final GreenSpaceRepository greenSpaceRepository;

    @Autowired
    public GreenSpaceService(GreenSpaceRepository greenSpaceRepository) {
        this.greenSpaceRepository = greenSpaceRepository;
    }

    public List<GreenSpace> getAllGreenSpaces() {
        return greenSpaceRepository.findAll();
    }

    public Optional<GreenSpace> getGreenSpaceById(Long greenSpaceId) {
        return greenSpaceRepository.findById(greenSpaceId);
    }

    public GreenSpace createGreenSpace(GreenSpace greenSpace) {
        return greenSpaceRepository.save(greenSpace);
    }

    public void deleteGreenSpace(Long greenSpaceId) {
        greenSpaceRepository.deleteById(greenSpaceId);
    }
}
