package ma.emsipfa.planetdentist.service;

import ma.emsipfa.planetdentist.entity.DoctorIntervention;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface DoctorInterventionService extends BaseInterfaceService<DoctorIntervention> {
    public List<DoctorIntervention> getDoctorInterventionByConsultation(Long id);
    public List<DoctorIntervention> getDoctorInterventionByAct(Long id);
}
