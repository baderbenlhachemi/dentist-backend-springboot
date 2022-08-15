package ma.emsipfa.planetdentist.service;

import ma.emsipfa.planetdentist.entity.Medication;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface MedicationService extends BaseInterfaceService<Medication>{
    List<Object> findByName(String name);
    List<Object> findByPrice(Double price);
    List<Object> findByPriceBetween(Double price1 , Double price2);
}
