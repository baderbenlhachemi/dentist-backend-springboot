package ma.emsipfa.planetdentist.rest.auth;

import ma.emsipfa.planetdentist.entity.*;
import ma.emsipfa.planetdentist.payload.request.LoginRequest;
import ma.emsipfa.planetdentist.payload.request.SignupRequest;
import ma.emsipfa.planetdentist.payload.response.JwtResponse;
import ma.emsipfa.planetdentist.payload.response.MessageResponse;
import ma.emsipfa.planetdentist.repository.PatientRepo;
import ma.emsipfa.planetdentist.repository.RoleRepo;
import ma.emsipfa.planetdentist.repository.StaffRepo;
import ma.emsipfa.planetdentist.repository.UserRepo;
import ma.emsipfa.planetdentist.security.jwt.JwtUtils;
import ma.emsipfa.planetdentist.security.service.UserDetailsImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseCookie;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/auth")
public class AuthRest {
    AuthenticationManager authenticationManager;
    UserRepo userRepo;
    PatientRepo patientRepo;
    StaffRepo staffRepo;
    RoleRepo roleRepo;
    PasswordEncoder encoder;
    JwtUtils jwtUtils;

    @Autowired
    AuthRest(AuthenticationManager authenticationManager, UserRepo userRepo, PatientRepo patientRepo, StaffRepo staffRepo, RoleRepo roleRepo, PasswordEncoder encoder, JwtUtils jwtUtils) {
        this.authenticationManager = authenticationManager;
        this.userRepo = userRepo;
        this.patientRepo = patientRepo;
        this.staffRepo = staffRepo;
        this.roleRepo = roleRepo;
        this.encoder = encoder;
        this.jwtUtils = jwtUtils;
    }

    @PostMapping("/admin/signin")
    public ResponseEntity<?> authenticateUser(@Valid @RequestBody LoginRequest loginRequest) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword()));
        SecurityContextHolder.getContext().setAuthentication(authentication);

        String jwt = jwtUtils.generateJwtToken(authentication);
        ResponseCookie cookie = jwtUtils.generateJwtCookie(authentication);

        UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();

        List<String> roles = userDetails.getAuthorities().stream()
                .map(GrantedAuthority::getAuthority)
                .collect(Collectors.toList());

        return ResponseEntity.ok()
                .header(HttpHeaders.SET_COOKIE, cookie.toString())
                .body(new JwtResponse(jwt,
                    userDetails.getId(),
                    userDetails.getUsername(),
                    userDetails.getFirstName(),
                    userDetails.getLastName(),
                    userDetails.getEmail(),
                    roles));
    }

    @PostMapping("/admin/signup")
    public ResponseEntity<?> registerStaff(@Valid @RequestBody SignupRequest signUpRequest) {
        if (userRepo.existsByUsername(signUpRequest.getUsername())) {
            return ResponseEntity
                    .badRequest()
                    .body(new MessageResponse("Error: Username is already taken!"));
        }
        if (userRepo.existsByEmail(signUpRequest.getEmail())) {
            return ResponseEntity
                    .badRequest()
                    .body(new MessageResponse("Error: Email is already in use!"));
        }

        // Create new user's account
        User user = new User(signUpRequest.getFirstName(), signUpRequest.getLastName(), signUpRequest.getCin(), signUpRequest.getUsername(),
                signUpRequest.getEmail(),
                encoder.encode(signUpRequest.getPassword()));
        Set<String> strRoles = signUpRequest.getRole();
        Set<Role> roles = new HashSet<>();

        if (strRoles == null) {
            Role userRole = roleRepo.findByName(ERole.ROLE_PATIENT)
                    .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
            roles.add(userRole);
        } else {
            strRoles.forEach(role -> {
                switch (role) {
                    case "admin" -> {
                        Role adminRole = roleRepo.findByName(ERole.ROLE_ADMIN)
                                .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
                        roles.add(adminRole);
                    }
                    case "doctor" -> {
                        Role modRole = roleRepo.findByName(ERole.ROLE_DOCTOR)
                                .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
                        roles.add(modRole);
                    }
                    case "secretary" -> {
                        Role secretaryRole = roleRepo.findByName(ERole.ROLE_SECRETARY)
                                .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
                        roles.add(secretaryRole);
                    }
                    default -> {
                        Role userRole = roleRepo.findByName(ERole.ROLE_PATIENT)
                                .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
                        roles.add(userRole);
                    }
                }
            });
        }

        user.setRoles(roles);

        Staff staff= new Staff(user.getFirstName(), user.getLastName(), user.getCin(), user.getUsername(), user.getEmail(), user.getPassword());
        staff.setRoles(roles);
        staffRepo.save(staff);

        return ResponseEntity.ok(new MessageResponse("User registered successfully!"));
    }

    @PostMapping("/admin/signout")
    public ResponseEntity<?> logoutUser() {
        // Clear JWT Token
        SecurityContextHolder.getContext().setAuthentication(null);

        // Clear JWT Cookie
        ResponseCookie cookie = jwtUtils.getCleanJwtCookie();

        return ResponseEntity.ok()
                .header(HttpHeaders.SET_COOKIE, cookie.toString())
                .body(new MessageResponse("User logged out successfully!"));
    }

    @PostMapping("/public/signin")
    public ResponseEntity<?> authenticatePatient(@Valid @RequestBody LoginRequest loginRequest) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword()));
        SecurityContextHolder.getContext().setAuthentication(authentication);

        String jwt = jwtUtils.generateJwtToken(authentication);
        ResponseCookie cookie = jwtUtils.generateJwtCookie(authentication);

        UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();

        List<String> roles = userDetails.getAuthorities().stream()
                .map(GrantedAuthority::getAuthority)
                .collect(Collectors.toList());

        return ResponseEntity.ok()
                .header(HttpHeaders.SET_COOKIE, cookie.toString())
                .body(new JwtResponse(jwt,
                        userDetails.getId(),
                        userDetails.getUsername(),
                        userDetails.getFirstName(),
                        userDetails.getLastName(),
                        userDetails.getEmail(),
                        roles));
    }

    @PostMapping("/public/signup")
    public ResponseEntity<MessageResponse> registerPatient(@Valid @RequestBody SignupRequest signUpRequest) {
        if (userRepo.existsByUsername(signUpRequest.getUsername())) {
            return ResponseEntity
                    .badRequest()
                    .body(new MessageResponse("Error: Username is already taken!"));
        }
        if (userRepo.existsByEmail(signUpRequest.getEmail())) {
            return ResponseEntity
                    .badRequest()
                    .body(new MessageResponse("Error: Email is already in use!"));
        }
        if (userRepo.existsByCin(signUpRequest.getCin())) {
            return ResponseEntity
                    .badRequest()
                    .body(new MessageResponse("Error: Cin is already in use!"));
        }

        // Create new user's account
        User user = new User(signUpRequest.getFirstName(), signUpRequest.getLastName(), signUpRequest.getCin(), signUpRequest.getUsername(),
                signUpRequest.getEmail(),
                encoder.encode(signUpRequest.getPassword()));

        Set<Role> roles = new HashSet<>();
        Role userRole = roleRepo.findByName(ERole.ROLE_PATIENT)
                .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
        roles.add(userRole);

        user.setRoles(roles);

        Patient patient = new Patient(user.getFirstName(), user.getLastName(), user.getCin(), user.getUsername(), user.getEmail(), user.getPassword(), user.getPhoneNumber());
        patient.setRoles(roles);
        patientRepo.save(patient);

        return ResponseEntity.ok(new MessageResponse("User registered successfully!"));
    }

    @PostMapping("/public/signout")
    public ResponseEntity<?> logoutPatient() {
        // Clear JWT Token
        SecurityContextHolder.getContext().setAuthentication(null);

        // Clear JWT Cookie
        ResponseCookie cookie = jwtUtils.getCleanJwtCookie();

        return ResponseEntity.ok()
                .header(HttpHeaders.SET_COOKIE, cookie.toString())
                .body(new MessageResponse("User logged out successfully!"));
    }
}
