package ma.emsipfa.planetdentist.repository;

import ma.emsipfa.planetdentist.entity.MedicationRule;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface MedicationRuleRepo extends JpaRepository<MedicationRule, Long> {
    List<Object> findByMinDrugUnits(Integer minDrugUnits);
    List<Object> findByMaxDrugUnits(Integer maxDrugUnits);
    List<Object> findByTimeRestriction(String timeRestriction);

    @Query("Select mr from MedicationRule mr where mr.prescription.id = :prescriptionId")
    List<Object> groupByPrescriptionId(@Param("prescriptionId") Long prescriptionId);
}

