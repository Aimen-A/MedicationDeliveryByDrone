package drone.tech.com.medicationDelivery.model;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import drone.tech.com.medicationDelivery.domain.Ids.LoadedMedicationID;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "loaded_medication")
public class LoadedMedication {

    @EmbeddedId
    LoadedMedicationID id;

    @JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("droneId")
    private Drone drone;

    @JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("medicationId")
    private Medication medication;

    @Column(name = "create_date_time", nullable = false)
    @CreationTimestamp
    private LocalDateTime createDateTime;

    @Column(name = "update_date_time", nullable = false)
    @UpdateTimestamp
    private LocalDateTime updateDateTime;

    private boolean isActive;

}
