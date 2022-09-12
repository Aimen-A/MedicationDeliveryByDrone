package drone.tech.com.medicationDelivery.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import javax.validation.Valid;
import drone.tech.com.medicationDelivery.domain.pojos.DroneRegistrationPojo;
import drone.tech.com.medicationDelivery.domain.pojos.LoadDroneRequest;
import drone.tech.com.medicationDelivery.domain.response.appResponse;
import drone.tech.com.medicationDelivery.service.DispatchService;

@RestController
@RequestMapping("drone/dispatch/")
public class DispatchController {

    @Autowired
    DispatchService dispatchService;

    @PostMapping(path = "/register", consumes = "application/json", produces = "application/json")
    public appResponse registerDrone(
            @Valid @RequestBody DroneRegistrationPojo droneRegistrationRequest) {
        return dispatchService.registerDrone(droneRegistrationRequest);

    }

    @GetMapping(path = "/available", consumes = "application/json", produces = "application/json")
    public appResponse getAllAvailableDroneForLoading() {
        return dispatchService.getAllAvailableDroneForLoading();

    }

    @GetMapping(path = "/checkBattery/{serialNumber}", consumes = "application/json", produces = "application/json")
    public appResponse checkBatteryOfDrone(@PathVariable("serialNumber") String serialNumber) {
        return dispatchService.checkBatteryOfDrone(serialNumber);

    }

    @PostMapping(path = "/loadDroneWithMedication", consumes = "application/json", produces = "application/json")
    public appResponse loadDroneWithMedication(
            @Valid @RequestBody LoadDroneRequest loadDroneRequest) {
        return dispatchService.loadDroneWithMedication(loadDroneRequest);

    }

    @GetMapping(path = "/checkLoadedMedication/{serialNumber}", consumes = "application/json", produces = "application/json")
    public appResponse CheckLoadedMedicationOfDrone(@PathVariable("serialNumber") String serialNumber) {
        return dispatchService.CheckLoadedMedicationOfDrone(serialNumber);

    }

}
