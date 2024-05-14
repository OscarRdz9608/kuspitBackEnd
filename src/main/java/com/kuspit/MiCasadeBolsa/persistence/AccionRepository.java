package com.kuspit.MiCasadeBolsa.persistence;

import com.kuspit.MiCasadeBolsa.domain.Action;
import com.kuspit.MiCasadeBolsa.domain.repository.ActionRepository;
import com.kuspit.MiCasadeBolsa.persistence.entity.Accion;
import com.kuspit.MiCasadeBolsa.persistence.mapper.ActionMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.kuspit.MiCasadeBolsa.persistence.crud.AccionCrudRepository;
import com.kuspit.MiCasadeBolsa.persistence.mapper.ActionMapper;

import java.util.List;
import java.util.Optional;

@Repository
public class AccionRepository implements ActionRepository {

    @Autowired
    private ActionMapper actionMapper;
    @Autowired
    private AccionCrudRepository accionCrudRepository;

    @Override
    public List<Action> getAll() {
        List<Accion> acciones = (List<Accion>)  accionCrudRepository.findAll();
        return actionMapper.toActions(acciones);
    }

    @Override
    public Optional<Action> findByActionId(int actionId) {
        return accionCrudRepository.findByIdAccion(actionId).map(
                accion -> actionMapper.toAction(accion));
        }

    @Override
    public Optional<Action> getByActionId(int actionId) {
        return accionCrudRepository.getByIdAccion(actionId).map(
                accion -> actionMapper.toAction(accion));
    }

    @Override
    public Action save(Action action) {
        Accion accion =actionMapper.toAccion(action);
        return actionMapper.toAction(accionCrudRepository.save(accion));
    }

    @Override
    public void delete(int actionId) {
        accionCrudRepository.deleteById(actionId);
    }

    @Override
    public List<Action> getAvailable(String idUsuario) {
        List<Accion> transacciones = (List<Accion>) accionCrudRepository.getAvailable(idUsuario);
        return actionMapper.toActions(transacciones);
    }


}
