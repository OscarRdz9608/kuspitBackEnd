package com.kuspit.MiCasadeBolsa.persistence.mapper;

import com.kuspit.MiCasadeBolsa.domain.Action;
import com.kuspit.MiCasadeBolsa.persistence.entity.Accion;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ActionMapper {

    @Mappings(
            {
                    @Mapping(source = "idAccion", target = "actionId"),
                    @Mapping(source = "simbolo", target = "symbol"),
                    @Mapping(source = "nombreEmpresa", target = "companyName"),
                    @Mapping(source = "ultimoPrecio", target = "lastPrice"),
                    @Mapping(source = "volumen", target = "volume")
            }
    )
    Action toAction(Accion accion);


    @InheritInverseConfiguration
    @Mapping(target = "transacciones", ignore = true)
    Accion toAccion (Action action);

}
