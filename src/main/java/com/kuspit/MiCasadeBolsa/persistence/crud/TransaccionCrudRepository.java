package com.kuspit.MiCasadeBolsa.persistence.crud;

import com.kuspit.MiCasadeBolsa.domain.dto.UserBalanceDTO;
import com.kuspit.MiCasadeBolsa.persistence.entity.Accion;
import com.kuspit.MiCasadeBolsa.persistence.entity.Transaccion;
import com.kuspit.MiCasadeBolsa.persistence.entity.Usuario;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface TransaccionCrudRepository extends CrudRepository<Transaccion, Integer> {

    @Query(value = "SELECT * FROM transacciones WHERE id_transaccion=:id_transaccion", nativeQuery = true)
    Optional<Transaccion> getByIdTransaccion(@Param("id_transaccion") int idTransaccion);

    Optional<Transaccion> findByIdTransaccion(int idTransaccion);





}
