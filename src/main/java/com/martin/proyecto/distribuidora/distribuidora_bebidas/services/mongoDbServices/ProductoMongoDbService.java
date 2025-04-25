package com.martin.proyecto.distribuidora.distribuidora_bebidas.services.mongoDbServices;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.martin.proyecto.distribuidora.distribuidora_bebidas.entities.mongoDbEntities.ProductoMongodb;

@Service
public interface ProductoMongoDbService {
    
    List<ProductoMongodb> findAll();

    Optional<ProductoMongodb> findById(String id);
    
    ProductoMongodb save(ProductoMongodb producto);

    Optional<ProductoMongodb> update(String id, ProductoMongodb producto);

    Optional<ProductoMongodb> delete(String id);

}
