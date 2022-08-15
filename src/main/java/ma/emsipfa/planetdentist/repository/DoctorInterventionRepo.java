package ma.emsipfa.planetdentist.repository;

import ma.emsipfa.planetdentist.entity.DoctorIntervention;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface DoctorInterventionRepo extends JpaRepository<DoctorIntervention,Long> {
    @Query(value = "select * from doctor_intervention where consultation_id=?1",nativeQuery = true)
    List<DoctorIntervention> findDoctorInterventionByConsultation(Long id);
    List<DoctorIntervention> findDoctorInterventionByAct(Long id);


}
