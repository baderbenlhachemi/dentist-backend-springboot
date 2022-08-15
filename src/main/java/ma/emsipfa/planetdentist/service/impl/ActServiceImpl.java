package ma.emsipfa.planetdentist.service.impl;

import ma.emsipfa.planetdentist.entity.Act;
import ma.emsipfa.planetdentist.repository.ActRepo;
import ma.emsipfa.planetdentist.service.ActService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ActServiceImpl implements ActService {
    private final ActRepo actRepo;

    @Autowired
    public ActServiceImpl(ActRepo actRepo){
        this.actRepo = actRepo;
    }

    @Override
    public List<Act> getAll() {
        return actRepo.findAll();
    }

    @Override
    public Act save(Act baseEntity) {
        return actRepo.save(baseEntity);
    }

    @Override
    public Act getById(Long id) {
        return actRepo.findById(id).get();
    }

    @Override
    public void delete(Long id) {
        actRepo.delete(getById(id));
    }

    @Override
    public List<Act> getActsByLabel(String label) {
        return actRepo.findByLabel(label);
    }

    @Override
    public List<Act> getActsByBasePrice(Double basePrice) {
        return actRepo.findByBasePrice(basePrice);
    }

    @Override
    public List<Act> getActsByRangeBasePrice(Double minPrice, Double maxPrice) {
        return actRepo.findByBasePriceBetween(minPrice, maxPrice);
    }

    @Override
    public List<Act> getActsByPlanCategory(Long idPlanCategory) {
        return actRepo.findByPlanCategoryId(idPlanCategory);
    }
}
