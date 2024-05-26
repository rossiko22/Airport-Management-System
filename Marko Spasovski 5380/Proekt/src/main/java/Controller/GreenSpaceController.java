package Controller;

import com.example.greenspacereservation.model.GreenSpace;
import Service.GreenSpaceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/greenspaces")
public class GreenSpaceController {

    private final GreenSpaceService greenSpaceService;

    @Autowired
    public GreenSpaceController(GreenSpaceService greenSpaceService) {
        this.greenSpaceService = greenSpaceService;
    }

    @GetMapping
    public ResponseEntity<List<GreenSpace>> getAllGreenSpaces() {
        List<GreenSpace> greenSpaces = greenSpaceService.getAllGreenSpaces();
        return new ResponseEntity<>(greenSpaces, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<GreenSpace> getGreenSpaceById(@PathVariable("id") Long greenSpaceId) {
        return greenSpaceService.getGreenSpaceById(greenSpaceId)
                .map(greenSpace -> new ResponseEntity<>(greenSpace, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping
    public ResponseEntity<GreenSpace> createGreenSpace(@RequestBody GreenSpace greenSpace) {
        GreenSpace createdGreenSpace = greenSpaceService.createGreenSpace(greenSpace);
        return new ResponseEntity<>(createdGreenSpace, HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteGreenSpace(@PathVariable("id") Long greenSpaceId) {
        greenSpaceService.deleteGreenSpace(greenSpaceId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
