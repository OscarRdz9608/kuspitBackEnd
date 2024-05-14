package com.kuspit.MiCasadeBolsa.persistence.mapper;

import com.kuspit.MiCasadeBolsa.domain.UserTransactionAction;
import com.kuspit.MiCasadeBolsa.persistence.entity.UsuarioTransaccionAccion;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring")
public interface UserTransactionActionMapper {
    @Mappings({
            @Mapping(source = "idUsuarioTransaccionAccion", target = "userTransactionActionId"),
            @Mapping(source = "idUsuario", target = "userId"),
            @Mapping(source = "nombreUsuario", target = "userName"),
            @Mapping(source = "simboloAccion", target = "actionSymbol"),
            @Mapping(source = "nombreEmpresaAccion", target = "companyActionName"),
            @Mapping(source = "precioAccion", target = "actionPrice"),
            @Mapping(source = "volumenAccion", target = "actionVolume"),
            @Mapping(source = "fechaTransaccion", target = "transactionDate")
    })
    UserTransactionAction toUser(UsuarioTransaccionAccion usuarioTransaccionAccion);

    List<UserTransactionAction> toUsers(List<UsuarioTransaccionAccion> userTransactionActions); // Corrección aquí

    @InheritInverseConfiguration
    UsuarioTransaccionAccion toUsuario(UserTransactionAction userTransactionAction);

    List<UsuarioTransaccionAccion> toUsuarios(List<UserTransactionAction> userTransactionActions);

}
