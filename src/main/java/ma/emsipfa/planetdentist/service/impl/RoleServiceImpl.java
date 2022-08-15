package ma.emsipfa.planetdentist.service.impl;

import ma.emsipfa.planetdentist.entity.ERole;
import ma.emsipfa.planetdentist.entity.Role;
import ma.emsipfa.planetdentist.repository.RoleRepo;
import ma.emsipfa.planetdentist.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RoleServiceImpl implements RoleService {

    private final RoleRepo roleRepo;

    @Autowired
    public RoleServiceImpl(RoleRepo roleRepo) {
        this.roleRepo = roleRepo;
    }

    @Override
    public List<Role> getAll() {
        return roleRepo.findAll();
    }

    @Override
    public Role save(Role baseEntity) {
        return roleRepo.save(baseEntity);
    }

    @Override
    public Role getById(Long id) {
        return roleRepo.getById(id);
    }

    @Override
    public void delete(Long id) {

    }

    @Override
    public Optional<Role> findByName(ERole name) {
        return roleRepo.findByName(name);
    }
}
