package com.kuspit.MiCasadeBolsa.persistence.mapper;

import com.kuspit.MiCasadeBolsa.domain.Action;
import com.kuspit.MiCasadeBolsa.persistence.entity.Accion;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-05-12T13:17:53-0600",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 11.0.22 (Eclipse Adoptium)"
)
@Component
public class ActionMapperImpl implements ActionMapper {

    @Override
    public Action toAction(Accion accion) {
        if ( accion == null ) {
            return null;
        }

        Action action = new Action();

        if ( accion.getIdAccion() != null ) {
            action.setActionId( accion.getIdAccion() );
        }
        action.setSymbol( accion.getSimbolo() );
        action.setCompanyName( accion.getNombreEmpresa() );
        action.setLastPrice( String.valueOf( accion.getUltimoPrecio() ) );
        action.setVolume( accion.getVolumen() );

        return action;
    }

    @Override
    public Accion toAccion(Action action) {
        if ( action == null ) {
            return null;
        }

        Accion accion = new Accion();

        accion.setIdAccion( action.getActionId() );
        accion.setSimbolo( action.getSymbol() );
        accion.setNombreEmpresa( action.getCompanyName() );
        if ( action.getLastPrice() != null ) {
            accion.setUltimoPrecio( Double.parseDouble( action.getLastPrice() ) );
        }
        accion.setVolumen( action.getVolume() );

        return accion;
    }
}
