package com.kuspit.MiCasadeBolsa.persistence.mapper;


import com.kuspit.MiCasadeBolsa.domain.Transaction;
import com.kuspit.MiCasadeBolsa.persistence.entity.Transaccion;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring", uses = {UserMapper.class, ActionMapper.class})
public interface TransactionMapper {

    @Mappings(
            {
                    @Mapping(source = "idTransaccion", target = "transactionId"),
                    @Mapping(source = "usuario", target = "user"),
                    @Mapping(source = "accion", target = "action"),
                    @Mapping(source = "fechaTransaccion", target = "transactionDate"),
                    @Mapping(source = "tipoTransaccion", target = "transactionType")
            }
    )
    Transaction toTransaction(Transaccion transaccion);

    List<Transaction> toTransactions (List<Transaccion> transacciones);

    @InheritInverseConfiguration
    //@Mapping(target = "transacciones", ignore = true)
    Transaccion toTransaccion (Transaction transaction);


}
