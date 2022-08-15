package ma.emsipfa.planetdentist.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
@Table(name = "dental_clinic")
public class DentalClinic extends BaseEntity {
    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

    @Column(name = "logo")
    private String logo;

    @Column(name = "address", length = 1000)
    private String address;

    @Column(name = "primary_phone", unique = true, length = 20)
    private String primaryPhone;

    @Column(name = "secondary_phone", unique = true, length = 20)
    private String secondaryPhone;

    @Column(name = "email")
    private String email;

    @Column(name = "websiteUrl", length = 1000)
    private String websiteUrl;

    @Column(name = "facebookUrl", length = 1000)
    private String facebookUrl;

    @Column(name = "twitterUrl", length = 1000)
    private String twitterUrl;

    @Column(name = "instagramUrl", length = 1000)
    private String instagramUrl;

    @Column(name = "youtubeUrl", length = 1000)
    private String youtubeUrl;

    @Column(name = "linkedinUrl", length = 1000)
    private String linkedinUrl;

    @JsonIgnore
    @OneToMany(mappedBy = "dentalClinic")
    private List<Income> incomes;

    @JsonIgnore
    @OneToMany(mappedBy = "dentalClinic")
    private List<Charge> charges;

    @JsonIgnore
    @OneToMany(mappedBy = "dentalClinic")
    private List<Staff> staffs;
}
