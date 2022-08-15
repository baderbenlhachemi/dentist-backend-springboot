package ma.emsipfa.planetdentist.repository;

import ma.emsipfa.planetdentist.entity.Appointment;
import ma.emsipfa.planetdentist.entity.EStatus;
import ma.emsipfa.planetdentist.entity.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface AppointmentRepo extends JpaRepository<Appointment, Long> {
    List<Appointment> findByStatus(EStatus status);
    
    @Query(value = "select * from appointment where patient_id=?1 and id not in (select appointment_id from consultation) order by date desc", nativeQuery = true)
    List<Appointment> findAppointmentsByPatient(Long id);
}
