package com.kuspit.MiCasadeBolsa.persistence.mapper;

import com.kuspit.MiCasadeBolsa.domain.User;
import com.kuspit.MiCasadeBolsa.persistence.entity.Usuario;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-05-12T01:36:48-0600",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 11.0.22 (Eclipse Adoptium)"
)
@Component
public class UserMapperImpl implements UserMapper {

    @Override
    public User toUser(Usuario usuario) {
        if ( usuario == null ) {
            return null;
        }

        User user = new User();

        user.setUserId( usuario.getIdUsuario() );
        user.setName( usuario.getNombre() );
        user.setEmail( usuario.getCorreo() );
        user.setPassword( usuario.getContrasenia() );
        if ( usuario.getSaldo() != null ) {
            user.setBalance( usuario.getSaldo() );
        }
        user.setPhone( usuario.getTelefono() );

        return user;
    }

    @Override
    public List<User> toUsers(List<Usuario> usuarios) {
        if ( usuarios == null ) {
            return null;
        }

        List<User> list = new ArrayList<User>( usuarios.size() );
        for ( Usuario usuario : usuarios ) {
            list.add( toUser( usuario ) );
        }

        return list;
    }

    @Override
    public Usuario toUsuario(User user) {
        if ( user == null ) {
            return null;
        }

        Usuario usuario = new Usuario();

        usuario.setIdUsuario( user.getUserId() );
        usuario.setNombre( user.getName() );
        usuario.setCorreo( user.getEmail() );
        usuario.setContrasenia( user.getPassword() );
        usuario.setSaldo( user.getBalance() );
        usuario.setTelefono( user.getPhone() );

        return usuario;
    }
}
