package com.kuspit.MiCasadeBolsa.persistence.mapper;

import com.kuspit.MiCasadeBolsa.domain.Transaction;
import com.kuspit.MiCasadeBolsa.persistence.entity.Transaccion;
import javax.annotation.processing.Generated;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-05-11T22:55:40-0600",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 11.0.22 (Eclipse Adoptium)"
)
@Component
public class TransactionMapperImpl implements TransactionMapper {

    @Autowired
    private UserMapper userMapper;
    @Autowired
    private ActionMapper actionMapper;

    @Override
    public Transaction toTransaction(Transaccion transaccion) {
        if ( transaccion == null ) {
            return null;
        }

        Transaction transaction = new Transaction();

        if ( transaccion.getIdTransaccion() != null ) {
            transaction.setTransactionId( transaccion.getIdTransaccion() );
        }
        transaction.setUser( userMapper.toUser( transaccion.getUsuario() ) );
        transaction.setAction( actionMapper.toAction( transaccion.getAccion() ) );
        transaction.setTransactionDate( transaccion.getFechaTransaccion() );
        transaction.setTransactionType( transaccion.getTipoTransaccion() );

        return transaction;
    }

    @Override
    public Transaccion toTransaccion(Transaction transaction) {
        if ( transaction == null ) {
            return null;
        }

        Transaccion transaccion = new Transaccion();

        transaccion.setIdTransaccion( transaction.getTransactionId() );
        transaccion.setUsuario( userMapper.toUsuario( transaction.getUser() ) );
        transaccion.setAccion( actionMapper.toAccion( transaction.getAction() ) );
        transaccion.setFechaTransaccion( transaction.getTransactionDate() );
        transaccion.setTipoTransaccion( transaction.getTransactionType() );

        return transaccion;
    }
}
