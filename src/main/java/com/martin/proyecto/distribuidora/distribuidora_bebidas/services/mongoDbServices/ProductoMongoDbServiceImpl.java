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
        return repository.save(producto);
    }

    @Override
    public Optional<ProductoMongodb> update(String id, ProductoMongodb producto) {
        Optional<ProductoMongodb> optionalProducto = repository.findById(id);
        if(optionalProducto.isPresent()){
            ProductoMongodb p = optionalProducto.orElseThrow();
            p.setTitulo(producto.getTitulo());
            p.setDescripcion(producto.getDescripcion());
            p.setStock(producto.getStock());
            Long s = producto.getStock();
            if(s == 0) {
                p.setActivo(false);
            }else p.setActivo(true);
            p.setPrecio(producto.getPrecio());
        }

        return optionalProducto;
    
    }

    @Override
    public Optional<ProductoMongodb> delete(String id) {
        Optional<ProductoMongodb> optionalProducto = repository.findById(id);
        if(optionalProducto.isPresent()){
            repository.deleteById(id);
        }
        return optionalProducto;
    }
    
}
