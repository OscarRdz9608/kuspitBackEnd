package com.kuspit.MiCasadeBolsa.web.controller;


import com.kuspit.MiCasadeBolsa.domain.Action;
import com.kuspit.MiCasadeBolsa.domain.Transaction;
import com.kuspit.MiCasadeBolsa.domain.dto.TransactionAvailableDTO;
import com.kuspit.MiCasadeBolsa.domain.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/transactions")
public class TransactionController {

    @Autowired
    private TransactionService transactionService;

    @GetMapping("/all")
    public ResponseEntity<List<Transaction>> getAll() {
        return new ResponseEntity<>(transactionService.getAll(), HttpStatus.OK);
    }

    @GetMapping("/{transactionId}")
    public ResponseEntity<Transaction> getTransaction(@PathVariable("transactionId") int transactionId) {
        return transactionService.getTransaction(transactionId).map(
                transaction -> new ResponseEntity<>(transaction, HttpStatus.OK)
        ).orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping(value = "/save", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Transaction> save(@RequestBody Transaction transaction) {
        transactionService.save(transaction);
        return new ResponseEntity<>( transactionService.save(transaction),HttpStatus.CREATED);
    }


    /////////////////////////////////////////////////////
  /*  @PostMapping(value = "/save", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> add(@RequestBody TransactionAvailableDTO transaction) {
        System.out.println(transaction.getId_usuario()+ transaction.getId_action());

     // transactionService.saveT(transaction.getId_usuario(), transaction.getId_action());
        return new ResponseEntity<>(HttpStatus.CREATED);
    }



*/
}


