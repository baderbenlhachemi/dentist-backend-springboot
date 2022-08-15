package ma.emsipfa.planetdentist.service.impl;

import ma.emsipfa.planetdentist.entity.Medication;
import ma.emsipfa.planetdentist.repository.MedicationRepo;
import ma.emsipfa.planetdentist.service.MedicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.List;

@Service
public class MedicationServiceImpl implements MedicationService {
    private final MedicationRepo medicationRepo;

    @Autowired
    public MedicationServiceImpl(MedicationRepo medicationRepo) {
        this.medicationRepo = medicationRepo;
    }

    @Override
    public List<Medication> getAll() {
        return medicationRepo.findAll();
    }

    @Override
    public Medication save(Medication baseEntity) {
        return medicationRepo.save(baseEntity);
    }

    @Override
    public Medication getById(Long id) {
        return medicationRepo.findById(id).get();
    }

    @Override
    public void delete(Long id) {
        medicationRepo.deleteById(id);
    }

    @Override
    public List<Object> findByName(String name) {
        return medicationRepo.findByName(name);
    }

    @Override
    public List<Object> findByPrice(Double price) {
        return medicationRepo.findByPrice(price);
    }

    @Override
    public List<Object> findByPriceBetween(Double price1, Double price2) {
        return medicationRepo.findByPriceBetween(price1,price2);
    }
}
