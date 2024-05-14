package com.kuspit.MiCasadeBolsa.domain.repository;

import com.kuspit.MiCasadeBolsa.domain.Action;

import java.util.List;
import java.util.Optional;

public interface ActionRepository {

    List<Action> getAll();

    Optional<Action> findByActionId(int actionId);

    Optional<Action> getByActionId(int actionId);

    Action save(Action action);

    void delete(int actionId);

    List<Action> getAvailable(String idUsuario);

}
