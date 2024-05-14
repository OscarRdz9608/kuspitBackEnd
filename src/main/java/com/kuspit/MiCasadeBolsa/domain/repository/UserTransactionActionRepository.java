package com.kuspit.MiCasadeBolsa.domain.repository;

import com.kuspit.MiCasadeBolsa.domain.UserTransactionAction;

import java.util.List;
import java.util.Optional;


public interface UserTransactionActionRepository {
    List<UserTransactionAction> getAll();

    //Optional<UserTransactionAction> findByUsuarioTransaccionAccionId(int userTransactionActionId);

    Optional<UserTransactionAction> getByUserTransactionAction(int userTransactionActionId);

    UserTransactionAction save(UserTransactionAction userTransactionAction);

    void delete(int userTransactionActionId);

    List<UserTransactionAction> getAvailable(int UserTransactionActionId);

    List<UserTransactionAction> findByUserId(String userId);
}
