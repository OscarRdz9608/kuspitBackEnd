package com.kuspit.MiCasadeBolsa.domain.service;

import com.kuspit.MiCasadeBolsa.domain.Action;
import com.kuspit.MiCasadeBolsa.domain.repository.ActionRepository;
import com.kuspit.MiCasadeBolsa.persistence.crud.AccionCrudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ActionService {
    @Autowired
    private ActionRepository actionRepository;

    @Autowired
    private AccionCrudRepository accionCrudRepository;

    public List<Action> getAll(){
        return actionRepository.getAll();
    }

    public Optional<Action> getAction(int actionId){
        return actionRepository.getByActionId(actionId);
    }


    public Optional<Action> finByActionId(int actionId){
        return actionRepository.findByActionId(actionId);
    }

    public Action save(Action  action){
        return actionRepository.save(action);
    }

    public boolean deleteAction(int actionId){
        return getAction(actionId).map(action -> {
            actionRepository.delete(actionId);
            return true;
        }).orElse(false);
    }

    public List<Action> getAvailable(String userId){
        return actionRepository.getAvailable(userId);
    }

}
