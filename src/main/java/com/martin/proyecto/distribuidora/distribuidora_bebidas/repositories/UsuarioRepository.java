package com.martin.proyecto.distribuidora.distribuidora_bebidas.repositories;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.martin.proyecto.distribuidora.distribuidora_bebidas.entities.Usuario;

@Repository
public interface UsuarioRepository extends CrudRepository<Usuario,String>{
    
    boolean existsByMail(String mail);

    boolean existsByUsername(String username);

    boolean existsByRolNombre(String nombre);

    Optional<Usuario> findByMail(String mail);

    Optional<Usuario> findByUsername (String username);

}
