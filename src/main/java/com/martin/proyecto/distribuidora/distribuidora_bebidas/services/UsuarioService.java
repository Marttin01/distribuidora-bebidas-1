package com.martin.proyecto.distribuidora.distribuidora_bebidas.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.martin.proyecto.distribuidora.distribuidora_bebidas.entities.Usuario;

@Service
public interface UsuarioService {

    List<Usuario> findAll();

    Optional<Usuario> findById(String id);
    
    Usuario save(Usuario usuario);

    Optional<Usuario> update(String id, Usuario usuario);

    Optional<Usuario> delete(String id);

    boolean existsByMail(String mail);

    boolean existsByUsername(String username);

    boolean existByRolNombre(string nombre);
}
