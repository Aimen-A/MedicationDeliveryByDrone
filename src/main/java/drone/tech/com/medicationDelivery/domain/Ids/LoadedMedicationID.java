package drone.tech.com.medicationDelivery.domain.Ids;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Embeddable
@Data
@AllArgsConstructor
@EqualsAndHashCode
@NoArgsConstructor
public class LoadedMedicationID implements Serializable {
    private static final long serialVersionUID = 3072930286461033798L;

    @Column(name = "drone_id")
    private Long droneId;

    @Column(name = "medication_id")
    private Long medicationId;
}
