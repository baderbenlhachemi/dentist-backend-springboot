package ma.emsipfa.planetdentist.repository;

import ma.emsipfa.planetdentist.entity.Act;
import ma.emsipfa.planetdentist.entity.Consultation;
import ma.emsipfa.planetdentist.entity.Prescription;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface PrescriptionRepo extends JpaRepository<Prescription, Long> {

    @Query("SELECT p FROM Prescription p group by p.consultation.id")
    List<Object> groupByConsultation();
    List<Object> findByDate(Date date);
    List<Object> findByDateBetween(Date startDate, Date endDate);
    List<Consultation> findPrescriptionByConsultationId(Long id);


}
