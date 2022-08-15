package ma.emsipfa.planetdentist.rest;

import ma.emsipfa.planetdentist.entity.Consultation;
import ma.emsipfa.planetdentist.service.ConsultationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/consultation")
public class ConsultationRest implements BaseInterfaceRest<Consultation> {
    private final ConsultationService consultationService;

    @Autowired
    public ConsultationRest(ConsultationService consultationService) {
        this.consultationService = consultationService;
    }

    @GetMapping("")
    @Override
    public ResponseEntity<List<Consultation>> getAll() {
        return new ResponseEntity<>(consultationService.getAll(), HttpStatus.OK);
    }

    @PostMapping("/save")
    @Override
    public ResponseEntity<Consultation> save(@RequestBody Consultation baseEntity) {
        if(baseEntity.getId()==null){
            return new ResponseEntity<>(consultationService.save(baseEntity),HttpStatus.CREATED);
        }else{
            if(!consultationService.getConsultationsByAppointment(baseEntity.getAppointment().getId()).isEmpty()){
                return new ResponseEntity<>(baseEntity,HttpStatus.NOT_ACCEPTABLE);
            }
            return new ResponseEntity<>(consultationService.save(baseEntity),HttpStatus.OK);
        }
    }

    @PutMapping(value = "/update/{id}")
    @Override
    public ResponseEntity<Consultation> update(@PathVariable Long id, @RequestBody Consultation consultation) {
        consultation.setId(id);
        return new ResponseEntity<>(consultationService.save(consultation), HttpStatus.OK);
    }
    @GetMapping("/{id}")
    @Override
    public ResponseEntity<Consultation> getById(@PathVariable Long id) {
        return new ResponseEntity<>(consultationService.getById(id),HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    @Override
    public ResponseEntity<Object> delete(@PathVariable Long id) {
        consultationService.delete(id);
        return new ResponseEntity<>("deleted",HttpStatus.OK);
    }

    @GetMapping("/get_by_appointment/{id}")
    public ResponseEntity<List<Consultation>> getConsultationsByAppointment(@PathVariable Long id){
        return new ResponseEntity<>(consultationService.getConsultationsByAppointment(id),HttpStatus.OK);
    }

    @GetMapping("/get_by_date/{date}")
    public ResponseEntity<List<Consultation>> getConsultationsByDate(@PathVariable Date date){
        return new ResponseEntity<>(consultationService.getConsultationsByDate(date),HttpStatus.OK);
    }

    @GetMapping("/get_by_patient/{id}")
    public ResponseEntity<List<Consultation>> getConsultationsByPatient(@PathVariable Long id){
        return new ResponseEntity<>(consultationService.getConsultationsByPatient(id),HttpStatus.OK);
    }
}
