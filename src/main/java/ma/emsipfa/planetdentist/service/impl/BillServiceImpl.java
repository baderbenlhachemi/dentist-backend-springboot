package ma.emsipfa.planetdentist.service.impl;

import ma.emsipfa.planetdentist.entity.Bill;
import ma.emsipfa.planetdentist.repository.BillRepo;
import ma.emsipfa.planetdentist.service.BillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BillServiceImpl implements BillService {
    private final BillRepo billRepo;

    @Autowired
    public BillServiceImpl(BillRepo billRepo) {
        this.billRepo = billRepo;
    }

    @Override
    public List<Bill> getAll() {
        return billRepo.findAll();
    }

    @Override
    public Bill save(Bill baseEntity) {
        return billRepo.save(baseEntity);
    }

    @Override
    public Bill getById(Long id) {
        return billRepo.findById(id).get();
    }

    @Override
    public void delete(Long id) {
        billRepo.delete(getById(id));
    }

    @Override
    public List<Bill> getBillsByStatus(String status) {
        return billRepo.findByStatus(status);

    }

    @Override
    public List<Bill> getBillsByFinancialSituation(Long financialSituationId) {
        return billRepo.findByFinancialSituation_Id(financialSituationId);
    }

}
