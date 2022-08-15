package ma.emsipfa.planetdentist.service;

import ma.emsipfa.planetdentist.entity.ERole;
import ma.emsipfa.planetdentist.entity.Role;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public interface RoleService extends BaseInterfaceService<Role> {
    Optional<Role> findByName(ERole name);
}
