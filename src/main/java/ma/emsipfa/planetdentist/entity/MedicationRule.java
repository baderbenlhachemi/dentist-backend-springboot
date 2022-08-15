package ma.emsipfa.planetdentist.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Entity
@Table(name = "medication_rule")
public class MedicationRule extends BaseEntity{

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "prescription_id", nullable = false)
    private Prescription prescription;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "medication_id", nullable = false)
    private Medication medication;

    @Column(name = "max_drug_units")
    private Integer maxDrugUnits;

    @Column(name = "min_drug_units")
    private Integer minDrugUnits;

    @Column(name = "time_restriction")
    private String timeRestriction;

    @Column(name = "food_restriction")
    private String foodRestriction;

}
