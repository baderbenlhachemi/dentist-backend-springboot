package ma.emsipfa.planetdentist.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
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
@Table(name = "doctor_intervention")
public class DoctorIntervention extends BaseEntity {
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "consultation_id", nullable = false)
    private Consultation consultation;

    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "act_id", nullable = false)
    private Act act;

    @Column(name = "worked_on_teeth", nullable = false)
    private String workedOnTeeth;

    @Column(name = "note", nullable = false)
    private String note;

    @Column(name = "price", nullable = false)
    private Double price;

}
