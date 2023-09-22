package com.epicode.InfoSalute.security.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.epicode.InfoSalute.security.entity.User;
import com.epicode.InfoSalute.security.repository.UserRepository;
import com.epicode.InfoSalute.security.service.UserService;

//@RestController
//@RequestMapping("/api/user") // probabilmente da modificare in /user
//public class UserController {
//    @Autowired
//    private UserRepository utenteRepository;
//
//    @GetMapping
//    public List<User> getAllUtenti() {
//        return utenteRepository.findAll();
//    }
//
//    @GetMapping("/{id}")
//    public User getUtenteById(@PathVariable Long id) {
//        return utenteRepository.findById(id).orElse(null);
//    }
//
//    @PostMapping
//    public User createUtente(@RequestBody User utente) {
//        return utenteRepository.save(utente);
//    }
//
//    @PutMapping("/{id}")
//    public User updateUtente(@PathVariable Long id, @RequestBody User utenteDetails) {
//        User utente = utenteRepository.findById(id).orElse(null);
//        if (utente != null) {
//            utente.setUsername(utenteDetails.getUsername());
//            utente.setName(utenteDetails.getName());
//            utente.setSurname(utenteDetails.getSurname());
//            utente.setEmail(utenteDetails.getEmail());
//            return utenteRepository.save(utente);
//        }
//        return null;
//    }
//
//    @DeleteMapping("/{id}")
//    public void deleteUtente(@PathVariable Long id) {
//        utenteRepository.deleteById(id);
//    }
//    
//}
	
@RestController
@RequestMapping("/api/users")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping
    public ResponseEntity<User> createUser(@RequestBody User user) {
        User createdUser = userService.createUser(user);
        return new ResponseEntity<>(createdUser, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> getUserById(@PathVariable Long id) {
        User user = userService.getUserById(id);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @GetMapping("/username/{username}")
    public ResponseEntity<User> getUserByUsername(@PathVariable String username) {
        User user = userService.getUserByUsername(username);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @GetMapping("/email/{email}")
    public ResponseEntity<User> getUserByEmail(@PathVariable String email) {
        User user = userService.getUserByEmail(email);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<User>> getAllUsers() {
        List<User> users = userService.getAllUsers();
        return new ResponseEntity<>(users, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<User> updateUser(@PathVariable Long id, @RequestBody User updatedUser) {
        User user = userService.updateUser(id, updatedUser);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable Long id) {
        userService.deleteUser(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}




