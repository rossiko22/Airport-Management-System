package Service;

import com.example.greenspacereservation.model.Maintenance;
import Repository.MaintenanceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class MaintenanceService {

    private final MaintenanceRepository maintenanceRepository;

    @Autowired
    public MaintenanceService(MaintenanceRepository maintenanceRepository) {
        this.maintenanceRepository = maintenanceRepository;
    }

    public List<Maintenance> getAllMaintenanceTasks() {
        return maintenanceRepository.findAll();
    }

    public Optional<Maintenance> getMaintenanceTaskById(Long maintenanceId) {
        return maintenanceRepository.findById(maintenanceId);
    }

    public Maintenance createMaintenanceTask(Maintenance maintenanceTask) {
        return maintenanceRepository.save(maintenanceTask);
    }

    public void deleteMaintenanceTask(Long maintenanceId) {
        maintenanceRepository.deleteById(maintenanceId);
    }
}
