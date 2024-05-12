package com.kuspit.MiCasadeBolsa.persistence;

import com.kuspit.MiCasadeBolsa.domain.User;
import com.kuspit.MiCasadeBolsa.domain.dto.UserBalanceDTO;
import com.kuspit.MiCasadeBolsa.domain.repository.UserRepository;
import com.kuspit.MiCasadeBolsa.persistence.crud.UsuarioCrudRepository;
import com.kuspit.MiCasadeBolsa.persistence.entity.Usuario;
import com.kuspit.MiCasadeBolsa.persistence.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

@Repository
public class UsuarioRepository implements UserRepository {

    @Autowired
    private UserMapper mapper;
    @Autowired
    private UsuarioCrudRepository usuarioCrudRepository;

    @Override
    public List<User> getAll() {
        List<Usuario> usuarios = (List<Usuario>) usuarioCrudRepository.findAll();
        return mapper.toUsers(usuarios);
    }

    @Override
    public Optional<User> findByIdUser(String userId) {
        return  usuarioCrudRepository.findById(userId).map(usuario -> mapper.toUser(usuario));
    }

    @Override
    public Optional<User> getByUserId(String userId) {
        return usuarioCrudRepository.getByIdUsuario(userId).map(usuario -> mapper.toUser(usuario));
    }

    @Override
    public Optional<User> findBalanceByUserId(String userId) {
        return usuarioCrudRepository.findSaldoByIdUsuario(userId).map(usuario -> mapper.toUser((Usuario) usuario));
    }

    @Override
    public Optional<User> findByEmailAndPassword(String email, String password){
        System.out.println(email+password);
        return  usuarioCrudRepository.findByCorreoAndContrasenia(email, password).map(usuario -> mapper.toUser((Usuario) usuario));
    }

    @Override
    public User save(User user) {
        Usuario usuario = mapper.toUsuario(user);
        return mapper.toUser(usuarioCrudRepository.save(usuario));
    }

    @Override
    public void delete(String userId){
        usuarioCrudRepository.deleteById(userId);
    }

    @Override
    public Optional<UserBalanceDTO> findIdUsuarioAndSaldoByUsuario(String idUsuario) {
        return Optional.empty();
    }


}
