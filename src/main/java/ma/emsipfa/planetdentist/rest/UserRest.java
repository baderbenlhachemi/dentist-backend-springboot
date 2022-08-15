package ma.emsipfa.planetdentist.rest;

import ma.emsipfa.planetdentist.entity.User;
import ma.emsipfa.planetdentist.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping(value = "/user")
public class UserRest implements BaseInterfaceRest<User> {

    private final UserService userService;

    @Autowired
    public UserRest(UserService userService) {
        this.userService = userService;
    }

    @GetMapping(value = "")
    @PreAuthorize("hasRole('SUPER_ADMIN') or hasRole('ADMIN')")
    public ResponseEntity<List<User>> getAll() {
        return new ResponseEntity<>(userService.getAll(), HttpStatus.OK);
    }

    /**
     * API POST
     * Save or Update a user
     *
     * @param user
     * @return
     */
    @PostMapping(value = "/save")
    @PreAuthorize("hasRole('SUPER_ADMIN') or hasRole('ADMIN')")
    public ResponseEntity<User> save(@RequestBody User user) {
        return new ResponseEntity<>(userService.save(user), HttpStatus.CREATED);
    }

    @PutMapping(value = "/update/{id}")
    @Override
    public ResponseEntity<User> update(@PathVariable Long id, @RequestBody User baseEntity) {
        baseEntity.setId(id);

        return new ResponseEntity<>(userService.save(baseEntity), HttpStatus.OK);
    }

    /**
     * API GET
     * Return a user by id
     *
     * @param id
     * @return
     */
    @GetMapping(value = "/{id}")
    @PreAuthorize("hasRole('SUPER_ADMIN') or hasRole('ADMIN')")
    public ResponseEntity<User> getById(@PathVariable Long id) {
        return new ResponseEntity<>(userService.getById(id), HttpStatus.OK);
    }

    /**
     * API DELETE
     * Delete a user by id
     *
     * @param id
     */
    @DeleteMapping(value = "/delete/{id}")
    @PreAuthorize("hasRole('SUPER_ADMIN') or hasRole('ADMIN')")
    public ResponseEntity<Object> delete(@PathVariable Long id) {
        userService.delete(id);
        return new ResponseEntity<>("Deleted", HttpStatus.ACCEPTED);
    }

}
