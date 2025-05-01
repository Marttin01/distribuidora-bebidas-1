package com.martin.proyecto.distribuidora.distribuidora_bebidas.controllers.mongoDbControllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.martin.proyecto.distribuidora.distribuidora_bebidas.entities.mongoDbEntities.CarroMongodb;
import com.martin.proyecto.distribuidora.distribuidora_bebidas.services.mongoDbServices.CarroMongoDbService;

@RestController
@RequestMapping("/apiM/carritos")
public class CarroMongoDbController {
    
    @Autowired
    private CarroMongoDbService service;

    @GetMapping
    public ResponseEntity<List<CarroMongodb>> findAll(){
        try {
            List<CarroMongodb> carritos = service.findAll();
            return ResponseEntity.ok(carritos);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<CarroMongodb> findById(@PathVariable String id){
        try {
            Optional<CarroMongodb> optionalCarro = service.findById(id);
            if(optionalCarro.isPresent()){
                return ResponseEntity.ok(optionalCarro.orElseThrow());
            }else{
                return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<CarroMongodb> delete(@PathVariable String id){
        try {
            Optional<CarroMongodb> optionalCarro = service.delete(id);
            if(optionalCarro.isPresent()){
                return ResponseEntity.ok(optionalCarro.orElseThrow());
            }else return ResponseEntity.notFound().build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @PutMapping("/add/{id}/{id2}")
    public ResponseEntity<CarroMongodb> addProducto(@PathVariable String id, @PathVariable String id2){
        try {
            Optional<CarroMongodb> optionalCarro = Optional.of(service.addProducto(id, id2));
            if(optionalCarro.isPresent()){
                return ResponseEntity.ok(optionalCarro.orElseThrow());
            }
            return ResponseEntity.notFound().build();
        } catch (Exception e) {
            System.out.println(e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @PutMapping("/remove/{id}/{id2}")
    public ResponseEntity<CarroMongodb> removeProducto(@PathVariable String id, @PathVariable String id2){
        try {
            Optional<CarroMongodb> optionalCarro = Optional.of(service.deleteProducto(id, id2));
            if(optionalCarro.isPresent()){
                return ResponseEntity.ok(optionalCarro.orElseThrow());
            }
            return ResponseEntity.notFound().build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }   
    }


    
}
