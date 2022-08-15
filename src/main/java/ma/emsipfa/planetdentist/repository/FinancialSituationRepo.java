package ma.emsipfa.planetdentist.repository;

import ma.emsipfa.planetdentist.entity.FinancialSituation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FinancialSituationRepo extends JpaRepository<FinancialSituation, Long> {

}
