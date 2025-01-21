package com.martin.proyecto.distribuidora.distribuidora_bebidas.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.martin.proyecto.distribuidora.distribuidora_bebidas.entities.Producto;
import java.util.Optional;


@Repository
public interface ProductoRepository extends CrudRepository<Producto,String>{

    Optional<Producto> findById(String id);

}
