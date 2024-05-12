package com.kuspit.MiCasadeBolsa.domain.repository;

import com.kuspit.MiCasadeBolsa.domain.User;

import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

public interface UserRepository {

    List<User> getAll();

    Optional<User> findByIdUser(String userId);

    Optional<User> getByUserId(String userId);

    Optional<User> findBalanceByUserId(String userId);

    Optional<User> findByEmailAndPassword(String email, String password);

    User save(User user);

    void delete(String userId);



}
