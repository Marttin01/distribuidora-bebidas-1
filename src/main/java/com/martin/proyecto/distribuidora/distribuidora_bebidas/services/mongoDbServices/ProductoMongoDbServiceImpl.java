package com.martin.proyecto.distribuidora.distribuidora_bebidas.services.mongoDbServices;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.martin.proyecto.distribuidora.distribuidora_bebidas.entities.mongoDbEntities.ProductoMongodb;
import com.martin.proyecto.distribuidora.distribuidora_bebidas.repositories.mongoDbRepositories.ProductoMongoDbRepository;

import jakarta.transaction.Transactional;

@Service
public class ProductoMongoDbServiceImpl implements ProductoMongoDbService {

    @Autowired
    private ProductoMongoDbRepository repository;

    @Transactional
    @Override
    public List<ProductoMongodb> findAll() {
        return repository.findAll();
    }

    @Transactional
    @Override
    public Optional<ProductoMongodb> findById(String id) {
        return repository.findById(id);
    }

    @Override
    public ProductoMongodb save(ProductoMongodb producto) {
        return null;
    }

    @Override
    public Optional<ProductoMongodb> update(String id, ProductoMongodb producto) {
        return Optional.empty();
    }

    @Override
    public Optional<ProductoMongodb> delete(String id) {
        return Optional.empty();
    }
    
}
