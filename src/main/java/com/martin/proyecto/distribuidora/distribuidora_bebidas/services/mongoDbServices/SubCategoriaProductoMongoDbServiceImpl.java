package com.martin.proyecto.distribuidora.distribuidora_bebidas.services.mongoDbServices;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.client.HttpClientErrorException.NotFound;

import com.martin.proyecto.distribuidora.distribuidora_bebidas.entities.mongoDbEntities.SubCategoriaProductoMongodb;
import com.martin.proyecto.distribuidora.distribuidora_bebidas.repositories.mongoDbRepositories.SubCategoriaProductoMongoDbRepository;

public class SubCategoriaProductoMongoDbServiceImpl implements SubCategoriaProductoMongoDbService{

    @Autowired
    private SubCategoriaProductoMongoDbRepository repository;

    @Override
    public List<SubCategoriaProductoMongodb> findAll() {
        return repository.findAll();
    }

    @Override
    public Optional<SubCategoriaProductoMongodb> findById(String id) {
        return repository.findById(id);
    }

    @Override
    public SubCategoriaProductoMongodb save(SubCategoriaProductoMongodb subcategoria) {
        return repository.save(subcategoria);
    }

    @Override
    public SubCategoriaProductoMongodb update(String id, SubCategoriaProductoMongodb subcategoria) {
        return repository.save(subcategoria);
    }

    @Override
    public SubCategoriaProductoMongodb delete(String id) throws NotFound {
        Optional<SubCategoriaProductoMongodb> optionalSub = repository.findById(id);
        if(!optionalSub.isEmpty()){
            repository.deleteById(id);
        }else throw new RuntimeException("El id a eliminar no se ha encontrado");
            
        return optionalSub.orElseThrow();
    }

    @Override
    public SubCategoriaProductoMongodb addProducto(String id, String id2) {
        return null;
    }

    @Override
    public SubCategoriaProductoMongodb deleteProducto(String id, String id2) {
        // TODO Auto-generated method stub
        return null;
    }

}
