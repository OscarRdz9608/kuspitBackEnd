package com.kuspit.MiCasadeBolsa.web.controller;

import com.kuspit.MiCasadeBolsa.domain.User;
import com.kuspit.MiCasadeBolsa.domain.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("all")
    public ResponseEntity<List<User>> getAll() {
        return new ResponseEntity<>(userService.getAll(), HttpStatus.OK);
    }

    @PostMapping("/login")
    public Optional<User> getUserByMailAndPassword(@PathVariable("mail") String mail, @PathVariable("paswoord") String password) {
        return userService.findByEmailAndPassword(mail, password);
    }

    @PostMapping("/save")
    public ResponseEntity<User> save(@RequestBody User user) {
        return new ResponseEntity<>(userService.save(user),HttpStatus.CREATED);
    }


}