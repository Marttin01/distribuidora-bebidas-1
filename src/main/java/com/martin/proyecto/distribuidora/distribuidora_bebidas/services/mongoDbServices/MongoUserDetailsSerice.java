package com.martin.proyecto.distribuidora.distribuidora_bebidas.services.mongoDbServices;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.martin.proyecto.distribuidora.distribuidora_bebidas.entities.mongoDbEntities.UsuarioMongodb;
import com.martin.proyecto.distribuidora.distribuidora_bebidas.repositories.mongoDbRepositories.UsuarioMongoDbRepository;

@Service
@Profile("mongo")
public class MongoUserDetailsSerice implements UserDetailsService{

    @Autowired
    private UsuarioMongoDbRepository repository;

    @Transactional(readOnly = true)
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        
        Optional<UsuarioMongodb> optionalUsuario = repository.findByUsername(username);

        if(optionalUsuario.isEmpty()){
            throw new UsernameNotFoundException(String.format("Username %s no existe en el sistema", username));
        }

        UsuarioMongodb usuario = optionalUsuario.orElseThrow();
        List<String> roles = List.of(usuario.getRol());

        List<GrantedAuthority> authorities = roles.stream().map(role -> new SimpleGrantedAuthority(role)).collect(Collectors.toList());
        

          return new User(usuario.getUsername(), usuario.getPassword(), usuario.isActivo(), true, true, true, authorities);
    }

}
