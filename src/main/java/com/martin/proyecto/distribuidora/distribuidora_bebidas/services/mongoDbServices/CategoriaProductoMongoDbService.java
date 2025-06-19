package com.martin.proyecto.distribuidora.distribuidora_bebidas.services.mongoDbServices;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.martin.proyecto.distribuidora.distribuidora_bebidas.entities.mongoDbEntities.CategoriaProductoMongodb;

@Service
public interface CategoriaProductoMongoDbService {

    List<CategoriaProductoMongodb> findAll();
    
    Optional<CategoriaProductoMongodb> findById(String id);

    CategoriaProductoMongodb save(CategoriaProductoMongodb categoriaProducto);

    Optional<CategoriaProductoMongodb> update(String id, CategoriaProductoMongodb categoriaProducto);
    
    Optional<CategoriaProductoMongodb> delete(String id);

}
