package ma.emsipfa.planetdentist.service;

import ma.emsipfa.planetdentist.entity.Act;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface ActService extends BaseInterfaceService<Act>{
    List<Act> getActsByLabel(String label);
    List<Act> getActsByBasePrice(Double basePrice);
    List<Act> getActsByRangeBasePrice(Double minPrice,Double maxPrice);
    List<Act> getActsByPlanCategory(Long idPlanCategory);

}
