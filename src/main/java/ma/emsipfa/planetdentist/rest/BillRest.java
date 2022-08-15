package ma.emsipfa.planetdentist.rest;

import ma.emsipfa.planetdentist.entity.Appointment;
import ma.emsipfa.planetdentist.entity.Bill;
import ma.emsipfa.planetdentist.service.AppointmentService;
import ma.emsipfa.planetdentist.service.BillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping(value = "/bill")
public class BillRest implements BaseInterfaceRest<Bill> {

    private final BillService billService;

    @Autowired
    public BillRest(BillService billService) {
        this.billService = billService;
    }

    @GetMapping(value = "")
    @Override
    public ResponseEntity<List<Bill>> getAll() {
        return new ResponseEntity<>(billService.getAll(), HttpStatus.OK);
    }

    @GetMapping(value = "/{id}")
    @Override
    public ResponseEntity<Bill> getById(@PathVariable Long id) {
        return new ResponseEntity<>(billService.getById(id), HttpStatus.OK);
    }

    @PostMapping(value = "/save")
    @Override
    public ResponseEntity<Bill> save(@Validated @RequestBody Bill baseEntity) {
        return new ResponseEntity<>(billService.save(baseEntity), HttpStatus.CREATED);
    }

    @PutMapping(value = "/update/{id}")
    @Override
    public ResponseEntity<Bill> update(Long id, Bill baseEntity) {
        baseEntity.setId(id);

        return new ResponseEntity<>(billService.save(baseEntity), HttpStatus.OK);
    }

    @DeleteMapping(value = "/delete/{id}")
    @Override
    public ResponseEntity<Object> delete(@PathVariable Long id) {
        billService.delete(id);
        return new ResponseEntity<>("Bill deleted", HttpStatus.OK);
    }
}
