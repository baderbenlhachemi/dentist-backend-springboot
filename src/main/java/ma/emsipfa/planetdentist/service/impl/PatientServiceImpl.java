package ma.emsipfa.planetdentist.service.impl;

import ma.emsipfa.planetdentist.entity.Patient;
import ma.emsipfa.planetdentist.repository.PatientRepo;
import ma.emsipfa.planetdentist.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class PatientServiceImpl implements PatientService {

    private final PatientRepo patientRepo;

    @Autowired
    public PatientServiceImpl(PatientRepo patientRepo) {
        this.patientRepo = patientRepo;
    }

    /**
     * Permet de récupérer tous les patients
     *
     * @return List<Patient>
     */
    @Override
    public List<Patient> getAll() {
        return patientRepo.findAll();
    }

    /**
     * Permet de sauvegarder un patient et aussi modifier
     * @param patient
     * @return Patient
     */
    @Override
    public Patient save(Patient patient) {
        return patientRepo.save(patient);
    }

    /**
     * Permet de récupérer un patient par son id
     * @param id
     * @return Patient
     */
    @Override
    public Patient getById(Long id) {
        return patientRepo.findById(id).get();
    }

    /**
     * Permet de supprimer un patient par son id
     * @param id
     * @return void
     */
    @Override
    public void delete(Long id) {
        patientRepo.deleteById(id);
    }

}
