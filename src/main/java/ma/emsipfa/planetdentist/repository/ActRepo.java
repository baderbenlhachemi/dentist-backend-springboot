package ma.emsipfa.planetdentist.repository;

import ma.emsipfa.planetdentist.entity.Act;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ActRepo extends JpaRepository<Act, Long> {
    List<Act> findByLabel(String label);
    List<Act> findByBasePrice(Double basePrice);
    List<Act> findByBasePriceBetween(Double minPrice,Double maxPrice);
    List<Act> findByPlanCategoryId(Long idPlanCategory);

}
