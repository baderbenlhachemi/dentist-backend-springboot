package ma.emsipfa.planetdentist.service.impl;

import ma.emsipfa.planetdentist.entity.PlanCategory;
import ma.emsipfa.planetdentist.repository.PlanCategoryRepo;
import ma.emsipfa.planetdentist.service.PlanCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlanCategoryServiceImpl implements PlanCategoryService {
    private final PlanCategoryRepo planCategoryRepo;

    @Autowired
    public PlanCategoryServiceImpl(PlanCategoryRepo planCategoryRepo) {
        this.planCategoryRepo = planCategoryRepo;
    }
    @Override
    public List<PlanCategory> getAll() {
        return planCategoryRepo.findAll();
    }

    @Override
    public PlanCategory save(PlanCategory baseEntity) {
        return planCategoryRepo.save(baseEntity);
    }

    @Override
    public PlanCategory getById(Long id) {
        return planCategoryRepo.findById(id).get();
    }

    @Override
    public void delete(Long id) {
        planCategoryRepo.deleteById(id);
    }

    @Override
    public List<Object> findByName(String name) {
        return planCategoryRepo.findByName(name);
    }
}

