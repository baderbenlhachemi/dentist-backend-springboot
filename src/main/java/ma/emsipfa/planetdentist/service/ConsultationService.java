package ma.emsipfa.planetdentist.service;

import ma.emsipfa.planetdentist.entity.Consultation;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.List;

@Service
public interface ConsultationService extends BaseInterfaceService<Consultation> {
    List<Consultation> getConsultationsByAppointment(Long id);
    List<Consultation> getConsultationsByDate(Date date);
    List<Consultation> getConsultationsByPatient(Long id);
}
