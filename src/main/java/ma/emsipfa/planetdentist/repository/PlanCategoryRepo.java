package ma.emsipfa.planetdentist.repository;

import ma.emsipfa.planetdentist.entity.PlanCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface PlanCategoryRepo extends JpaRepository<PlanCategory, Long> {
    List<Object> findByName(String name);

}
