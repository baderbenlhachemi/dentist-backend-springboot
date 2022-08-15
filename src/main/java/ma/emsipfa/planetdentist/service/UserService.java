package ma.emsipfa.planetdentist.service;

import ma.emsipfa.planetdentist.entity.User;
import org.springframework.stereotype.Service;

@Service
public interface UserService extends BaseInterfaceService<User> {

    User save(User patient);

}
