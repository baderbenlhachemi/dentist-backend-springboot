package ma.emsipfa.planetdentist.service.impl;

import ma.emsipfa.planetdentist.entity.MedicationRule;
import ma.emsipfa.planetdentist.repository.MedicationRuleRepo;
import ma.emsipfa.planetdentist.service.MedicationRuleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MedicationRuleServiceImpl implements MedicationRuleService {
    private final MedicationRuleRepo medicationRuleRepo;

    @Autowired
    public MedicationRuleServiceImpl(MedicationRuleRepo medicationRuleRepo) {
        this.medicationRuleRepo = medicationRuleRepo;
    }

    @Override
    public List<MedicationRule> getAll() {
        return medicationRuleRepo.findAll();
    }

    @Override
    public MedicationRule save(MedicationRule baseEntity) {
        return medicationRuleRepo.save(baseEntity);
    }

    @Override
    public MedicationRule getById(Long id) {
        return medicationRuleRepo.findById(id).get();
    }

    @Override
    public void delete(Long id) {
        medicationRuleRepo.deleteById(id);
    }

    @Override
    public List<Object> findByMinDrugUnits(Integer minDrugUnits) {
        return medicationRuleRepo.findByMinDrugUnits(minDrugUnits);
    }

    @Override
    public List<Object> findByMaxDrugUnits(Integer maxDrugUnits) {
        return medicationRuleRepo.findByMaxDrugUnits(maxDrugUnits);
    }

    @Override
    public List<Object> findByTimeRestriction(String timeRestriction) {
        return medicationRuleRepo.findByTimeRestriction(timeRestriction);
    }

    @Override
    public List<Object> groupByPrescriptionId(Long prescriptionId) {
        return medicationRuleRepo.groupByPrescriptionId(prescriptionId);
    }
}
