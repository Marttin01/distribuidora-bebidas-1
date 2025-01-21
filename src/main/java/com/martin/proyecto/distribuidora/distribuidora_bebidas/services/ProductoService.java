package com.martin.proyecto.distribuidora.distribuidora_bebidas.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.martin.proyecto.distribuidora.distribuidora_bebidas.entities.Producto;

@Service
public interface ProductoService {

    List<Producto> findAll();

    Optional<Producto> findById(String id);

    Producto save(Producto producto);

    Optional<Producto> update(String id, Producto producto);

    Optional<Producto> delete(String id);

}
