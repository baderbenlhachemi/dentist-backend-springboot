package ma.emsipfa.planetdentist.service.impl;

import ma.emsipfa.planetdentist.entity.Income;
import ma.emsipfa.planetdentist.repository.IncomeRepo;
import ma.emsipfa.planetdentist.service.IncomeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IncomeServiceImpl implements IncomeService {
    private final IncomeRepo incomeRepo;
    @Autowired
    public IncomeServiceImpl(IncomeRepo incomeRepo) {
        this.incomeRepo = incomeRepo;
    }
    @Override
    public List<Income> getAll() {
        return incomeRepo.findAll();
    }

    @Override
    public Income save(Income baseEntity) {
        return incomeRepo.save(baseEntity);
    }

    @Override
    public Income getById(Long id) {
        return incomeRepo.findById(id).get();
    }

    @Override
    public void delete(Long id) {
        incomeRepo.deleteById(id);
    }
}

