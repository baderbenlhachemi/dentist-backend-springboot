package ma.emsipfa.planetdentist.service.impl;

import ma.emsipfa.planetdentist.entity.Staff;
import ma.emsipfa.planetdentist.repository.StaffRepo;
import ma.emsipfa.planetdentist.service.StaffService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StaffServiceImpl implements StaffService {

    private final StaffRepo staffRepo;

    @Autowired
    public StaffServiceImpl(StaffRepo staffRepo) {
        this.staffRepo = staffRepo;
    }

    @Override
    public List<Staff> getAll() {
        return staffRepo.findAll();
    }

    @Override
    public Staff save(Staff baseEntity) {
        return staffRepo.save(baseEntity);
    }

    @Override
    public Staff getById(Long id) {
        return staffRepo.findById(id).orElse(null);
    }

    @Override
    public void delete(Long id) {
        staffRepo.deleteById(id);
    }
}
