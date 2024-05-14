package com.kuspit.MiCasadeBolsa.domain.service;

import com.kuspit.MiCasadeBolsa.domain.UserTransactionAction;
import com.kuspit.MiCasadeBolsa.domain.repository.UserTransactionActionRepository;
import com.kuspit.MiCasadeBolsa.persistence.crud.UsuarioTransaccionAccionCrudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserTransactionActionService {

    @Autowired
    private UserTransactionActionRepository userTransactionActionRepository;
    @Autowired
    private  UsuarioTransaccionAccionCrudRepository usuarioTransaccionAccionCrudRepository;


    public List<UserTransactionAction> getAll() {
        return userTransactionActionRepository.getAll();
    }

    public List<UserTransactionAction> getByUserId(String userId) {
        return userTransactionActionRepository.findByUserId(userId);
    }

    public Optional<UserTransactionAction> getUserTransactionAction(int userTransactionActionId){
        return userTransactionActionRepository.getByUserTransactionAction(userTransactionActionId);
    }

    public List<UserTransactionAction> findByUsuarioTransaccionAccionId(String userId) {
        return userTransactionActionRepository.findByUserId(userId);
    }

    public Optional<UserTransactionAction> getByUserTransactionActionService(int userTransactionActionServiceId) {
        return userTransactionActionRepository.getByUserTransactionAction(userTransactionActionServiceId);
    }

    public UserTransactionAction save(UserTransactionAction userTransactionAction) {
        return userTransactionActionRepository.save(userTransactionAction);
    }

    public boolean delete(int userTransactionActionRepositoryId) {
        return getUserTransactionAction(userTransactionActionRepositoryId).map(userTransactionAction -> {
            userTransactionActionRepository.delete(userTransactionActionRepositoryId);
            return true;
        }).orElse(false);
    }

    public List<UserTransactionAction> findByUserId(String userId) {
        return userTransactionActionRepository.findByUserId(userId);
    }





}
