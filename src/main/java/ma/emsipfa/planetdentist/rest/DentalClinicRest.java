package ma.emsipfa.planetdentist.rest;

import ma.emsipfa.planetdentist.entity.DentalClinic;
import ma.emsipfa.planetdentist.service.DentalClinicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/dental-clinic")
public class DentalClinicRest implements BaseInterfaceRest<DentalClinic> {

    private final DentalClinicService dentalClinicService;

    @Autowired
    public DentalClinicRest(DentalClinicService dentalClinicService) {
        this.dentalClinicService = dentalClinicService;
    }

    @GetMapping(value = "")
    @Override
    public ResponseEntity<List<DentalClinic>> getAll() {
        return new ResponseEntity<>(dentalClinicService.getAll(), HttpStatus.OK);
    }

    @GetMapping(value = "/{id}")
    @Override
    public ResponseEntity<DentalClinic> getById(@PathVariable Long id) {
        return new ResponseEntity<>(dentalClinicService.getById(id), HttpStatus.OK);
    }

    @PostMapping(value = "/save")
    @Override
    public ResponseEntity<DentalClinic> save(@Validated @RequestBody DentalClinic dentalClinic) {
        return new ResponseEntity<>(dentalClinicService.save(dentalClinic), HttpStatus.CREATED);
    }

    @PutMapping(value = "/update/{id}")
    @Override
    public ResponseEntity<DentalClinic> update(@PathVariable Long id, @Validated @RequestBody DentalClinic dentalClinic) {
        dentalClinic.setId(id);
        return new ResponseEntity<>(dentalClinicService.save(dentalClinic), HttpStatus.OK);
    }

    @DeleteMapping(value = "/delete/{id}")
    @Override
    public ResponseEntity<Object> delete(@PathVariable Long id) {
        dentalClinicService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}

