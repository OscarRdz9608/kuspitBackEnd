package com.kuspit.MiCasadeBolsa.persistence.crud;

import com.kuspit.MiCasadeBolsa.domain.Transaction;
import com.kuspit.MiCasadeBolsa.persistence.entity.Transaccion;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

public interface TransaccionCrudRepository extends CrudRepository<Transaccion, Integer> {

    @Query(value = "SELECT * FROM transacciones WHERE id_transaccion=:id_transaccion", nativeQuery = true)
    Optional<Transaccion> getByIdTransaccion(@Param("id_transaccion") int idTransaccion);

    Optional<Transaccion> findByIdTransaccion(int idTransaccion);

    Transaction save (Transaction transaction);


//  @Query(value = "INSERT INTO transacciones (id_usuario, id_accion, fecha_transaccion, tipo_transaccion) VALUES (:id_usuario, :id_accion, NOW(), 'COMPRA')", nativeQuery = true)
  //void  saveTransaction(@Param("id_usuario") String id_Usuario, @Param("id_accion") int id_accion );


  // @Modifying
    //@Query(value = "INSERT INTO transacciones (id_usuario, id_accion, fecha_transaccion, tipo_transaccion) VALUES (:id_usuario, :id_accion, NOW(), 'VENTA')", nativeQuery = true)
    //Transaction sellTransaction(@Param("id_usuario") String id_Usuario, @Param("id_accion") int id_accion );


}
