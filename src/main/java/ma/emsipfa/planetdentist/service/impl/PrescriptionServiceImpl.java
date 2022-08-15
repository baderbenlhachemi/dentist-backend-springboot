package ma.emsipfa.planetdentist.service.impl;

import ma.emsipfa.planetdentist.entity.Consultation;
import ma.emsipfa.planetdentist.entity.Prescription;
import ma.emsipfa.planetdentist.repository.PrescriptionRepo;
import ma.emsipfa.planetdentist.service.PrescriptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.List;

@Service
public class PrescriptionServiceImpl implements PrescriptionService {

    private final PrescriptionRepo prescriptionRepo;

    @Autowired
    public PrescriptionServiceImpl(PrescriptionRepo prescriptionRepo) {
        this.prescriptionRepo = prescriptionRepo;
    }

    @Override
    public List<Prescription> getAll() {
        return prescriptionRepo.findAll();
    }

    @Override
    public Prescription save(Prescription baseEntity) {
        return prescriptionRepo.save(baseEntity);
    }

    @Override
    public Prescription getById(Long id) {
        return prescriptionRepo.findById(id).get();
    }

    @Override
    public void delete(Long id) {
        prescriptionRepo.deleteById(id);
    }

    @Override
    public List<Object> groupByConsultation() {
        return prescriptionRepo.groupByConsultation();
    }

    @Override
    public List<Object> findByDate(Date date) {
        return prescriptionRepo.findByDate(date);
    }

    @Override
    public List<Object> findByDateBetween(Date startDate, Date endDate) {
        return prescriptionRepo.findByDateBetween(startDate,endDate);
    }

    @Override
    public List<Consultation> findPrescriptionByConsultationId(Long id) {
        return prescriptionRepo.findPrescriptionByConsultationId(id);
    }
}
