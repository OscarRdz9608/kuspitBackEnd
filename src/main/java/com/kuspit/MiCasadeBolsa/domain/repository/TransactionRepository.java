package com.kuspit.MiCasadeBolsa.domain.repository;

import com.kuspit.MiCasadeBolsa.domain.Action;
import com.kuspit.MiCasadeBolsa.domain.Transaction;

import java.util.List;
import java.util.Optional;

public interface TransactionRepository {

    List<Transaction> getAll();
    Optional<Transaction> findByTransactionId(int transactionId);
    Optional<Transaction> getByTransaction(int transactionId);
    Transaction save (Transaction transaction);
    void  delete(int transactionId);


}
