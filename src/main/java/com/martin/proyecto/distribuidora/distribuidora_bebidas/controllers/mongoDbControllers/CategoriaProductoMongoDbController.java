package com.martin.proyecto.distribuidora.distribuidora_bebidas.controllers.mongoDbControllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.martin.proyecto.distribuidora.distribuidora_bebidas.entities.mongoDbEntities.CategoriaProductoMongodb;
import com.martin.proyecto.distribuidora.distribuidora_bebidas.services.mongoDbServices.CategoriaProductoMongoDbService;


@RestController
@RequestMapping("/apiM/categoriasProductos")
public class CategoriaProductoMongoDbController {

    @Autowired
    private CategoriaProductoMongoDbService service;

    @GetMapping
    public ResponseEntity<List<CategoriaProductoMongodb>> findAll(){
        try {
            List<CategoriaProductoMongodb> categorias = service.findAll();
            return ResponseEntity.ok(categorias);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<CategoriaProductoMongodb> findById(@PathVariable String id){
        try {
            Optional<CategoriaProductoMongodb> categoriaProduOptional = service.findById(id);
            if(categoriaProduOptional.isPresent()){
                return ResponseEntity.ok(categoriaProduOptional.orElseThrow());
            } else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
            }
            
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @PostMapping
    public ResponseEntity<CategoriaProductoMongodb> save(@RequestBody CategoriaProductoMongodb categoriaProducto){
        try {
            CategoriaProductoMongodb savedCategoria = service.save(categoriaProducto);
            return ResponseEntity.status(HttpStatus.CREATED).body(savedCategoria);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<CategoriaProductoMongodb> update(@PathVariable String id, @RequestBody CategoriaProductoMongodb categoriaProducto) {
        try {
            Optional<CategoriaProductoMongodb> updatedCategoria = service.update(id, categoriaProducto);
            return ResponseEntity.status(HttpStatus.OK).body(updatedCategoria.orElseThrow());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<CategoriaProductoMongodb> delete(@PathVariable String id){
        try {
            Optional<CategoriaProductoMongodb> categoriaOptional = service.delete(id);
            if(categoriaOptional.isPresent()){
                return ResponseEntity.ok(categoriaOptional.orElseThrow());
            } else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
            }   
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

}
