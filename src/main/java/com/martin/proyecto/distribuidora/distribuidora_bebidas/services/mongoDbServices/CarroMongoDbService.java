package com.martin.proyecto.distribuidora.distribuidora_bebidas.services.mongoDbServices;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.martin.proyecto.distribuidora.distribuidora_bebidas.entities.mongoDbEntities.CarroMongodb;

@Service
public interface CarroMongoDbService {
    
    List<CarroMongodb> findAll();

    Optional<CarroMongodb> findById(String id);
    
    CarroMongodb save(CarroMongodb carro);

    Optional<CarroMongodb> delete(String id);

    CarroMongodb addProducto(String id, String id2);

    CarroMongodb deleteProducto(String id, String id2);

}
