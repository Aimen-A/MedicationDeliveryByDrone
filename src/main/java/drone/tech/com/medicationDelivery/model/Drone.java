package drone.tech.com.medicationDelivery.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

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
@Entity
@Table(name = "drone", uniqueConstraints = { @UniqueConstraint(columnNames = { "serial_no" }) })
public class Drone extends BaseEntity {

    @Column(name = "serial_no", columnDefinition = "VARCHAR(100) NOT NULL")
    String serialNo;

    @Column(name = "model")
    private Model model;

    @Column(name = "state")
    private State state;

    @Column(name = "weight_limit")
    float weightLimit;

    @Column(name = "battery_capacity")
    Integer batteryCapacity;

}
