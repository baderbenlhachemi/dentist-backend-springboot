package ma.emsipfa.planetdentist.repository;

import ma.emsipfa.planetdentist.entity.MedicalHistory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface MedicalHistoryRepo extends JpaRepository<MedicalHistory, Long> {
    Optional<MedicalHistory> findByPatientId(Long patientId);
}