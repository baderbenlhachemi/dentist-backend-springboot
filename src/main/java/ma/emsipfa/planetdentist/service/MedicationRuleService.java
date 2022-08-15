package ma.emsipfa.planetdentist.service;

import ma.emsipfa.planetdentist.entity.MedicationRule;
import ma.emsipfa.planetdentist.entity.User;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface MedicationRuleService extends BaseInterfaceService<MedicationRule>{
    List<Object> findByMinDrugUnits(Integer minDrugUnits);
    List<Object> findByMaxDrugUnits(Integer maxDrugUnits);
    List<Object> findByTimeRestriction(String timeRestriction);

    List<Object> groupByPrescriptionId(@Param("prescriptionId") Long prescriptionId);

}
