package ma.emsipfa.planetdentist.service.impl;

import ma.emsipfa.planetdentist.entity.Charge;
import ma.emsipfa.planetdentist.repository.ChargeRepo;
import ma.emsipfa.planetdentist.service.ChargeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ChargeServiceImpl implements ChargeService {
    private final ChargeRepo chargeRepo;
    @Autowired
    public ChargeServiceImpl(ChargeRepo chargeRepo) {
        this.chargeRepo = chargeRepo;
    }
    @Override
    public List<Charge> getAll() {
        return chargeRepo.findAll();
    }

    @Override
    public Charge save(Charge baseEntity) {
        return chargeRepo.save(baseEntity);
    }

    @Override
    public Charge getById(Long id) {
        return chargeRepo.findById(id).get();
    }

    @Override
    public void delete(Long id) {
        chargeRepo.deleteById(id);
    }
}
