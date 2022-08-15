package ma.emsipfa.planetdentist.service;

import ma.emsipfa.planetdentist.entity.Appointment;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface AppointmentService extends BaseInterfaceService<Appointment> {
    List<Appointment> getPendingAppointments();

    List<Appointment> getAcceptedAppointments();

    List<Appointment> getCompletedAppointments();
    
    List<Appointment> getByPatient(Long id);
}
