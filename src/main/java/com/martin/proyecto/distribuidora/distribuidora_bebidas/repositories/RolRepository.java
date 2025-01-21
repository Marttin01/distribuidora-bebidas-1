package com.martin.proyecto.distribuidora.distribuidora_bebidas.repositories;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.martin.proyecto.distribuidora.distribuidora_bebidas.entities.Rol;

public interface RolRepository extends CrudRepository<Rol,Integer>{

    Optional<Rol> findByNombre(String nombre);

}
