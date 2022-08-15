package ma.emsipfa.planetdentist.entity;

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
@Table(name = "medical_history")
public class MedicalHistory extends BaseEntity {

    @Column(name = "md_1")
    private String md1;

    @Column(name = "md_2")
    private boolean md2;

    @Column(name = "md_3")
    private boolean md3;

    @Column(name = "md_4")
    private boolean md4;

    @Column(name = "md_5")
    private boolean md5;

    @Column(name = "md_6")
    private boolean md6;

    @Column(name = "md_7")
    private boolean md7;

    @Column(name = "md_8")
    private boolean md8;

    @Column(name = "md_9")
    private boolean md9;

    @Column(name = "md_10")
    private boolean md10;

    @OneToOne
    @JoinColumn(name = "patient_id")
    private Patient patient;

}
