package com.martin.proyecto.distribuidora.distribuidora_bebidas.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.martin.proyecto.distribuidora.distribuidora_bebidas.entities.Rol;
import com.martin.proyecto.distribuidora.distribuidora_bebidas.entities.Usuario;
import com.martin.proyecto.distribuidora.distribuidora_bebidas.repositories.UsuarioRepository;

@Service
public class JpaUserDetailsService implements UserDetailsService{

    @Autowired
    private UsuarioRepository repository;

    @Transactional(readOnly = true)
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    
        Optional<Usuario> usuarioOptional = repository.findByUsername(username);

        if(usuarioOptional.isEmpty()){
            throw new UsernameNotFoundException(String.format("Username %s no existe en el sitema", username));
        }

        Usuario usuario = usuarioOptional.orElseThrow();
        List<Rol> roles = new ArrayList<>();
        roles.add(usuario.getRol());

        List<GrantedAuthority> authorities = roles.stream().map(role -> new SimpleGrantedAuthority(role.getNombre())).collect(Collectors.toList());


        return new User(usuario.getUsername(), usuario.getPassword(), usuario.isActivo(), true, true, true, authorities);
    }

}
