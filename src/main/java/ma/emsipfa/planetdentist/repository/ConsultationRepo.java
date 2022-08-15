package ma.emsipfa.planetdentist.repository;

import ma.emsipfa.planetdentist.entity.Consultation;
import org.springframework.data.jpa.repository.JpaRepository;

import java.sql.Date;
import java.util.List;

public interface ConsultationRepo extends JpaRepository<Consultation, Long> {
    List<Consultation> findConsultationsByAppointmentId(Long id);
    List<Consultation> findConsultationsByDate(Date date);
    List<Consultation> findConsultationsByAppointment_PatientId(Long id);
}
