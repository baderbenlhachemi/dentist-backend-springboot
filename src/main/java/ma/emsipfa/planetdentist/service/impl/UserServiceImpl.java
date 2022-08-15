package ma.emsipfa.planetdentist.service.impl;

import ma.emsipfa.planetdentist.entity.ERole;
import ma.emsipfa.planetdentist.entity.Staff;
import ma.emsipfa.planetdentist.entity.User;
import ma.emsipfa.planetdentist.repository.PatientRepo;
import ma.emsipfa.planetdentist.repository.UserRepo;
import ma.emsipfa.planetdentist.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepo userRepo;

    @Autowired
    public UserServiceImpl(UserRepo userRepo) {
        this.userRepo = userRepo;
    }

    /**
     * Permet de récupérer tous les utilisateurs
     *
     * @return
     */
    @Override
    public List<User> getAll() {
        return userRepo.findAll();
    }

    /**
     * Permet de sauvegarder un patient et aussi le modifier
     * @param user
     * @return
     */
    @Override
    public User save(User user) {
        return userRepo.save(user);
    }

    /**
     * Permet de récupérer un patient par son id
     * @param id
     * @return
     */
    @Override
    public User getById(Long id) {
        return userRepo.findById(id).get();
    }

    /**
     * Permet de supprimer un patient par son id
     * @param id
     */
    @Override
    public void delete(Long id) {
        userRepo.deleteById(id);
    }
}
