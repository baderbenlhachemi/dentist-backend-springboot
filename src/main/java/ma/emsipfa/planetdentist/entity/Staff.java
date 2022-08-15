package ma.emsipfa.planetdentist.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Entity
@DiscriminatorValue("S")
public class Staff extends User {
    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "dental_clinic_id", nullable = true)
    private DentalClinic dentalClinic;

    @JsonManagedReference
    @JsonIgnore
    @OneToMany(mappedBy = "doctor", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Appointment> appointments;

    public Staff(String firstName, String lastName, String cin, String username, String email, String password) {
        super(firstName, lastName, cin, username, email, password);
    }

}
