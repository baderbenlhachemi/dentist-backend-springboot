package ma.emsipfa.planetdentist.rest;

import ma.emsipfa.planetdentist.entity.MedicationRule;
import ma.emsipfa.planetdentist.service.MedicationRuleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/MedicationRule")
public class MedicationRuleRest implements BaseInterfaceRest<MedicationRule> {

    private final MedicationRuleService medicationRuleService;

    @Autowired
    public MedicationRuleRest(MedicationRuleService medicationRuleService) {
        this.medicationRuleService = medicationRuleService;
    }

    @GetMapping("")
    public ResponseEntity<List<MedicationRule>> getAll() {
        return new ResponseEntity<>(medicationRuleService.getAll(), HttpStatus.OK);
    }

    @GetMapping("/maxDrug/{drug}")
    public ResponseEntity<List<Object>> getByMaxDrugUnits(@PathVariable int drug) {
        return new ResponseEntity<>(medicationRuleService.findByMaxDrugUnits(drug), HttpStatus.OK);
    }

    @GetMapping("/minDrug/{drug}")
    public ResponseEntity<List<Object>> getByMinDrugUnits(@PathVariable int drug) {
        return new ResponseEntity<>(medicationRuleService.findByMinDrugUnits(drug), HttpStatus.OK);
    }

    @GetMapping("/timeRestriction/{time}")
    public ResponseEntity<List<Object>> getByTimeRestriction(@PathVariable String time) {
        return new ResponseEntity<>(medicationRuleService.findByTimeRestriction(time), HttpStatus.OK);
    }

    @GetMapping("/prescription/{prescriptionId}")
    public ResponseEntity<List<Object>> groupByPrescriptionId(@PathVariable Long prescriptionId) {
        return new ResponseEntity<>(medicationRuleService.groupByPrescriptionId(prescriptionId), HttpStatus.OK);
    }

    @PostMapping(value ="/save" , consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<MedicationRule> save(@RequestBody MedicationRule baseEntity) {
        return new ResponseEntity<>(medicationRuleService.save(baseEntity),HttpStatus.CREATED);
    }

    @PutMapping("/update/{id}")
    @Override
    public ResponseEntity<MedicationRule> update(@PathVariable Long id, @RequestBody MedicationRule baseEntity) {
        baseEntity.setId(id);

        return new ResponseEntity<>(medicationRuleService.save(baseEntity), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<MedicationRule> getById(@PathVariable Long id) {
        return new ResponseEntity<>(medicationRuleService.getById(id),HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Object> delete(@PathVariable Long id) {
        medicationRuleService.delete(id);
        return new ResponseEntity<>("Medication Rule deleted",HttpStatus.OK);
    }
}
