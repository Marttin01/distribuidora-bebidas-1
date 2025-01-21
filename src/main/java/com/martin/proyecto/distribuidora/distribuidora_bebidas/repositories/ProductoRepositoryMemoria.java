/*package com.martin.proyecto.distribuidora.distribuidora_bebidas.repositories;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;


import com.martin.proyecto.distribuidora.distribuidora_bebidas.entities.Producto;

public class ProductoRepositoryMemoria{

    private Map<UUID, Producto> productos = new HashMap<>();

    public List<Producto> findAll(){
        return new ArrayList<>(productos.values());
    }

    public Optional<Producto> findById(UUID id){
        return Optional.ofNullable(productos.get(id));
    }

    public <S extends Producto> S save(S entity) {
        if (entity.getId() == null) {
            entity.setId(UUID.randomUUID());
        }
        if(entity.getStock() == 0){
            entity.setActivo(false);
        }else entity.setActivo(true);
        productos.put(entity.getId(), entity);
        return entity;
    }

    public void delete(UUID id) {
        productos.remove(id);
    }

} */
