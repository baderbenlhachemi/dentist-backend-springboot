package ma.emsipfa.planetdentist.repository;

import ma.emsipfa.planetdentist.entity.Bill;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BillRepo extends JpaRepository<Bill, Long> {
    List<Bill> findByStatus(String status);

    List<Bill> findByFinancialSituation_Id(Long id);
}
