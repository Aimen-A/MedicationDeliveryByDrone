package drone.tech.com.medicationDelivery.scheduler;

import java.util.Iterator;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import drone.tech.com.medicationDelivery.model.Drone;
import drone.tech.com.medicationDelivery.repository.DroneRepository;

@Component
public class batteryLevelCheckScheduler {

    static final Logger log = LoggerFactory.getLogger(batteryLevelCheckScheduler.class);

    @Autowired
    DroneRepository droneRepository;

    @Scheduled(fixedDelayString = "PT04M", initialDelayString = "PT1M") // 1 minute after running the app, scheduler
                                                                        // will run every 15 minutes
    public void DroneBatteryChecker() throws InterruptedException {

        List<Drone> drones = droneRepository.findAllDrone();
        for (Drone drone : drones) {
            log.info("Drone SerialNumber " + drone.getSerialNo() + " Battery Level"
                    + drone.getBatteryCapacity());
            log.debug("Drone SerialNumber " + drone.getSerialNo() + " Battery Level"
                    + drone.getBatteryCapacity());
        }
        Thread.sleep(10000);

    }

}
