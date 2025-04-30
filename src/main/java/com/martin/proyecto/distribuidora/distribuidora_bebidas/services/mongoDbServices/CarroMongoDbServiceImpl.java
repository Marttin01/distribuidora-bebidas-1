package com.martin.proyecto.distribuidora.distribuidora_bebidas.services.mongoDbServices;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.martin.proyecto.distribuidora.distribuidora_bebidas.entities.mongoDbEntities.CarroMongodb;
import com.martin.proyecto.distribuidora.distribuidora_bebidas.entities.mongoDbEntities.CarroProductoMongodb;
import com.martin.proyecto.distribuidora.distribuidora_bebidas.entities.mongoDbEntities.ProductoMongodb;
import com.martin.proyecto.distribuidora.distribuidora_bebidas.repositories.mongoDbRepositories.CarroMongoDbRepository;
import com.martin.proyecto.distribuidora.distribuidora_bebidas.repositories.mongoDbRepositories.ProductoMongoDbRepository;

import jakarta.transaction.Transactional;

@Service
public class CarroMongoDbServiceImpl implements CarroMongoDbService {
    
    @Autowired
    private CarroMongoDbRepository carroRepository;

    @Autowired
    private ProductoMongoDbRepository productoRepository;

    @Transactional
    @Override
    public List<CarroMongodb> findAll() {
        return carroRepository.findAll();
    }

    @Transactional
    @Override
    public Optional<CarroMongodb> findById(String id) {
        return carroRepository.findById(id);
    }

    @Override
    public CarroMongodb save(CarroMongodb carro) {
        return carroRepository.save(carro);
    }

    @Override
    public Optional<CarroMongodb> delete(String id) {
        Optional<CarroMongodb> optionalCarro = carroRepository.findById(id);
        if(optionalCarro.isPresent()){
            carroRepository.delete(optionalCarro.orElseThrow());
        }
        return optionalCarro;
    }

    @Override
    public CarroMongodb addProducto(String id, String id2) {
        Optional<CarroMongodb> optionalCarro = carroRepository.findById(id);
        Optional<ProductoMongodb> optionalProducto = productoRepository.findById(id2);

        if (optionalCarro.isPresent() && optionalProducto.isPresent()) {
            CarroMongodb carro = optionalCarro.orElseThrow();
            ProductoMongodb producto = optionalProducto.orElseThrow();

            CarroProductoMongodb cp = carro.findId(producto.getId());
            CarroProductoMongodb cp2 = new CarroProductoMongodb();

            if(cp != null){
                cp.setCantidad(cp.getCantidad() + 1);
            }else{
                cp2.setCarrito(carro);
                cp2.setProducto(producto);
                cp2.setCantidad(1);

                carro.getProductos().add(cp2);
            }
            return carroRepository.save(carro);
        }
        return optionalCarro.orElseThrow();
    }

    @Override
    public CarroMongodb deleteProducto(String id, String id2) {
        Optional<CarroMongodb> optionalCarro = carroRepository.findById(id);
        Optional<ProductoMongodb> optionalProducto = productoRepository.findById(id2);

        if(optionalCarro.isPresent() && optionalProducto.isPresent()){
            CarroMongodb carro = optionalCarro.orElseThrow();
            ProductoMongodb producto = optionalProducto.orElseThrow();

            CarroProductoMongodb cp = carro.findId(producto.getId());

            if(cp != null){
                if(cp.getCantidad() > 1){
                    cp.setCantidad(cp.getCantidad() - 1);
                }else{
                    carro.getProductos().remove(cp);
                }
            }
            return carroRepository.save(carro);
        }
        return optionalCarro.orElseThrow();
    }
    
}
