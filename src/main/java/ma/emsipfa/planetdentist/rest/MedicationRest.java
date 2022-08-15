package ma.emsipfa.planetdentist.rest;

import ma.emsipfa.planetdentist.entity.Medication;
import ma.emsipfa.planetdentist.service.MedicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping(value = "/medication")
public class MedicationRest implements BaseInterfaceRest<Medication> {

    private final MedicationService medicationService;

    @Autowired
    public MedicationRest(MedicationService medicationService) {
        this.medicationService = medicationService;
    }

    @GetMapping(value = "")
    public ResponseEntity<List<Medication>> getAll() {
        return new ResponseEntity<>(medicationService.getAll(), HttpStatus.OK);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Medication> getById(@PathVariable Long id) {
        return new ResponseEntity<>(medicationService.getById(id), HttpStatus.OK);
    }

    @GetMapping(value = "/name/{name}")
    public ResponseEntity<Object> getByName(@PathVariable String name) {
        return new ResponseEntity<>(medicationService.findByName(name), HttpStatus.OK);
    }

    @GetMapping(value = "/price/{price}")
    public ResponseEntity<Object> getByPrice(@PathVariable Double price) {
        return new ResponseEntity<>(medicationService.findByPrice(price), HttpStatus.OK);
    }

    @GetMapping(value = "/priceBetween/{price1}&{price2}")
    public ResponseEntity<Object> getByPriceBetween(@PathVariable Double price1 , @PathVariable Double price2) {
        Double priceStart = price1;
        Double priceEnd = price2;
        return new ResponseEntity<>(medicationService.findByPriceBetween(priceStart,priceEnd), HttpStatus.OK);
    }

    @PostMapping(value = "/save")
    public ResponseEntity<Medication> save(@Validated @RequestBody Medication baseEntity) {
        return new ResponseEntity<>(medicationService.save(baseEntity), HttpStatus.CREATED);
    }

    @PutMapping(value = "/update/{id}")
    public ResponseEntity<Medication> update(@PathVariable Long id, @RequestBody Medication baseEntity) {
            baseEntity.setId(id);
        return new ResponseEntity<>(medicationService.save(baseEntity), HttpStatus.OK);
    }

    @DeleteMapping(value = "/delete/{id}")
    public ResponseEntity<Object> delete(@PathVariable Long id) {
        medicationService.delete(id);
        return new ResponseEntity<>("Medication deleted",HttpStatus.OK);
    }
}
