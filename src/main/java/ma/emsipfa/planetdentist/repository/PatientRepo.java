package ma.emsipfa.planetdentist.repository;

import ma.emsipfa.planetdentist.entity.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PatientRepo extends JpaRepository<Patient, Long> {

}
