package ma.emsipfa.planetdentist.repository;

import ma.emsipfa.planetdentist.entity.Charge;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ChargeRepo extends JpaRepository<Charge, Long> {
}
