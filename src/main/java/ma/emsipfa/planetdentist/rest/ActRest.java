package ma.emsipfa.planetdentist.rest;

import ma.emsipfa.planetdentist.entity.Act;
import ma.emsipfa.planetdentist.entity.PlanCategory;
import ma.emsipfa.planetdentist.repository.PlanCategoryRepo;
import ma.emsipfa.planetdentist.service.ActService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "*",maxAge = 3600)
@RestController
@RequestMapping(value = "/act")
public class ActRest implements BaseInterfaceRest<Act> {

    private final ActService actService;

    @Autowired
    private final PlanCategoryRepo planCategoryRepo;

    @Autowired
    public ActRest(ActService actService, PlanCategoryRepo planCategoryRepo) {
        this.actService = actService;
        this.planCategoryRepo = planCategoryRepo;
    }

    @GetMapping(value = "")
    @Override
    public ResponseEntity<List<Act>> getAll() {
        return new ResponseEntity<>(actService.getAll(), HttpStatus.OK);
    }

    @PostMapping("/save")
    @Override
    public ResponseEntity<Act> save(@RequestBody Act act) {
        if(act.getId()==null){

            return new ResponseEntity<>(actService.save(act),HttpStatus.CREATED);
        }
        return new ResponseEntity<>(actService.save(act),HttpStatus.OK);
    }

    @PutMapping(value = "/update/{id}")
    @Override
    public ResponseEntity<Act> update(@PathVariable Long id, @RequestBody Act act) {
        act.setId(id);
        return new ResponseEntity<>(actService.save(act), HttpStatus.OK);
    }


    @GetMapping("/{id}")
    @Override
    public ResponseEntity<Act> getById(@PathVariable Long id) {

        return new ResponseEntity<>(actService.getById(id),HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    @Override
    public ResponseEntity<Object> delete(@PathVariable Long id) {
        actService.delete(id);
        return new ResponseEntity<>("deleted",HttpStatus.OK);
    }

    @GetMapping("/get_by_label/{label}")
        public ResponseEntity<List<Act>> getByLabel(@PathVariable String label ){
            return new ResponseEntity<>(actService.getActsByLabel(label),HttpStatus.OK);
    }

    @GetMapping("/get_by_base_price/{basePrice}")
    public ResponseEntity<List<Act>> getByBasePrice(@PathVariable Double basePrice ){
        return new ResponseEntity<>(actService.getActsByBasePrice(basePrice),HttpStatus.OK);
    }
    @GetMapping("/get_by_range_base_price/{minPrice}/{maxPrice}")
    public ResponseEntity<List<Act>> getActsByRangeBasePrice(@PathVariable Double minPrice,@PathVariable Double maxPrice ){
        return new ResponseEntity<>(actService.getActsByRangeBasePrice(minPrice,maxPrice),HttpStatus.OK);
    }
    @GetMapping("/get_by_plan_category/{idPlanCategory}")
    public ResponseEntity<List<Act>> getActsByPlanCategory(@PathVariable Long idPlanCategory){
        return new ResponseEntity<>(actService.getActsByPlanCategory(idPlanCategory),HttpStatus.OK);
    }
}
