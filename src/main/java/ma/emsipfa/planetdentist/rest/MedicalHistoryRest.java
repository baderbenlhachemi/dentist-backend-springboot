package ma.emsipfa.planetdentist.rest;

import ma.emsipfa.planetdentist.entity.MedicalHistory;
import ma.emsipfa.planetdentist.entity.Patient;
import ma.emsipfa.planetdentist.service.MedicalHistoryService;
import ma.emsipfa.planetdentist.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping(value = "/medical-history")
public class MedicalHistoryRest implements BaseInterfaceRest<MedicalHistory> {

    private final MedicalHistoryService medicalHistoryService;

    private final PatientService patientService;

    @Autowired
    public MedicalHistoryRest(MedicalHistoryService medicalHistoryService, PatientService patientService) {
        this.medicalHistoryService = medicalHistoryService;
        this.patientService = patientService;
    }

    @GetMapping(value = "")
    public ResponseEntity<List<MedicalHistory>> getAll() {
        return new ResponseEntity<>(medicalHistoryService.getAll(), HttpStatus.OK);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<MedicalHistory> getById(@PathVariable Long id) {
        return new ResponseEntity<>(medicalHistoryService.getById(id), HttpStatus.OK);
    }

    @PostMapping(value = "/save")
    public ResponseEntity<MedicalHistory> save(@RequestBody MedicalHistory medicalHistory) {
        return new ResponseEntity<>(medicalHistoryService.save(medicalHistory), HttpStatus.CREATED);
    }

    @PutMapping(value = "/update/{id}")
    public ResponseEntity<MedicalHistory> update(@PathVariable Long id, @RequestBody MedicalHistory medicalHistory) {
        medicalHistory.setId(id);
        return new ResponseEntity<>(medicalHistoryService.save(medicalHistory), HttpStatus.OK);
    }

    @DeleteMapping(value = "/delete/{id}")
    public ResponseEntity<Object> delete(@PathVariable Long id) {
        medicalHistoryService.delete(id);
        return new ResponseEntity<>("Deleted", HttpStatus.ACCEPTED);
    }

    @GetMapping(value = "/patient/{id}")
    public ResponseEntity<Optional<MedicalHistory>> getByPatientId(@PathVariable Long id) {
        Optional<MedicalHistory> medicalHistory = medicalHistoryService.getByPatientId(id);

        if (medicalHistory.isPresent())
            return new ResponseEntity<>(medicalHistory, HttpStatus.OK);

        // Find patient by id and set it to medical history
        Patient patient = patientService.getById(id);
        MedicalHistory newMedicalHistory = new MedicalHistory();
        newMedicalHistory.setPatient(patient);

        medicalHistoryService.save(newMedicalHistory);

        return new ResponseEntity<>(medicalHistoryService.getByPatientId(id), HttpStatus.OK);
    }

}

