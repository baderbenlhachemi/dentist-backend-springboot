package ma.emsipfa.planetdentist.service;

import ma.emsipfa.planetdentist.entity.PlanCategory;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface PlanCategoryService extends BaseInterfaceService<PlanCategory> {
    List<Object> findByName(String name);

}