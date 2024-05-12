package com.kuspit.MiCasadeBolsa.persistence.crud;

import com.kuspit.MiCasadeBolsa.persistence.entity.Usuario;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface UsuarioCrudRepository extends CrudRepository<Usuario, String> {

    @Query(value = "SELECT * FROM usuarios WHERE id_usuario=?", nativeQuery = true)
    Optional<Usuario> getByIdUsuario(String idUsuario);

    public Optional<Usuario> findByIdUsuario(String idUsuario);

    //SALDO CLIENTE
    public  Optional<List<Usuario>> findSaldoByIdUsuario(String idUsuario);

    //LOGIN
    public  Optional<List<Usuario>> findByCorreoAndContrasenia(String correo, String password);

}
