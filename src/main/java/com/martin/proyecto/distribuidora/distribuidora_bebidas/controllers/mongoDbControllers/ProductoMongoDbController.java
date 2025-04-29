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

import com.martin.proyecto.distribuidora.distribuidora_bebidas.entities.mongoDbEntities.ProductoMongodb;
import com.martin.proyecto.distribuidora.distribuidora_bebidas.services.mongoDbServices.ProductoMongoDbService;

@RestController
@RequestMapping("/apiM/productos")
public class ProductoMongoDbController {

    @Autowired
    private ProductoMongoDbService service;

    @GetMapping
    public ResponseEntity<List<ProductoMongodb>> findAll(){
        try {
            List<ProductoMongodb> productos = service.findAll();
            return ResponseEntity.ok(productos);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductoMongodb> findById(@PathVariable String id){
        try {
            Optional<ProductoMongodb> optionalProducto = service.findById(id);
            if(optionalProducto.isPresent()){
                return ResponseEntity.ok(optionalProducto.orElseThrow());
            }else{
                return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @PostMapping
    public ResponseEntity<ProductoMongodb> save(@RequestBody ProductoMongodb producto){
        return ResponseEntity.status(HttpStatus.CREATED).body(service.save(producto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProductoMongodb> update(@PathVariable String id, @RequestBody ProductoMongodb producto){
        Optional<ProductoMongodb> optionalProducto = service.update(id, producto);

        return ResponseEntity.status(HttpStatus.OK).body(optionalProducto.orElseThrow());
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<ProductoMongodb> delete(@PathVariable String id){
        Optional<ProductoMongodb> optionalProducto = service.delete(id);

        return ResponseEntity.ok(optionalProducto.orElseThrow());
    }
}
