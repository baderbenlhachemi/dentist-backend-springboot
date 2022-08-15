package ma.emsipfa.planetdentist.rest;

import ma.emsipfa.planetdentist.entity.DentalClinic;
import ma.emsipfa.planetdentist.entity.Income;
import ma.emsipfa.planetdentist.entity.Patient;
import ma.emsipfa.planetdentist.service.DentalClinicService;
import ma.emsipfa.planetdentist.service.IncomeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/income")
public class IncomeRest implements BaseInterfaceRest<Income> {

    private final IncomeService incomeService;

    private final DentalClinicService dentalClinicService;

    @Autowired
    public IncomeRest(IncomeService incomeService, DentalClinicService dentalClinicService) {
        this.incomeService = incomeService;
        this.dentalClinicService = dentalClinicService;
    }

    @GetMapping(value = "")
    @Override
    public ResponseEntity<List<Income>> getAll() {
        return new ResponseEntity<>(incomeService.getAll(), HttpStatus.OK);
    }

    @GetMapping(value = "/{id}")
    @Override
    public ResponseEntity<Income> getById(Long id) {
        return new ResponseEntity<>(incomeService.getById(id), HttpStatus.OK);
    }

    @PostMapping(value = "/save")
    @Override
    public ResponseEntity<Income> save(@Validated Income baseEntity) {
        DentalClinic dentalClinic = dentalClinicService.getById(1L);
        baseEntity.setDentalClinic(dentalClinic);
        return new ResponseEntity<>(incomeService.save(baseEntity), HttpStatus.CREATED);
    }

    @PutMapping(value = "/update/{id}")
    @Override
    public ResponseEntity<Income> update(@PathVariable Long id, @RequestBody Income income) {
        DentalClinic dentalClinic = dentalClinicService.getById(1L);
        income.setDentalClinic(dentalClinic);
        income.setId(id);
        return new ResponseEntity<>(incomeService.save(income), HttpStatus.OK);
    }

    @DeleteMapping(value = "/delete/{id}")
    @Override
    public ResponseEntity<Object> delete(Long id) {
        incomeService.delete(id);
        return new ResponseEntity<>("deleted", HttpStatus.OK);
    }
}
