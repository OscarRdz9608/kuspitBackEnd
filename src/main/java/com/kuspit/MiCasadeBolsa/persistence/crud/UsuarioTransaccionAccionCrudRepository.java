package com.kuspit.MiCasadeBolsa.persistence.crud;

import com.kuspit.MiCasadeBolsa.persistence.entity.UsuarioTransaccionAccion;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface UsuarioTransaccionAccionCrudRepository extends CrudRepository<UsuarioTransaccionAccion, Integer> {
   /* @Query(value = "SELECT * FROM acciones WHERE id_accion=?", nativeQuery = true)
    Optional<UsuarioTransaccionAccion> getByIdUsuarioTransaccionAccion(int idUsuarioTransaccionAccion);*/

    //Optional<UsuarioTransaccionAccion> findByIdUsuariosTransaccionesAcciones(int idUsuarioTransaccionAccion);

    Optional<UsuarioTransaccionAccion> findBySimboloAccion(String simboloAccion);

    @Query(value = "SELECT acciones.* FROM acciones LEFT JOIN transacciones ON acciones.id_accion = transacciones.id_accion AND transacciones.id_usuario = :userId WHERE transacciones.id_transaccion IS NULL", nativeQuery = true)
    List<UsuarioTransaccionAccion> getAvailable(@Param("userId") String userId);

    @Query(value = "select * from usuarios_transacciones_acciones where id_usuario = :userId", nativeQuery = true)
    List<UsuarioTransaccionAccion> findByUserId(@Param("userId") String userId);


}
