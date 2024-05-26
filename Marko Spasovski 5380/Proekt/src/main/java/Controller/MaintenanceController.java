package Controller;

import com.example.greenspacereservation.model.Maintenance;
import Service.MaintenanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/maintenance")
public class MaintenanceController {

    private final MaintenanceService maintenanceService;

    @Autowired
    public MaintenanceController(MaintenanceService maintenanceService) {
        this.maintenanceService = maintenanceService;
    }

    @GetMapping
    public ResponseEntity<List<Maintenance>> getAllMaintenanceTasks() {
        List<Maintenance> maintenanceTasks = maintenanceService.getAllMaintenanceTasks();
        return new ResponseEntity<>(maintenanceTasks, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Maintenance> getMaintenanceTaskById(@PathVariable("id") Long maintenanceId) {
        return maintenanceService.getMaintenanceTaskById(maintenanceId)
                .map(maintenance -> new ResponseEntity<>(maintenance, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping
    public ResponseEntity<Maintenance> createMaintenanceTask(@RequestBody Maintenance maintenanceTask) {
        Maintenance createdMaintenanceTask = maintenanceService.createMaintenanceTask(maintenanceTask);
        return new ResponseEntity<>(createdMaintenanceTask, HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMaintenanceTask(@PathVariable("id") Long maintenanceId) {
        maintenanceService.deleteMaintenanceTask(maintenanceId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}

