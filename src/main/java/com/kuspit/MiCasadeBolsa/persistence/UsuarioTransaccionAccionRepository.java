package com.kuspit.MiCasadeBolsa.persistence;


import com.kuspit.MiCasadeBolsa.domain.UserTransactionAction;
import com.kuspit.MiCasadeBolsa.domain.repository.UserTransactionActionRepository;
import com.kuspit.MiCasadeBolsa.persistence.crud.UsuarioTransaccionAccionCrudRepository;
import com.kuspit.MiCasadeBolsa.persistence.entity.UsuarioTransaccionAccion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.kuspit.MiCasadeBolsa.persistence.mapper.UserTransactionActionMapper;

import java.util.List;
import java.util.Optional;

@Repository
public class UsuarioTransaccionAccionRepository implements UserTransactionActionRepository{

    @Autowired
    private UserTransactionActionMapper usuarioTransactionActionMapper;
    @Autowired
    private UsuarioTransaccionAccionCrudRepository usuarioTransaccionAccionCrudRepository;

    @Override
    public List<UserTransactionAction> getAll() {
        return usuarioTransactionActionMapper.toUsers((List<UsuarioTransaccionAccion>) usuarioTransaccionAccionCrudRepository.findAll());
    }

    @Override
    public Optional<UserTransactionAction> getByUserTransactionAction(int userTransactionActionId) {
        return Optional.empty();
    }


    @Override
    public UserTransactionAction save(UserTransactionAction userTransactionAction) {
        UsuarioTransaccionAccion usTrAc = usuarioTransactionActionMapper.toUsuario(userTransactionAction);
        return usuarioTransactionActionMapper.toUser(usuarioTransaccionAccionCrudRepository.save(usTrAc));
    }

    @Override
    public void delete(int userTransactionActionRepositoryId) {
        usuarioTransaccionAccionCrudRepository.deleteById(userTransactionActionRepositoryId);
    }

    @Override
    public List<UserTransactionAction> getAvailable(int UserTransactionActionRepositoryId) {
        return List.of();
    }

    @Override
    public List<UserTransactionAction> findByUserId(String userId) {
        return usuarioTransactionActionMapper.toUsers((List<UsuarioTransaccionAccion>) usuarioTransaccionAccionCrudRepository.findByUserId(userId));
    }


}
