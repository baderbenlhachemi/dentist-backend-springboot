package ma.emsipfa.planetdentist.rest;

import ma.emsipfa.planetdentist.entity.PlanCategory;
import ma.emsipfa.planetdentist.service.PlanCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping(value = "/PlanCategory")
public class PlanCategoryRest implements BaseInterfaceRest<PlanCategory> {

    private final PlanCategoryService planCategoryService;

    @Autowired
    public PlanCategoryRest(PlanCategoryService planCategoryService) {
        this.planCategoryService = planCategoryService;
    }

    @GetMapping(value = "")
    @Override
    public ResponseEntity<List<PlanCategory>> getAll() {
        return new ResponseEntity<>(planCategoryService.getAll(), HttpStatus.OK);
    }

    @GetMapping(value = "/{id}")
    @Override
    public ResponseEntity<PlanCategory> getById(@PathVariable Long id) {
        return new ResponseEntity<>(planCategoryService.getById(id), HttpStatus.OK);
    }

    @GetMapping(value = "/name/{name}")
    public ResponseEntity<Object> getByName(@PathVariable String name) {
        return new ResponseEntity<>(planCategoryService.findByName(name), HttpStatus.OK);
    }

    @PostMapping(value = "/save")
    @Override
    public ResponseEntity<PlanCategory> save(@RequestBody PlanCategory baseEntity) {
        return new ResponseEntity<>(planCategoryService.save(baseEntity), HttpStatus.CREATED);
    }

    @PutMapping(value = "/update/{id}")
    @Override
    public ResponseEntity<PlanCategory> update(@PathVariable Long id, @RequestBody PlanCategory baseEntity) {
        baseEntity.setId(id);

        return new ResponseEntity<>(planCategoryService.save(baseEntity), HttpStatus.OK);
    }

    @DeleteMapping(value = "/delete/{id}")
    @Override
    public ResponseEntity<Object> delete(@PathVariable Long id) {
        planCategoryService.delete(id);
        return new ResponseEntity<>("Plan Category deleted",HttpStatus.OK);
    }
}


