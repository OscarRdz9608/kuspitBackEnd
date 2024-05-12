package com.kuspit.MiCasadeBolsa.persistence.mapper;

import com.kuspit.MiCasadeBolsa.domain.User;
import com.kuspit.MiCasadeBolsa.persistence.entity.Usuario;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring")
public interface UserMapper {
    @Mappings(
            {
                    @Mapping(source = "idUsuario", target = "userId"),
                    @Mapping(source = "nombre", target = "name"),
                    @Mapping(source = "correo", target = "email"),
                    @Mapping(source = "contrasenia", target = "password"),
                    @Mapping(source = "saldo", target = "balance"),
                  //  @Mapping(source = "transacciones", target = "transaction")
                    @Mapping(source = "telefono", target = "phone")
            }
    )
    User toUser(Usuario usuario);

    List<User> toUsers(List<Usuario> usuarios);

    @InheritInverseConfiguration

    Usuario toUsuario (User user);


}
