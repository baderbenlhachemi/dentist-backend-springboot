package ma.emsipfa.planetdentist.rest;

import ma.emsipfa.planetdentist.entity.Consultation;
import ma.emsipfa.planetdentist.entity.DoctorIntervention;
import ma.emsipfa.planetdentist.service.DoctorInterventionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("doctor_intervention")
public class DoctorInterventionRest implements BaseInterfaceRest<DoctorIntervention> {

    private final DoctorInterventionService doctorInterventionService;

    @Autowired
    public DoctorInterventionRest(DoctorInterventionService doctorInterventionService) {
        this.doctorInterventionService = doctorInterventionService;
    }

    @GetMapping("")
    @Override
    public ResponseEntity<List<DoctorIntervention>> getAll() {
        return new ResponseEntity<>(doctorInterventionService.getAll(), HttpStatus.OK);
    }

    @PostMapping("/save")
    @Override
    public ResponseEntity<DoctorIntervention> save(@RequestBody DoctorIntervention baseEntity) {
        return new ResponseEntity<>(doctorInterventionService.save(baseEntity),HttpStatus.OK);
    }

    @PutMapping(value = "/update/{id}")
    public ResponseEntity<DoctorIntervention> update(@PathVariable Long id, @RequestBody DoctorIntervention intervention) {
        intervention.setId(id);
        return new ResponseEntity<>(doctorInterventionService.save(intervention), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    @Override
    public ResponseEntity<DoctorIntervention> getById(@PathVariable Long id) {
        return new ResponseEntity<>(doctorInterventionService.getById(id),HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    @Override
    public ResponseEntity<Object> delete(@PathVariable Long id) {
        doctorInterventionService.delete(id);
        return new ResponseEntity<>("deleted",HttpStatus.OK);
    }

    @GetMapping("get_by_consultation/{id}")
    public ResponseEntity<List<DoctorIntervention>> getDoctorInterventionByConsultation(@PathVariable Long id){
        return new ResponseEntity<>(doctorInterventionService.getDoctorInterventionByConsultation(id),HttpStatus.OK);
    }

    @GetMapping("get_by_act/{id}")
    public ResponseEntity<List<DoctorIntervention>> getDoctorInterventionByAct(@PathVariable Long id){
        return new ResponseEntity<>(doctorInterventionService.getDoctorInterventionByAct(id),HttpStatus.OK);

    }
}
