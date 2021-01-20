package springboot.test.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import springboot.test.model.Role;
import springboot.test.model.User;
import springboot.test.repository.RoleRepository;
import springboot.test.repository.UserRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
public class Controller {

    @Autowired
    UserRepository userRepository;

    @Autowired
    RoleRepository roleRepository;

    @GetMapping("/users")
    public ResponseEntity<List<User>> getUsers(){
        List<User> users = new ArrayList<User>();

        users.addAll(userRepository.findAll());

        if(users.isEmpty())
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);

        return new ResponseEntity<>(users, HttpStatus.OK);
    }

    @GetMapping("/roles")
    public ResponseEntity<List<Role>> getRoles(){
        List<Role> roles = new ArrayList<Role>();

        roles.addAll(roleRepository.findAll());

        if(roles.isEmpty())
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);

        return new ResponseEntity<>(roles, HttpStatus.OK);
    }

    @PostMapping("/users")
    public ResponseEntity<User> createUser(@RequestBody User user) {
        try {
            User _user = userRepository
                    .save(new User(user.getName(), user.getUsername(), user.getPassword(),
                            user.getEmail(), user.getPhoneNumber()));
            return new ResponseEntity<>(_user, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/roles/{userId}")
    public ResponseEntity<Role> addRole(@PathVariable String userId, @RequestBody Role role){
        Optional<User> userData = userRepository.findById(userId);
        if(userData.isPresent()){
            role.setUser(userData.get());
            userData.get().addRole(role);
            roleRepository.save(role);
            return new ResponseEntity<>(role,HttpStatus.OK);
        }
        else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/roles/{roleId}")
    public ResponseEntity<?> deleteRole(@PathVariable String roleId){
        Optional<Role> roleData = roleRepository.findById(roleId);
        if(roleData.isPresent()){
            roleRepository.delete(roleData.get());
            return new ResponseEntity<>("role deleted successfully",HttpStatus.OK);
        }
        else {
            return new ResponseEntity<>("role not found", HttpStatus.NOT_FOUND);
        }
    }





}
