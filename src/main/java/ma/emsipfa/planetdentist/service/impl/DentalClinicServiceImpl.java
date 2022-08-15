package ma.emsipfa.planetdentist.service.impl;

import ma.emsipfa.planetdentist.entity.DentalClinic;
import ma.emsipfa.planetdentist.entity.Patient;
import ma.emsipfa.planetdentist.repository.DentalClinicRepo;
import ma.emsipfa.planetdentist.repository.PatientRepo;
import ma.emsipfa.planetdentist.service.DentalClinicService;
import ma.emsipfa.planetdentist.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class DentalClinicServiceImpl implements DentalClinicService {

    private final DentalClinicRepo dentalClinicRepo;

    @Autowired
    public DentalClinicServiceImpl(DentalClinicRepo dentalClinicRepo) {
        this.dentalClinicRepo = dentalClinicRepo;
    }
    @Override
    public List<DentalClinic> getAll() {
        return dentalClinicRepo.findAll();
    }
    @Override
    public DentalClinic save(DentalClinic dentalClinic) {
        return dentalClinicRepo.save(dentalClinic);
    }
    @Override
    public DentalClinic getById(Long id) {
        return dentalClinicRepo.findById(id).get();
    }
    @Override
    public void delete(Long id) {
        dentalClinicRepo.deleteById(id);
    }

}
