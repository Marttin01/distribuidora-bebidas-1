package com.martin.proyecto.distribuidora.distribuidora_bebidas.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.martin.proyecto.distribuidora.distribuidora_bebidas.entities.Producto;
import com.martin.proyecto.distribuidora.distribuidora_bebidas.repositories.ProductoRepository;

@Service
public class ProductoServiceImpl implements ProductoService {

    @Autowired(required = true)
    private ProductoRepository repository;

    @Transactional(readOnly = true)
    @Override
    public List<Producto> findAll() {
        System.out.println("HE PASADO POR EL SERVICE IMPLEMENTADO");
        return (List<Producto>) repository.findAll();
    }   

    @Transactional(readOnly = true)
    @Override
    public Optional<Producto> findById(String id) {
        return repository.findById(id);
    }

    @Transactional
    @Override
    public Producto save(Producto producto) {
        return repository.save(producto);
    }

    @Transactional
    @Override
    public Optional<Producto> update(String id, Producto producto) {
        Optional<Producto> optionalProducto = repository.findById(id);
        if(optionalProducto.isPresent()){
            Producto p = optionalProducto.orElseThrow();
            p.setTitulo(producto.getTitulo());
            p.setDescripcion(producto.getDescripcion());
            p.setStock(producto.getStock());
            p.setPrecio(producto.getPrecio());
            if(p.getStock() == 0){
                p.setActivo(false);
            }else p.setActivo(true);
            return Optional.of(repository.save(p));
        }
        return optionalProducto;
    }

    @Transactional
    @Override
    public Optional<Producto> delete(String id) {
        Optional<Producto> optionalProducto = repository.findById(id);
        optionalProducto.ifPresent(p -> {
            repository.delete(p);
        });
        return optionalProducto;
    }

}
