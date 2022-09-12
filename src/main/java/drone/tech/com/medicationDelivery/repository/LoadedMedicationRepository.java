package drone.tech.com.medicationDelivery.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import drone.tech.com.medicationDelivery.model.Drone;
import drone.tech.com.medicationDelivery.model.LoadedMedication;
import drone.tech.com.medicationDelivery.model.Medication;

@Repository
public interface LoadedMedicationRepository extends CrudRepository<LoadedMedication, Long> {

    List<LoadedMedication> findByDrone(Drone drone);
}
