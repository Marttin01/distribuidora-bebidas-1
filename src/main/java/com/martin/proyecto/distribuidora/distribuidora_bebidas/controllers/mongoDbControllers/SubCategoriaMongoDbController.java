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

import com.martin.proyecto.distribuidora.distribuidora_bebidas.entities.mongoDbEntities.SubCategoriaProductoMongodb;
import com.martin.proyecto.distribuidora.distribuidora_bebidas.services.mongoDbServices.SubCategoriaProductoMongoDbService;

@RestController
@RequestMapping("/apiM/subcategorias")
public class SubCategoriaMongoDbController {

    @Autowired
    private SubCategoriaProductoMongoDbService service;

    @GetMapping
    public ResponseEntity<List<SubCategoriaProductoMongodb>> findAll(){
        try {
            return ResponseEntity.ok(service.findAll());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build(); 
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<SubCategoriaProductoMongodb> findById(@PathVariable String id){
        try {
            Optional<SubCategoriaProductoMongodb> optionalSub = service.findById(id);
            if(!optionalSub.isEmpty()) return ResponseEntity.ok(optionalSub.orElseThrow());
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @PostMapping
    public ResponseEntity<SubCategoriaProductoMongodb> save(@RequestBody SubCategoriaProductoMongodb subcategoria){
        try {
            return ResponseEntity.ok(service.save(subcategoria));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<SubCategoriaProductoMongodb> update(@PathVariable String id, @RequestBody SubCategoriaProductoMongodb subcategoria){
        try {
            return ResponseEntity.ok(service.update(id, subcategoria));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<SubCategoriaProductoMongodb> delete(@PathVariable String id){
        try {
            return ResponseEntity.ok(service.delete(id));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @PutMapping("/{id}/{id2}")
    public ResponseEntity<SubCategoriaProductoMongodb> addProducto(@PathVariable String id, @PathVariable String id2){
        try {
            return ResponseEntity.ok(service.addProducto(id, id2));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @PutMapping("/{id}/{id2}")
    public ResponseEntity<SubCategoriaProductoMongodb> deleteProducto(@PathVariable String id, @PathVariable String id2){
        try {
            return ResponseEntity.ok(service.deleteProducto(id, id2));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

}
