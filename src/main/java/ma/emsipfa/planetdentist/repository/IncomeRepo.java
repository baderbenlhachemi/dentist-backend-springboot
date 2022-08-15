package ma.emsipfa.planetdentist.repository;

import ma.emsipfa.planetdentist.entity.Income;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IncomeRepo extends JpaRepository<Income, Long> {
}
