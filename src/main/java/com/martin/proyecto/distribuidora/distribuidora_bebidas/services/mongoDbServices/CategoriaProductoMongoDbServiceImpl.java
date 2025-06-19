package com.martin.proyecto.distribuidora.distribuidora_bebidas.services.mongoDbServices;

import java.util.List;
import java.util.Optional;


import com.martin.proyecto.distribuidora.distribuidora_bebidas.entities.mongoDbEntities.CategoriaProductoMongodb;
import com.martin.proyecto.distribuidora.distribuidora_bebidas.repositories.mongoDbRepositories.CategoriaProductoMongoDbRepository;

public class CategoriaProductoMongoDbServiceImpl implements CategoriaProductoMongoDbService{

    private CategoriaProductoMongoDbRepository repository;

    @Override
    public List<CategoriaProductoMongodb> findAll() {
        return repository.findAll();
    }

    @Override
    public Optional<CategoriaProductoMongodb> findById(String id) {
        return Optional.of(repository.findById(id).orElseThrow());
    }

    @Override
    public CategoriaProductoMongodb save(CategoriaProductoMongodb categoriaProducto) {
        return repository.save(categoriaProducto);
    }

    @Override
    public Optional<CategoriaProductoMongodb> update(String id, CategoriaProductoMongodb categoriaProducto) {
        return repository.findById(id);
    }

    @Override
    public Optional<CategoriaProductoMongodb> delete(String id) {
        Optional<CategoriaProductoMongodb> categoriaOptional = repository.findById(id);
        if (categoriaOptional.isPresent()) {
            repository.deleteById(id);
            return categoriaOptional;
        } else {
            throw new RuntimeException("CategoriaProducto not found with id: " + id);
        }
    }

}
