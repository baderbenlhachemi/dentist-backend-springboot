package ma.emsipfa.planetdentist.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
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
@DiscriminatorValue("P")
public class Patient extends User {
    @JsonManagedReference
    @JsonIgnore
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "financial_situation_id")
    private FinancialSituation financialSituation;

    //@JsonManagedReference
    @JsonIgnore
    @OneToMany(mappedBy = "patient", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Appointment> appointments;

    public Patient(String firstName, String lastName, String cin, String username, String email, String password, String phoneNumber) {
        super(firstName, lastName, cin, username, email, password, phoneNumber);
    }

    @Override
    public String toString() {
        return "Patient{" +
                "financialSituation=" + financialSituation +
                ", appointments=" + appointments +
                "} " + super.toString();
    }
}
