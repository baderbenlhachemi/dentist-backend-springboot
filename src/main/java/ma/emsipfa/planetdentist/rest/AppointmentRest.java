package ma.emsipfa.planetdentist.rest;

import ma.emsipfa.planetdentist.entity.Appointment;
import ma.emsipfa.planetdentist.service.AppointmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping(value = "/appointment")
public class AppointmentRest implements BaseInterfaceRest<Appointment> {

    private final AppointmentService appointmentService;

    @Autowired
    public AppointmentRest(AppointmentService appointmentService) {
        this.appointmentService = appointmentService;
    }

    @GetMapping(value = "")
    @Override
    public ResponseEntity<List<Appointment>> getAll() {
        return new ResponseEntity<>(appointmentService.getAll(), HttpStatus.OK);
    }

    @GetMapping(value = "/{id}")
    @Override
    public ResponseEntity<Appointment> getById(@PathVariable Long id) {
        return new ResponseEntity<>(appointmentService.getById(id), HttpStatus.OK);
    }

    @GetMapping(value = "/get_by_patient/{id}")
    public ResponseEntity<List<Appointment>> getByPatient(@PathVariable Long id) {
        return new ResponseEntity<>(appointmentService.getByPatient(id), HttpStatus.OK);
    }

    @PostMapping(value = "/save")
    @Override
    public ResponseEntity<Appointment> save(@Validated @RequestBody Appointment baseEntity) {
        return new ResponseEntity<>(appointmentService.save(baseEntity), HttpStatus.CREATED);
    }

    @PutMapping(value = "/update/{id}")
    @Override
    public ResponseEntity<Appointment> update(@PathVariable Long id, @RequestBody Appointment baseEntity) {
        System.out.println(baseEntity);
        baseEntity.setId(id);
        return new ResponseEntity<>(appointmentService.save(baseEntity), HttpStatus.OK);
    }

    @DeleteMapping(value = "/delete/{id}")
    @Override
    public ResponseEntity<Object> delete(@PathVariable Long id) {
        appointmentService.delete(id);
        return new ResponseEntity<>("Appointment deleted", HttpStatus.OK);
    }

    @GetMapping(value = "/pending")
    public ResponseEntity<List<Appointment>> getPendingAppointments() {
        return new ResponseEntity<>(appointmentService.getPendingAppointments(), HttpStatus.OK);
    }

    @GetMapping(value = "/accepted")
    public ResponseEntity<List<Appointment>> getAcceptedAppointments() {
        return new ResponseEntity<>(appointmentService.getAcceptedAppointments(), HttpStatus.OK);
    }

    @GetMapping(value = "/completed")
    public ResponseEntity<List<Appointment>> getCompletedAppointments() {
        return new ResponseEntity<>(appointmentService.getCompletedAppointments(), HttpStatus.OK);
    }
}
