package com.kuspit.MiCasadeBolsa.persistence.crud;

import com.kuspit.MiCasadeBolsa.domain.dto.UserBalanceDTO;
import com.kuspit.MiCasadeBolsa.persistence.entity.Usuario;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface UsuarioCrudRepository extends CrudRepository<Usuario, String> {

    @Query(value = "SELECT * FROM usuarios WHERE id_usuario=?", nativeQuery = true)
    Optional<Usuario> getByIdUsuario(String idUsuario);

    Optional<Usuario> findByIdUsuario(String idUsuario);

    //SALDO CLIENTE
    Optional<Usuario> findSaldoByIdUsuario(String idUsuario);

    //LOGIN
    Optional<Usuario> findByCorreoAndContrasenia(String correo, String password);

    //public  List<UserBalanceDTO> findSaldoByIdUsuario(String idUsuario);

    Optional<UserBalanceDTO> findIdUsuarioAndSaldoByIdUsuario(String idUsuario);

}
