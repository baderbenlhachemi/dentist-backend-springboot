package ma.emsipfa.planetdentist.rest;

import ma.emsipfa.planetdentist.entity.ERole;
import ma.emsipfa.planetdentist.entity.Patient;
import ma.emsipfa.planetdentist.entity.Role;
import ma.emsipfa.planetdentist.security.utils.PasswordGenerator;
import ma.emsipfa.planetdentist.service.PatientService;
import ma.emsipfa.planetdentist.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.beans.Encoder;
import java.util.*;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping(value = "/patient")
public class PatientRest implements BaseInterfaceRest<Patient> {

    private final PatientService patientService;

    private final RoleService roleService;

    private final PasswordEncoder encoder;

    @Autowired
    public PatientRest(PatientService patientService, RoleService roleService, PasswordEncoder encoder) {
        this.patientService = patientService;
        this.roleService = roleService;
        this.encoder = encoder;
    }

    @GetMapping(value = "")
    public ResponseEntity<List<Patient>> getAll() {
        return new ResponseEntity<>(patientService.getAll(), HttpStatus.OK);
    }

    /**
     * API GET
     * Return a patient by id
     *
     * @param id
     * @return
     */
    @GetMapping(value = "/{id}")
    public ResponseEntity<Patient> getById(@PathVariable Long id) {
        return new ResponseEntity<>(patientService.getById(id), HttpStatus.OK);
    }

    /**
     * API POST
     * Save or Update a patient
     *
     * @param patient
     * @return
     */
    @PostMapping(value = "/save")
    public ResponseEntity<Patient> save(@Valid @RequestBody Patient patient) {
        // Generate Random Password
        String password = PasswordGenerator.generateStrongPassword();
        patient.setGeneratedPassword(password);
        patient.setPassword(encoder.encode(password));

        // Give role to patient
        Role role = roleService.findByName(ERole.ROLE_PATIENT).get();
        Set<Role> roles = new HashSet<>();
        roles.add(role);
        patient.setRoles(roles);

        // Save
        Patient savedPatient = patientService.save(patient);

        return new ResponseEntity<>(savedPatient, HttpStatus.CREATED);
    }

    /**
     * API UPDATE
     * Update a patient
     * @param id
     * @param patient
     * @return
     */
    @PutMapping(value = "/update/{id}")
    public ResponseEntity<Patient> update(@PathVariable Long id, @RequestBody Patient patient) {
        // Find patient by id
        Patient patientToUpdate = patientService.getById(id);

        // Update patient
        patient.setId(id);
        patient.setPassword(patientToUpdate.getPassword());

        return new ResponseEntity<>(patientService.save(patient), HttpStatus.OK);
    }

    /**
     * API DELETE
     * Delete a patient by id
     *
     * @param id
     */
    @DeleteMapping(value = "/delete/{id}")
    public ResponseEntity<Object> delete(@PathVariable Long id) {
        patientService.delete(id);
        return new ResponseEntity<>("Deleted", HttpStatus.ACCEPTED);
    }

}