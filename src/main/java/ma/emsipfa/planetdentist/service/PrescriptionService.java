package ma.emsipfa.planetdentist.service;
import ma.emsipfa.planetdentist.entity.Consultation;
import ma.emsipfa.planetdentist.entity.Prescription;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.List;

@Service
public interface PrescriptionService extends BaseInterfaceService<Prescription>{
    List<Object> groupByConsultation();
    List<Object> findByDate(Date date);
    List<Object> findByDateBetween(Date startDate, Date endDate);
    List<Consultation> findPrescriptionByConsultationId(Long id);

}
