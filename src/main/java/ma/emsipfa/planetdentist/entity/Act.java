package ma.emsipfa.planetdentist.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
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
@Table(name = "act")
public class Act extends BaseEntity {
    @Column(name = "label", nullable = false)
    private String label;

    @Column(name = "description", nullable = false)
    private String description;

    @Column(name = "base_price", nullable = false)
    private Double basePrice;

    @JsonIgnoreProperties("acts")
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "plan_category_id", nullable = false)
    private PlanCategory planCategory;

}
