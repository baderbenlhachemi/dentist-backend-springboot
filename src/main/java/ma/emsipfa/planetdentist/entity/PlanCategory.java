package ma.emsipfa.planetdentist.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Entity
@Table(name = "plan_category")
public class PlanCategory extends BaseEntity {
    @Column(name = "name")
    private String name;

    @JsonIgnoreProperties("planCategory")
    @OneToMany(mappedBy = "planCategory")
    private List<Act> acts;

}
