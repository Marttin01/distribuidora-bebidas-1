package com.martin.proyecto.distribuidora.distribuidora_bebidas.services.mongoDbServices;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.martin.proyecto.distribuidora.distribuidora_bebidas.entities.mongoDbEntities.CarroProductoMongodb;

@Service
public interface CarroProductoMongoDbService {

    List<CarroProductoMongodb> findAll();

    Optional<CarroProductoMongodb> findById(String id);
    
    CarroProductoMongodb save(CarroProductoMongodb carro);

    Optional<CarroProductoMongodb> delete(String id);

}
