package ma.emsipfa.planetdentist.repository;

import ma.emsipfa.planetdentist.entity.DentalClinic;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DentalClinicRepo extends JpaRepository<DentalClinic, Long> {
}
