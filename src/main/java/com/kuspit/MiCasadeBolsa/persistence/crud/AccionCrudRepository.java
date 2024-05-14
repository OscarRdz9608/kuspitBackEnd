package com.kuspit.MiCasadeBolsa.persistence.crud;

import com.kuspit.MiCasadeBolsa.persistence.entity.Accion;
import com.kuspit.MiCasadeBolsa.persistence.entity.Usuario;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface AccionCrudRepository extends CrudRepository<Accion, Integer> {
    @Query(value = "SELECT * FROM acciones WHERE id_accion=?", nativeQuery = true)
    Optional<Accion> getByIdAccion(@Param("id_accion")int idAccion);

    Optional<Accion> findByIdAccion(int idAccion);

    Optional<Accion> findBySimbolo(String simbolo);

    @Query(value = "SELECT acciones.* FROM acciones LEFT JOIN transacciones ON acciones.id_accion = transacciones.id_accion AND transacciones.id_usuario = :userId WHERE transacciones.id_transaccion IS NULL;", nativeQuery = true)
    List<Accion> getAvailable(@Param("userId") String userId);



}
