package drone.tech.com.medicationDelivery.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import drone.tech.com.medicationDelivery.domain.enums.State;
import drone.tech.com.medicationDelivery.model.Drone;

@Repository
public interface DroneRepository extends CrudRepository<Drone, Long> {

    List<Drone> findByState(State state);

    Drone findBySerialNo(String serialNo);

    @Query("select d from Drone d")
    List<Drone> findAllDrone();

}
