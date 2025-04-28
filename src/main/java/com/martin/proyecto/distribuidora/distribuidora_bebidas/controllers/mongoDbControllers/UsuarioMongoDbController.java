package com.martin.proyecto.distribuidora.distribuidora_bebidas.controllers.mongoDbControllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.martin.proyecto.distribuidora.distribuidora_bebidas.entities.mongoDbEntities.UsuarioMongodb;
import com.martin.proyecto.distribuidora.distribuidora_bebidas.services.mongoDbServices.UsuarioMongoDbService;

@RestController
@RequestMapping("/apiM/usuarios")
public class UsuarioMongoDbController {
    
    @Autowired
    private UsuarioMongoDbService service;

    @GetMapping
    public ResponseEntity<List<UsuarioMongodb>> findAll(){
        try {
            List<UsuarioMongodb> usuarios = service.findAll();
            return ResponseEntity.ok(usuarios);
        } catch (Exception e) {
            System.out.println(e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<UsuarioMongodb> findById(@PathVariable String id){
        try {
            Optional<UsuarioMongodb> optionalUsuario = service.findById(id);
            if(optionalUsuario.isPresent()){
                return ResponseEntity.ok(optionalUsuario.orElseThrow());
            }else{
                return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
            }
        } catch (Exception e) {
            System.out.println(e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @PostMapping("/register")
    public ResponseEntity<?> save(@RequestBody UsuarioMongodb usuario ){
        return ResponseEntity.status(HttpStatus.CREATED).body(service.save(usuario));
    }

    @PutMapping("/{id}")
    public ResponseEntity<UsuarioMongodb> update(@RequestBody UsuarioMongodb usuario, @PathVariable String id){
        try {
            Optional<UsuarioMongodb> optionalUsuario = service.update(id, usuario);
            if(optionalUsuario.isPresent()){
                return ResponseEntity.status(HttpStatus.CREATED).body(optionalUsuario.orElseThrow());
            }else return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    } 

}
