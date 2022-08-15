package ma.emsipfa.planetdentist.service;

import ma.emsipfa.planetdentist.entity.MedicalHistory;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public interface MedicalHistoryService extends BaseInterfaceService<MedicalHistory> {
    Optional<MedicalHistory> getByPatientId(Long id);

}

