package ma.emsipfa.planetdentist.rest;

import ma.emsipfa.planetdentist.entity.FinancialSituation;
import ma.emsipfa.planetdentist.service.FinancialSituationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping(value = "/financial-situation")
public class FinancialSituationRest implements BaseInterfaceRest<FinancialSituation> {

    private final FinancialSituationService financialSituationService;

    @Autowired
    public FinancialSituationRest(FinancialSituationService financialSituationService) {
        this.financialSituationService = financialSituationService;
    }

    @GetMapping(value = "")
    public ResponseEntity<List<FinancialSituation>> getAll() {
        return new ResponseEntity<>(financialSituationService.getAll(), HttpStatus.OK);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<FinancialSituation> getById(@PathVariable Long id) {
        return new ResponseEntity<>(financialSituationService.getById(id), HttpStatus.OK);
    }

    @PostMapping(value = "/save")
    public ResponseEntity<FinancialSituation> save(@Validated @RequestBody FinancialSituation baseEntity) {
        return new ResponseEntity<>(financialSituationService.save(baseEntity), HttpStatus.CREATED);
    }

    @PutMapping(value = "/update/{id}")
    @Override
    public ResponseEntity<FinancialSituation> update(@PathVariable Long id, @RequestBody FinancialSituation baseEntity) {
        baseEntity.setId(id);

        return new ResponseEntity<>(financialSituationService.save(baseEntity), HttpStatus.OK);
    }

    @DeleteMapping(value = "/delete/{id}")
    public ResponseEntity<Object> delete(@PathVariable Long id) {
        financialSituationService.delete(id);
        return new ResponseEntity<>("Financial Situation deleted", HttpStatus.OK);
    }
}
