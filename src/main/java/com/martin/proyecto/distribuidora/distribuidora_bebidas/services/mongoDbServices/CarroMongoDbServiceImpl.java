package com.martin.proyecto.distribuidora.distribuidora_bebidas.services.mongoDbServices;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.martin.proyecto.distribuidora.distribuidora_bebidas.entities.mongoDbEntities.CarroMongodb;
import com.martin.proyecto.distribuidora.distribuidora_bebidas.repositories.mongoDbRepositories.CarroMongoDbRepository;

import jakarta.transaction.Transactional;

@Service
public class CarroMongoDbServiceImpl implements CarroMongoDbService {
    
    @Autowired
    private CarroMongoDbRepository repository;

    @Transactional
    @Override
    public List<CarroMongodb> findAll() {
        return repository.findAll();
    }

    @Transactional
    @Override
    public Optional<CarroMongodb> findById(String id) {
        return repository.findById(id);
    }

    @Override
    public CarroMongodb save(CarroMongodb carro) {
        return repository.save(carro);
    }

    @Override
    public Optional<CarroMongodb> update(String id, CarroMongodb carro) {
        return Optional.empty();
    }

    @Override
    public Optional<CarroMongodb> delete(String id) {
        return Optional.empty();
    }

}
