package com.kuspit.MiCasadeBolsa.web.controller;

import com.kuspit.MiCasadeBolsa.domain.User;
import com.kuspit.MiCasadeBolsa.domain.UserTransactionAction;
import com.kuspit.MiCasadeBolsa.domain.dto.LoginRequestDTO;
import com.kuspit.MiCasadeBolsa.domain.dto.UserBalanceDTO;
import com.kuspit.MiCasadeBolsa.domain.service.UserService;
import com.kuspit.MiCasadeBolsa.domain.service.UserTransactionActionService;
import com.kuspit.MiCasadeBolsa.persistence.entity.UsuarioTransaccionAccion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/operations")
public class UserTransactionActionController {

    @Autowired
    private UserTransactionActionService userTransactionActionService;

    @GetMapping("/all")
    public ResponseEntity<List<UserTransactionAction>> getAll() {
        return new ResponseEntity<>(userTransactionActionService.getAll(), HttpStatus.OK);
    }

    @GetMapping("/{userId}")
    public ResponseEntity<List<UserTransactionAction>> getByUserId(@PathVariable("userId") String userId) {
        return new ResponseEntity<>(userTransactionActionService.getByUserId(userId), HttpStatus.OK);
    }


    @PostMapping(value = "/save", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<UserTransactionAction> save(@RequestBody UserTransactionAction userTransactionAction) {
        return new ResponseEntity<> (userTransactionActionService.save(userTransactionAction),HttpStatus.CREATED);

    }





}