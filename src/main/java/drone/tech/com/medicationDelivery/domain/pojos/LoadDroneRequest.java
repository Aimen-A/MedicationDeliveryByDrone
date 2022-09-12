package drone.tech.com.medicationDelivery.domain.pojos;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import drone.tech.com.medicationDelivery.domain.enums.Model;
import drone.tech.com.medicationDelivery.domain.enums.State;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class LoadDroneRequest {

    @NotBlank
    @NotNull
    String droneSerialNo;

    @NotBlank
    @NotNull
    String MedicationCode;

}
