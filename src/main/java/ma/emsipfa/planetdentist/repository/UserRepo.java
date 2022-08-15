package ma.emsipfa.planetdentist.repository;

import ma.emsipfa.planetdentist.entity.ERole;
import ma.emsipfa.planetdentist.entity.Staff;
import ma.emsipfa.planetdentist.entity.User;
import org.springframework.data.domain.Example;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface UserRepo extends JpaRepository<User,Long> {
    Optional<User> findByEmail(String email);
    Optional<User> findByUsername(String username);

    boolean existsByEmail(String email);
    boolean existsByUsername(String username);
    boolean existsByCin(String cin);

    List<Staff> findByRoles_Name(ERole name);
}
