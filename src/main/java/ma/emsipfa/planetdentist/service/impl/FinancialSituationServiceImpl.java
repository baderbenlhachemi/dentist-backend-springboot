package ma.emsipfa.planetdentist.service.impl;

import ma.emsipfa.planetdentist.entity.FinancialSituation;
import ma.emsipfa.planetdentist.repository.FinancialSituationRepo;
import ma.emsipfa.planetdentist.service.FinancialSituationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FinancialSituationServiceImpl implements FinancialSituationService {
    private final FinancialSituationRepo financialSituationRepo;

    @Autowired
    public FinancialSituationServiceImpl(FinancialSituationRepo financialSituationRepo) {
        this.financialSituationRepo = financialSituationRepo;
    }

    @Override
    public List<FinancialSituation> getAll() {
        return financialSituationRepo.findAll();
    }

    @Override
    public FinancialSituation save(FinancialSituation baseEntity) {
        return financialSituationRepo.save(baseEntity);
    }

    @Override
    public FinancialSituation getById(Long id) {
        return financialSituationRepo.findById(id).get();
    }

    @Override
    public void delete(Long id) {
        financialSituationRepo.delete(getById(id));
    }

}
