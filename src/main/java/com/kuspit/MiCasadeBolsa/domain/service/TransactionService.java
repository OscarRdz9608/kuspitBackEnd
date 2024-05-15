package com.kuspit.MiCasadeBolsa.domain.service;

import com.kuspit.MiCasadeBolsa.domain.Action;
import com.kuspit.MiCasadeBolsa.domain.Transaction;
import com.kuspit.MiCasadeBolsa.domain.repository.TransactionRepository;
import com.kuspit.MiCasadeBolsa.persistence.crud.AccionCrudRepository;
import com.kuspit.MiCasadeBolsa.persistence.crud.TransaccionCrudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TransactionService {
    
    @Autowired
    private TransactionRepository transactionRepository;
    @Autowired
    private TransaccionCrudRepository transaccionCrudRepository;


    public List<Transaction> getAll(){
        return transactionRepository.getAll();
    }

    
    public Optional<Transaction>  getTransaction(int transactionId){
        return transactionRepository.findByTransactionId( transactionId);
    }
    public Optional<Transaction> findByIdTransaction(int transactionId){
        return transactionRepository.getByTransaction(transactionId);
    }
    public Transaction save(Transaction transaction){
       return transactionRepository.save(transaction);
    }

    public boolean deleteUser(int transactionId){
        return getTransaction(transactionId).map(transaction -> {
            transactionRepository.delete(transactionId);
            return true;
        }).orElse(false);
    }
/*
    public void  saveT(String id_usuario, int id_accion){
            // System.out.println(userId + "ui"+ "  ac"+actionId);
        transaccionCrudRepository.saveTransaction(id_usuario, id_accion);
    }*/






}
