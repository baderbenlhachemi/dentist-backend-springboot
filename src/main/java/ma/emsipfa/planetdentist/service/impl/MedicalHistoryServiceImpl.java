package ma.emsipfa.planetdentist.service.impl;

import ma.emsipfa.planetdentist.entity.MedicalHistory;
import ma.emsipfa.planetdentist.repository.MedicalHistoryRepo;
import ma.emsipfa.planetdentist.service.MedicalHistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MedicalHistoryServiceImpl implements MedicalHistoryService {
    private final MedicalHistoryRepo medicalHistoryRepo;

    @Autowired
    public MedicalHistoryServiceImpl(MedicalHistoryRepo medicalHistoryRepo) {
        this.medicalHistoryRepo = medicalHistoryRepo;
    }

    @Override
    public List<MedicalHistory> getAll() {
        return medicalHistoryRepo.findAll();
    }

    @Override
    public MedicalHistory save(MedicalHistory medicalHistory) {
        return medicalHistoryRepo.save(medicalHistory);
    }

    @Override
    public MedicalHistory getById(Long id) {
        return medicalHistoryRepo.findById(id).get();
    }

    @Override
    public void delete(Long id) {
        medicalHistoryRepo.deleteById(id);
    }

    @Override
    public Optional<MedicalHistory> getByPatientId(Long id) {
        return medicalHistoryRepo.findByPatientId(id);
    }
}

