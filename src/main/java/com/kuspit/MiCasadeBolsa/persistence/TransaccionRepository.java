package com.kuspit.MiCasadeBolsa.persistence;

import com.kuspit.MiCasadeBolsa.domain.Action;
import com.kuspit.MiCasadeBolsa.domain.Transaction;
import com.kuspit.MiCasadeBolsa.domain.repository.TransactionRepository;
import com.kuspit.MiCasadeBolsa.persistence.crud.TransaccionCrudRepository;
import com.kuspit.MiCasadeBolsa.persistence.entity.Accion;
import com.kuspit.MiCasadeBolsa.persistence.entity.Transaccion;
import com.kuspit.MiCasadeBolsa.persistence.mapper.ActionMapper;
import com.kuspit.MiCasadeBolsa.persistence.mapper.TransactionMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class TransaccionRepository implements TransactionRepository {
    @Autowired
    private TransactionMapper transactionMapper;
    @Autowired
    private TransaccionCrudRepository transaccionCrudRepository;

    @Override
    public List<Transaction> getAll() {
        List<Transaccion> transacciones = (List<Transaccion>) transaccionCrudRepository.findAll();
        return transactionMapper.toTransactions(transacciones);
    }



    @Override
    public Optional<Transaction> findByTransactionId(int transactionId) {
        return transaccionCrudRepository.findById(transactionId).map(transaccion -> transactionMapper.toTransaction(transaccion));
    }

    @Override
    public Optional<Transaction> getByTransaction(int transactionId) {
        return transaccionCrudRepository.getByIdTransaccion(transactionId).map(transaccion -> transactionMapper.toTransaction(transaccion));
    }

    @Override
    public Transaction save(Transaction transaction) {
        Transaccion trans = transactionMapper.toTransaccion(transaction);
        return transactionMapper.toTransaction(transaccionCrudRepository.save(trans));
    }

    @Override
    public void delete (int transactionId) {
        transaccionCrudRepository.deleteById(transactionId);
    }
}
