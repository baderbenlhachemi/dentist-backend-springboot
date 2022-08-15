package ma.emsipfa.planetdentist.rest;

import ma.emsipfa.planetdentist.entity.Staff;
import ma.emsipfa.planetdentist.security.utils.PasswordGenerator;
import ma.emsipfa.planetdentist.service.RoleService;
import ma.emsipfa.planetdentist.service.StaffService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping(value = "/staff")
public class StaffRest implements BaseInterfaceRest<Staff> {

    private final StaffService staffService;

    private final RoleService roleService;

    private final PasswordEncoder encoder;

    @Autowired
    public StaffRest(StaffService staffService, RoleService roleService, PasswordEncoder encoder) {
        this.staffService = staffService;
        this.roleService = roleService;
        this.encoder = encoder;
    }

    @GetMapping(value = "")
    public ResponseEntity<List<Staff>> getAll() {
        return new ResponseEntity<>(staffService.getAll(), HttpStatus.OK);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Staff> getById(@PathVariable Long id) {
        return new ResponseEntity<>(staffService.getById(id), HttpStatus.OK);
    }

    @PostMapping(value = "/save")
    public ResponseEntity<Staff> save(@RequestBody Staff staff) {
        System.out.println("staff.getId() = " + staff.getId());
        System.out.println(staff.getRoles());

        // Generate Random Password
        String password = PasswordGenerator.generateStrongPassword();
        staff.setGeneratedPassword(password);
        staff.setPassword(encoder.encode(password));

        // Save
        Staff savedStaff = staffService.save(staff);

        return new ResponseEntity<>(savedStaff, HttpStatus.CREATED);
    }

    @PostMapping(value = "/update/{id}")
    @Override
    public ResponseEntity<Staff> update(@PathVariable Long id, @RequestBody Staff staff) {
        staff.setId(id);

        return new ResponseEntity<>(staffService.save(staff), HttpStatus.OK);
    }

    @DeleteMapping(value = "/delete/{id}")
    public ResponseEntity<Object> delete(@PathVariable Long id) {
        staffService.delete(id);

        return new ResponseEntity<>("Staff deleted", HttpStatus.OK);
    }
}
