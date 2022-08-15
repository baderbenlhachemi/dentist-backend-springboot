package ma.emsipfa.planetdentist.rest;

import ma.emsipfa.planetdentist.entity.Charge;
import ma.emsipfa.planetdentist.entity.DentalClinic;
import ma.emsipfa.planetdentist.entity.Income;
import ma.emsipfa.planetdentist.service.ChargeService;
import ma.emsipfa.planetdentist.service.DentalClinicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/charge")
public class ChargeRest implements BaseInterfaceRest<Charge> {

    private final ChargeService chargeService;

    private final DentalClinicService dentalClinicService;

    @Autowired
    public ChargeRest(ChargeService chargeService, DentalClinicService dentalClinicService) {
        this.chargeService = chargeService;
        this.dentalClinicService = dentalClinicService;
    }

    @GetMapping(value = "")
    @Override
    public ResponseEntity<List<Charge>> getAll() {
        return new ResponseEntity<>(chargeService.getAll(), HttpStatus.OK);
    }

    @PostMapping(value = "/save")
    @Override
    public ResponseEntity<Charge> save(@Validated Charge baseEntity) {
        DentalClinic dentalClinic = dentalClinicService.getById(1L);
        baseEntity.setDentalClinic(dentalClinic);
        return new ResponseEntity<>(chargeService.save(baseEntity), HttpStatus.CREATED);
    }

    @PutMapping(value = "/update/{id}")
    @Override
    public ResponseEntity<Charge> update(@PathVariable Long id, @RequestBody Charge charge) {
        DentalClinic dentalClinic = dentalClinicService.getById(1L);
        charge.setDentalClinic(dentalClinic);
        charge.setId(id);
        return new ResponseEntity<>(chargeService.save(charge), HttpStatus.OK);
    }

    @GetMapping(value = "/{id}")
    @Override
    public ResponseEntity<Charge> getById(@PathVariable Long id) {
        return new ResponseEntity<>(chargeService.getById(id), HttpStatus.OK);
    }

    @DeleteMapping(value = "/delete/{id}")
    @Override
    public ResponseEntity<Object> delete(@PathVariable Long id) {
        chargeService.delete(id);
        return new ResponseEntity<>("deleted", HttpStatus.OK);
    }
}
