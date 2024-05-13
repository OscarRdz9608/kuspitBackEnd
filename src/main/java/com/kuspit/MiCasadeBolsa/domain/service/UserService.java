package com.kuspit.MiCasadeBolsa.domain.service;

import com.kuspit.MiCasadeBolsa.domain.User;
import com.kuspit.MiCasadeBolsa.domain.dto.UserBalanceDTO;
import com.kuspit.MiCasadeBolsa.domain.repository.UserRepository;
import com.kuspit.MiCasadeBolsa.persistence.crud.UsuarioCrudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private UsuarioCrudRepository usuarioCrudRepository;

    public List<User> getAll(){
        return userRepository.getAll();
    }

    public Optional<User> getUser(String userId){
        return userRepository.getByUserId(userId);
    }

    public Optional<User> findByIdUser(String userId){
        return userRepository.findByIdUser(userId);
    }

    public Optional<User> findBalanceByUserId(String userId){
        return userRepository.findBalanceByUserId(userId);
    }

    public Optional<User> findByEmailAndPassword(String email, String password) {
        return userRepository.findByEmailAndPassword(email, password);
    }

    public User save(User user){
      //  user.setBalance(10000);
        return userRepository.save(user);
    }

    public boolean deleteUser(String userId){
        return getUser(userId).map(user ->{
            userRepository.delete(userId);
        return true;
    }).orElse(false);
    }

    public Optional<UserBalanceDTO> getIdUsuarioAndSaldoByUsuario(String userId) {
        return usuarioCrudRepository.findIdUsuarioAndSaldoByIdUsuario(userId);
    }


}
