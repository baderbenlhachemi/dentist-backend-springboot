package ma.emsipfa.planetdentist.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;

@JsonIdentityInfo(generator= ObjectIdGenerators.PropertyGenerator.class, property="id")
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Entity
@Table(name = "appointment")
public class Appointment extends BaseEntity {
    @Column(name = "date", nullable = false)
    private LocalDateTime date;

    @Column(name = "note", length = 1000, nullable = false)
    private String note;

    @Column(name = "is_urgent", nullable = false)
    private boolean isUrgent;

    @Enumerated(EnumType.STRING)
    @Column(name = "status", nullable = false)
    private EStatus status;

    //@JsonBackReference
    @ManyToOne
    @JoinColumn(name = "patient_id", nullable = false)
    private Patient patient;

    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "doctor_id", nullable = true)
    private Staff doctor;

    @JsonBackReference(value = "consultation-patient")
    @OneToOne(mappedBy = "appointment", cascade = CascadeType.ALL)
    private Consultation consultation;

}
