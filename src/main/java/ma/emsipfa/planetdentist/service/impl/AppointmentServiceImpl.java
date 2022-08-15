package ma.emsipfa.planetdentist.service.impl;

import ma.emsipfa.planetdentist.entity.Appointment;
import ma.emsipfa.planetdentist.entity.Consultation;
import ma.emsipfa.planetdentist.entity.EStatus;
import ma.emsipfa.planetdentist.repository.AppointmentRepo;
import ma.emsipfa.planetdentist.repository.ConsultationRepo;
import ma.emsipfa.planetdentist.service.AppointmentService;
import ma.emsipfa.planetdentist.service.ConsultationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.List;

@Service
public class AppointmentServiceImpl implements AppointmentService {
    private final AppointmentRepo appointmentRepo;

    @Autowired
    public AppointmentServiceImpl(AppointmentRepo appointmentRepo) {
        this.appointmentRepo = appointmentRepo;
    }

    @Override
    public List<Appointment> getAll() {
        return appointmentRepo.findAll();
    }

    @Override
    public Appointment save(Appointment baseEntity) {
        return appointmentRepo.save(baseEntity);
    }

    @Override
    public Appointment getById(Long id) {
        return appointmentRepo.findById(id).get();
    }


    @Override
    public void delete(Long id) {
        appointmentRepo.delete(getById(id));
    }
    public List<Appointment> getByPatient(Long id){
       return appointmentRepo.findAppointmentsByPatient(id);
    }

    @Override
    public List<Appointment> getPendingAppointments() {
        return appointmentRepo.findByStatus(EStatus.PENDING);
    }

    @Override
    public List<Appointment> getAcceptedAppointments() {
        return appointmentRepo.findByStatus(EStatus.ACCEPTED);
    }

    @Override
    public List<Appointment> getCompletedAppointments() {
        return appointmentRepo.findByStatus(EStatus.COMPLETED);
    }
}
