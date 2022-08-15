package ma.emsipfa.planetdentist.rest;

import ma.emsipfa.planetdentist.entity.Consultation;
import ma.emsipfa.planetdentist.entity.Prescription;
import ma.emsipfa.planetdentist.service.PrescriptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping(value = "/prescription")
public class PrescriptionRest implements BaseInterfaceRest<Prescription>{

    private final PrescriptionService prescriptionService;

    @Autowired
    public PrescriptionRest(PrescriptionService prescriptionService) {
        this.prescriptionService = prescriptionService;
    }

    @GetMapping(value = "")
    public ResponseEntity<List<Prescription>> getAll() {
        return new ResponseEntity<>(prescriptionService.getAll(), HttpStatus.OK);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Prescription> getById(@PathVariable Long id) {
        return new ResponseEntity<>(prescriptionService.getById(id), HttpStatus.OK);
    }
    @GetMapping(value = "/date/{date}")
    public ResponseEntity<Object> getByDate(@PathVariable Date date) {
        return new ResponseEntity<>(prescriptionService.findByDate(Date.valueOf(String.valueOf(date))),HttpStatus.OK);
    }

    @GetMapping(value = "/getByConsultationId/{id}")
    public ResponseEntity<List<Consultation>> getByDate(@PathVariable Long id) {
        return new ResponseEntity<>(prescriptionService.findPrescriptionByConsultationId(id),HttpStatus.OK);
    }

    @GetMapping(value = "/dateBetween/{date1}&{date2}")
    public ResponseEntity<Object> getByDateBetween(@PathVariable Date date1 ,@PathVariable Date date2 ) {
        Date dateStart = Date.valueOf(String.valueOf(date1));
        Date dateEnd = Date.valueOf(String.valueOf(date2));
        return new ResponseEntity<>(prescriptionService.findByDateBetween(dateStart,dateEnd),HttpStatus.OK);
    }

    @GetMapping(value = "/groupByConsultation")
    public ResponseEntity<List<Object>> groupByConsultation() {
        return new ResponseEntity<>(prescriptionService.groupByConsultation(),HttpStatus.OK);
    }

    @PostMapping(value = "/save")
    public ResponseEntity<Prescription> save(@RequestBody Prescription baseEntity) {

        return new ResponseEntity<>(prescriptionService.save(baseEntity), HttpStatus.CREATED);
    }

    @PutMapping(value = "/update/{id}")
    @Override
    public ResponseEntity<Prescription> update(Long id, Prescription baseEntity) {
        baseEntity.setId(id);

        return new ResponseEntity<>(prescriptionService.save(baseEntity), HttpStatus.OK);
    }

    @DeleteMapping(value = "/delete/{id}")
    public ResponseEntity<Object> delete(@PathVariable Long id) {
        prescriptionService.delete(id);
        return new ResponseEntity<>("Prescription deleted",HttpStatus.OK);
    }


}
