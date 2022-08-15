package ma.emsipfa.planetdentist.entity;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@JsonIdentityInfo(generator= ObjectIdGenerators.PropertyGenerator.class, property="id")
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Entity
@Table(name = "consultation")
public class Consultation extends BaseEntity {
    @Column(name = "date", nullable = false)
    private LocalDateTime date;

    @Column(name = "note", length = 1000, nullable = true)
    private String note;

    @JsonIgnore
    @JsonManagedReference(value = "consultation-patient")
    @OneToOne
    @JoinColumn(name = "appointment_id")
    private Appointment appointment;

}
