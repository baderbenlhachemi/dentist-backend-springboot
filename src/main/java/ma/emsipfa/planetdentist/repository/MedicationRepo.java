package ma.emsipfa.planetdentist.repository;

import ma.emsipfa.planetdentist.entity.Medication;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MedicationRepo extends JpaRepository<Medication, Long> {
    List<Object> findByName(String name);
    List<Object> findByPrice(Double price);
    List<Object> findByPriceBetween(Double price1 , Double price2);
}
