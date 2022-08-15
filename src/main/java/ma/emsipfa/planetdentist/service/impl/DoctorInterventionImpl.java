package ma.emsipfa.planetdentist.service.impl;

import ma.emsipfa.planetdentist.entity.DoctorIntervention;
import ma.emsipfa.planetdentist.repository.DoctorInterventionRepo;
import ma.emsipfa.planetdentist.service.DoctorInterventionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class DoctorInterventionImpl implements DoctorInterventionService {
    private final DoctorInterventionRepo doctorInterventionRepo;

    @Autowired
    public DoctorInterventionImpl(DoctorInterventionRepo doctorInterventionRepo) {
        this.doctorInterventionRepo = doctorInterventionRepo;
    }

    @Override
    public List<DoctorIntervention> getAll() {
        return doctorInterventionRepo.findAll();
    }

    @Override
    public DoctorIntervention save(DoctorIntervention baseEntity) {
        return doctorInterventionRepo.save(baseEntity);
    }

    @Override
    public DoctorIntervention getById(Long id) {
        return doctorInterventionRepo.getById(id);
    }

    @Override
    public void delete(Long id) {
        doctorInterventionRepo.delete(getById(id));
    }

    @Override
    public List<DoctorIntervention> getDoctorInterventionByConsultation(Long id) {
        return doctorInterventionRepo.findDoctorInterventionByConsultation(id);
    }

    @Override
    public List<DoctorIntervention> getDoctorInterventionByAct(Long id) {
        return doctorInterventionRepo.findDoctorInterventionByAct(id);
    }
}
