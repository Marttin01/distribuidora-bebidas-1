package com.martin.proyecto.distribuidora.distribuidora_bebidas.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.martin.proyecto.distribuidora.distribuidora_bebidas.entities.Carro;
import com.martin.proyecto.distribuidora.distribuidora_bebidas.entities.CarroProducto;
import com.martin.proyecto.distribuidora.distribuidora_bebidas.entities.Producto;
import com.martin.proyecto.distribuidora.distribuidora_bebidas.repositories.CarroRepository;
import com.martin.proyecto.distribuidora.distribuidora_bebidas.repositories.ProductoRepository;

@Service
public class CarroServiceImpl implements CarroService{

    @Autowired
    private CarroRepository repository;

    @Autowired
    private ProductoRepository productoRepository;
    
    @Transactional(readOnly = true)
    @Override
    public List<Carro> findAll() {
        return (List<Carro>) repository.findAll();
    }
    
    @Transactional(readOnly = true)
    @Override
    public Optional<Carro> findById(String id) {
        return repository.findById(id);
    }

    @Transactional
    @Override
    public Carro save(Carro carro) {
        return repository.save(carro);
    }

    @Transactional
    @Override
    public Optional<Carro> delete(String id) {
        return null;
    }

    @Transactional
    @Override
    public Carro addProducto(String id, String id2) {
        Optional<Carro> optionalCarro = repository.findById(id);
        Optional<Producto> optionalProducto = productoRepository.findById(id2);

        if(optionalCarro.isPresent() && optionalProducto.isPresent()){
            Carro c = optionalCarro.orElseThrow();
            Producto p = optionalProducto.orElseThrow();
            CarroProducto cp = c.findId(p.getId());
            CarroProducto cp2 = new CarroProducto();
            
            if(cp != null){
                cp.setCantidad(cp.getCantidad() + 1);
            }else{
                cp2.setCarro(c);
                cp2.setProducto(p);
                cp2.setCantidad(1);

                c.getProductos().add(cp2);
            }
            return repository.save(c);
        }
        return optionalCarro.orElseThrow();
    }
    
    @Transactional
    @Override
    public Carro deleteProducto(String id, String id2) {
        Optional<Carro> optionalCarro = repository.findById(id);
        Optional<Producto> optionalProducto = productoRepository.findById(id2);

        if(optionalCarro.isPresent() && optionalProducto.isPresent()){
            Carro c = optionalCarro.orElseThrow();
            Producto p = optionalProducto.orElseThrow();
            CarroProducto cp = c.findId(p.getId());

            if(cp != null){
                if(cp.getCantidad() > 1){
                    cp.setCantidad(cp.getCantidad() - 1);
                }else{
                    c.getProductos().remove(cp);
                    System.out.println("Se ha eliminado el producto: " +cp.getProducto().getTitulo());
                }
            }else{
                throw new Error();
            }
            return repository.save(c);
        }
        return optionalCarro.orElseThrow();
    }

}
