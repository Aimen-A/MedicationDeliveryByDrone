package drone.tech.com.medicationDelivery.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import drone.tech.com.medicationDelivery.model.Medication;

@Repository
public interface MedicationRepository extends CrudRepository<Medication, Long> {

    Medication findByCode(String code);
}
