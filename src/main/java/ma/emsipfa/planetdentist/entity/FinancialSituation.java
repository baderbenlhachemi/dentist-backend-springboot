package ma.emsipfa.planetdentist.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
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
@Table(name = "financial_situation")
public class FinancialSituation extends BaseEntity {
    @Column(name = "total_to_pay")
    private double totalToPay;

    @Column(name = "total_paid")
    private Double totalPaid;

    @Column(name = "total_remaining")
    private Double totalRemaining;

    @JsonBackReference
    @OneToOne(mappedBy = "financialSituation")
    private Patient patient;

    @JsonManagedReference
    @OneToMany(mappedBy = "financialSituation")
    private List<Bill> bills;
}
