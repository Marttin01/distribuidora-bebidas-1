package com.martin.proyecto.distribuidora.distribuidora_bebidas.services.mongoDbServices;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.martin.proyecto.distribuidora.distribuidora_bebidas.entities.mongoDbEntities.CarroProductoMongodb;
import com.martin.proyecto.distribuidora.distribuidora_bebidas.repositories.mongoDbRepositories.CarroProductoMongoDbRepository;

public class CarroProductoMongoDbServiceImpl implements CarroProductoMongoDbService {

    @Autowired
    private CarroProductoMongoDbRepository repository;

    @Override
    public List<CarroProductoMongodb> findAll() {
        return repository.findAll();
    }

    @Override
    public Optional<CarroProductoMongodb> findById(String id) {
        return Optional.of(repository.findById(id).orElseThrow());
    }

    @Override
    public CarroProductoMongodb save(CarroProductoMongodb carroProducto) {
        return repository.save(carroProducto);
    }

    @Override
    public Optional<CarroProductoMongodb> delete(String id) {
        return Optional.of(repository.findById(id).orElseThrow());
    }

}
