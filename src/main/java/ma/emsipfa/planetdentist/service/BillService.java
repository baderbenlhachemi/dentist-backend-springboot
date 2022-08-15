package ma.emsipfa.planetdentist.service;

import ma.emsipfa.planetdentist.entity.Bill;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface BillService extends BaseInterfaceService<Bill> {
    // Find all bills by status
    List<Bill> getBillsByStatus(String status);

    // Find all bills by FinancialSituation id
    List<Bill> getBillsByFinancialSituation(Long financialSituationId);

}
