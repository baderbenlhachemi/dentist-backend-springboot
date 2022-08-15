package ma.emsipfa.planetdentist.service.impl;

import ma.emsipfa.planetdentist.entity.Consultation;
import ma.emsipfa.planetdentist.repository.ConsultationRepo;
import ma.emsipfa.planetdentist.service.ConsultationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.List;
import java.util.Optional;

@Service
public class ConsultationServiceImpl implements ConsultationService {
    private final ConsultationRepo consultationRepo;

    @Autowired
    public ConsultationServiceImpl(ConsultationRepo consultationRepo) {
        this.consultationRepo = consultationRepo;
    }

    @Override
    public List<Consultation> getAll() {
        return consultationRepo.findAll();
    }

    @Override
    public Consultation save(Consultation baseEntity) {
        return consultationRepo.save(baseEntity);
    }

    @Override
    public Consultation getById(Long id) {
        return consultationRepo.findById(id).get();
    }

    @Override
    public void delete(Long id) {
        consultationRepo.delete(getById(id));
    }

    @Override
    public List<Consultation> getConsultationsByAppointment(Long id) {
        return consultationRepo.findConsultationsByAppointmentId(id);
    }

    @Override
    public List<Consultation> getConsultationsByDate(Date date) {
        return consultationRepo.findConsultationsByDate(date);
    }

    @Override
    public List<Consultation> getConsultationsByPatient(Long id) {
        return consultationRepo.findConsultationsByAppointment_PatientId(id);
    }
}
