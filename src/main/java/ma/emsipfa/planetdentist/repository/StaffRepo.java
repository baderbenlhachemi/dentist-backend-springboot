package ma.emsipfa.planetdentist.repository;

import ma.emsipfa.planetdentist.entity.ERole;
import ma.emsipfa.planetdentist.entity.Staff;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StaffRepo extends JpaRepository<Staff, Long> {
    List<Staff> findByRoles_Name(ERole name);
}
