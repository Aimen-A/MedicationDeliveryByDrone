package drone.tech.com.medicationDelivery.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "medication", uniqueConstraints = { @UniqueConstraint(columnNames = { "code" }) })
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Medication extends BaseEntity {

    @Column(name = "name")
    String name;

    @Column(name = "weight")
    float weight;

    @Column(name = "code")
    String code;

    @Column(name = "image")
    String image;

}
