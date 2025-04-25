package com.martin.proyecto.distribuidora.distribuidora_bebidas.repositories;

import java.util.Optional;

import org.springframework.context.annotation.Profile;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.martin.proyecto.distribuidora.distribuidora_bebidas.entities.Rol;

@Repository
@Profile("jpa")
public interface RolRepository extends CrudRepository<Rol,Integer>{

    Optional<Rol> findByNombre(String nombre);

}
