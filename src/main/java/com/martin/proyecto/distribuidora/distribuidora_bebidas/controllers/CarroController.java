package com.martin.proyecto.distribuidora.distribuidora_bebidas.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.martin.proyecto.distribuidora.distribuidora_bebidas.entities.Carro;
import com.martin.proyecto.distribuidora.distribuidora_bebidas.services.CarroService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/carritos")
public class CarroController {

    @Autowired
    private CarroService service;

    @GetMapping
    public ResponseEntity<List<Carro>> findAll(){
        try {
            List<Carro> carritos = service.findAll();
            return ResponseEntity.ok(carritos);
        } catch (Exception e) {
            System.out.println(e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<Carro> findById(@PathVariable String id){
        try {
            Optional<Carro> optionalCarro = service.findById(id);
            if(optionalCarro.isPresent()){
                return ResponseEntity.ok(optionalCarro.get());
            }else{
                return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Carro> delete(@PathVariable String id){
        try {
            Optional<Carro> optionalCarro = service.delete(id);
            if(optionalCarro.isPresent()){
                return ResponseEntity.ok(optionalCarro.orElseThrow());
            }
            return ResponseEntity.notFound().build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @PutMapping("/add/{id}/{id2}")
    public ResponseEntity<Carro> addProducto(@PathVariable String id, @PathVariable String id2){
        try {
            Optional<Carro> optionalCarro = Optional.of(service.addProducto(id, id2));
            if(optionalCarro.isPresent()){
                return ResponseEntity.ok(optionalCarro.orElseThrow());
            }else{
                return ResponseEntity.notFound().build();
            }
        } catch (Exception e) {
            System.out.println(e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
    
    @PutMapping("/remove/{id}/{id2}")
    public ResponseEntity<Carro> removeProducto(@PathVariable String id, @PathVariable String id2){
        try {
            Optional<Carro> optionalCarro = Optional.of(service.deleteProducto(id, id2));
            if(optionalCarro.isPresent()){
                return ResponseEntity.ok(optionalCarro.orElseThrow());
            }else{
                return ResponseEntity.notFound().build();
            }
        } catch (Exception e) {
            System.out.println(e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
}
