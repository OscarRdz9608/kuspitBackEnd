package com.kuspit.MiCasadeBolsa.persistence.mapper;


import com.kuspit.MiCasadeBolsa.domain.Transaction;
import com.kuspit.MiCasadeBolsa.persistence.entity.Transaccion;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

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


    @InheritInverseConfiguration
    //@Mapping(target = "transacciones", ignore = true)
    Transaccion toTransaccion (Transaction transaction);


}
