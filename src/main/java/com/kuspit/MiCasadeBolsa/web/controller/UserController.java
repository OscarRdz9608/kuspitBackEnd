package com.kuspit.MiCasadeBolsa.web.controller;

import com.kuspit.MiCasadeBolsa.domain.User;
import com.kuspit.MiCasadeBolsa.domain.dto.LoginRequestDTO;
import com.kuspit.MiCasadeBolsa.domain.dto.UserBalanceDTO;
import com.kuspit.MiCasadeBolsa.domain.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
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
 public ResponseEntity<Optional<User>> getUserByMailAndPassword(@RequestParam("email") String email, @RequestParam("password") String password) {
     Optional<User> user = userService.findByEmailAndPassword(email, password);
     if (user.isPresent()) {
         return new ResponseEntity<>(user, HttpStatus.OK);
     } else {
         return new ResponseEntity<>(HttpStatus.NOT_FOUND);
     }
 }

    @PostMapping(value="/log", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Optional<User>> login(@RequestBody LoginRequestDTO loginRequestDTO) {
        Optional<User> user = userService.findByEmailAndPassword(loginRequestDTO.getEmail(), loginRequestDTO.getPassword());
        if (user.isPresent()) {
            return new ResponseEntity<>(user, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

 @PostMapping(value = "/save", consumes = MediaType.APPLICATION_JSON_VALUE)
 public ResponseEntity<User> save(@RequestBody User user) {
     return new ResponseEntity<>(userService.save(user),HttpStatus.CREATED);
    }

    @GetMapping("/balance/{userId}")
    public ResponseEntity<UserBalanceDTO> getSaldoByIdUsuario(@PathVariable("userId") String userId) {
        return userService.getIdUsuarioAndSaldoByUsuario(userId).map(
                        user -> new ResponseEntity<>(user, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));

    }

    @GetMapping("/{userId}")
    public ResponseEntity<User> getUser(@PathVariable("userId") String userId){
        return userService.getUser(userId).map(
                        user -> new ResponseEntity<>(user, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

}