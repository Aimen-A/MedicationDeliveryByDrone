package drone.tech.com.medicationDelivery.service.implementations;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import drone.tech.com.medicationDelivery.domain.Ids.LoadedMedicationID;
import drone.tech.com.medicationDelivery.domain.enums.State;
import drone.tech.com.medicationDelivery.domain.pojos.DroneRegistrationPojo;
import drone.tech.com.medicationDelivery.domain.pojos.LoadDroneRequest;
import drone.tech.com.medicationDelivery.domain.response.appResponse;
import drone.tech.com.medicationDelivery.domain.values.StatusCode;
import drone.tech.com.medicationDelivery.exception.ApplicationException;
import drone.tech.com.medicationDelivery.service.DispatchService;
import drone.tech.com.medicationDelivery.model.Drone;
import drone.tech.com.medicationDelivery.model.LoadedMedication;
import drone.tech.com.medicationDelivery.model.Medication;
import drone.tech.com.medicationDelivery.repository.DroneRepository;
import drone.tech.com.medicationDelivery.repository.LoadedMedicationRepository;
import drone.tech.com.medicationDelivery.repository.MedicationRepository;

@Service
public class DispatchServiceImpl implements DispatchService {

    @Autowired
    DroneRepository droneRepository;

    @Autowired
    MedicationRepository medicationRepository;

    @Autowired
    LoadedMedicationRepository loadedMedicationRepository;

    @Override
    public appResponse registerDrone(DroneRegistrationPojo request) {

        try {
            Drone drone = new Drone();
            drone.setSerialNo(request.getSerialNo());
            drone.setModel(request.getModel());
            if (request.getState() == State.LOADING) {
                if (request.getBatteryCapacity() >= 25)
                    drone.setState(request.getState());
                else
                    return new appResponse(StatusCode.INSUFFICIENT_BATTERY_TO_BE_IN_LOADING_STATE, HttpStatus.FORBIDDEN,
                            "Drone Battery Is Insufficient To Be In Loading State",
                            (Object) drone);

            }
            drone.setState(request.getState());
            drone.setBatteryCapacity(request.getBatteryCapacity());
            if (request.getWeightLimit() <= 500)
                drone.setWeightLimit(request.getWeightLimit());
            else
                return new appResponse(StatusCode.EXCEED_WEIGHT, HttpStatus.BAD_REQUEST, "Weight Limit Exceeded",
                        (Object) request);

            droneRepository.save(drone);
            return new appResponse(StatusCode.SUCCESS, HttpStatus.CREATED, "Drone Registered Successful ",
                    (Object) drone);
        } catch (Exception ex) {

            return new appResponse(StatusCode.FAILURE, HttpStatus.BAD_REQUEST, "Drone Registration Unsuccessful",
                    (Object) request);

        }

    }

    @Override
    public appResponse getAllAvailableDroneForLoading() {
        try {

            // Logically, drones available for loading are of state idle,loading,returned
            List<Drone> dronesForLoading = droneRepository.findByState(State.IDLE);
            dronesForLoading.addAll(droneRepository.findByState(State.LOADING));
            dronesForLoading.addAll(droneRepository.findByState(State.RETURNED));
            return new appResponse(StatusCode.SUCCESS, HttpStatus.FOUND, "Available Drones For Loading Found",
                    (Object) dronesForLoading);
        } catch (Exception ex) {
            return new appResponse(StatusCode.FAILURE, HttpStatus.NOT_FOUND,
                    "Unable To Find Available Drones For Loading",
                    (Object) null);
        }
    }

    @Override
    public appResponse checkBatteryOfDrone(String serialNumber) {
        try {
            Drone drone = droneRepository.findBySerialNo(serialNumber);

            if (drone != null) {
                return new appResponse(StatusCode.SUCCESS, HttpStatus.CREATED, "Battery Level Found",
                        (Object) drone.getBatteryCapacity());
            } else {
                return new appResponse(StatusCode.FAILURE, HttpStatus.NOT_FOUND,
                        "Given Drone Not Found",
                        (Object) null);
            }
        } catch (Exception ex) {
            return new appResponse(StatusCode.FAILURE, HttpStatus.NOT_FOUND,
                    "Unablt to Find Battery Level",
                    (Object) null);
        }
    }

    @Override
    public appResponse loadDroneWithMedication(LoadDroneRequest loadDroneRequest) {
        try {
            float combineweight = 0;
            Drone drone = droneRepository.findBySerialNo(loadDroneRequest.getDroneSerialNo());
            Medication medicine = medicationRepository.findByCode(loadDroneRequest.getMedicationCode());

            if (drone != null && medicine != null) {

                // checking all loaded and request load medicine weight to see if it exceed
                // drone weight limit
                List<LoadedMedication> listOfMedication = loadedMedicationRepository
                        .findByDrone(droneRepository.findBySerialNo(loadDroneRequest.getDroneSerialNo()));
                if (!listOfMedication.isEmpty()) {
                    for (LoadedMedication li : listOfMedication)
                        combineweight += li.getMedication().getWeight();
                }
                combineweight += medicine.getWeight();
                if (combineweight > drone.getWeightLimit()) {
                    return new appResponse(StatusCode.EXCEED_WEIGHT, HttpStatus.FORBIDDEN,
                            "Can't Load Medicine on Drone, Weight Limit will Exceed",
                            (Object) null);

                }

                LoadedMedication loadedMedication = new LoadedMedication();
                loadedMedication.setId(new LoadedMedicationID());
                loadedMedication.setActive(true);
                loadedMedication.setDrone(drone);
                loadedMedication.setMedication(medicine);
                loadedMedicationRepository.save(loadedMedication);

                drone.setState(State.LOADING);
                droneRepository.save(drone);
                return new appResponse(StatusCode.SUCCESS, HttpStatus.CREATED,
                        "Medicine Loaded on Drone Successfully",
                        (Object) null);

            } else {
                return new appResponse(StatusCode.FAILURE, HttpStatus.NOT_FOUND,
                        "Drone/Medicine Not Found",
                        (Object) null);
            }
        } catch (Exception ex) {
            return new appResponse(StatusCode.FAILURE, HttpStatus.NOT_FOUND,
                    "Unable to Load Medicine on Drone",
                    (Object) null);
        }
    }

    @Override
    public appResponse CheckLoadedMedicationOfDrone(String serialNumber) {
        try {
            List<LoadedMedication> listOfMedication = loadedMedicationRepository
                    .findByDrone(droneRepository.findBySerialNo(serialNumber));
            if (!listOfMedication.isEmpty()) {
                return new appResponse(StatusCode.SUCCESS, HttpStatus.FOUND,
                        "Loaded Medication For Given Drone Found ",
                        (Object) listOfMedication);
            } else
                return new appResponse(StatusCode.FAILURE, HttpStatus.NOT_FOUND,
                        "No Medication is Loaded",
                        (Object) null);
        } catch (Exception ex) {

            return new appResponse(StatusCode.FAILURE, HttpStatus.NOT_FOUND,
                    "Loaded Medications of Drone Not Found",
                    (Object) null);

        }
    }
}
