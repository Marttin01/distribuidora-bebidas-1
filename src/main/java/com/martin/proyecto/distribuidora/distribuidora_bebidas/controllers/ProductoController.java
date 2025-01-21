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
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.martin.proyecto.distribuidora.distribuidora_bebidas.entities.Producto;
import com.martin.proyecto.distribuidora.distribuidora_bebidas.errors.NotUpdateRequestException;
import com.martin.proyecto.distribuidora.distribuidora_bebidas.services.ProductoService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/productos")
public class ProductoController {

    @Autowired(required = true)
    private ProductoService service;

    @GetMapping
    public ResponseEntity<List<Producto>> findAll(){
            List<Producto> productos = service.findAll();
            return ResponseEntity.ok(productos);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable String id){
            Optional<Producto> optionalProducto = service.findById(id);
            return ResponseEntity.ok(optionalProducto.get());
    }

    @PostMapping
    public ResponseEntity<?> save(@RequestBody Producto producto ){
            return ResponseEntity.status(HttpStatus.CREATED).body(service.save(producto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Producto> update (@RequestBody Producto producto, @PathVariable String id) throws NotUpdateRequestException{
        Optional<Producto> optionalProducto = service.update(id, producto);
            
        return ResponseEntity.status(HttpStatus.CREATED).body(optionalProducto.orElseThrow());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Producto> delete(@PathVariable String id){
        Optional<Producto> optionalProducto = service.delete(id);
        
        return ResponseEntity.ok(optionalProducto.orElseThrow());
    }

}
