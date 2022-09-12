package drone.tech.com.medicationDelivery.service;

import drone.tech.com.medicationDelivery.domain.pojos.DroneRegistrationPojo;
import drone.tech.com.medicationDelivery.domain.pojos.LoadDroneRequest;
import drone.tech.com.medicationDelivery.domain.response.appResponse;

public interface DispatchService {

    appResponse registerDrone(DroneRegistrationPojo request);

    appResponse getAllAvailableDroneForLoading();

    appResponse checkBatteryOfDrone(String serialNumber);

    appResponse loadDroneWithMedication(LoadDroneRequest loadDroneRequest);

    appResponse CheckLoadedMedicationOfDrone(String serialNumber);
}
