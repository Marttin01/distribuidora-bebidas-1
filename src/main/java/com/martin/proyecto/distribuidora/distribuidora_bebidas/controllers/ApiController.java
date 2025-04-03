package com.martin.proyecto.distribuidora.distribuidora_bebidas.controllers;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class ApiController {

    @GetMapping()
    public ResponseEntity<?> welcome(){
        try {
            Map<Object,Object> respuesta = new HashMap<>();
            respuesta.put("Mensaje", "Bienveniddaso a la API REST distribuidora! ");
            return ResponseEntity.ok(respuesta);
        } catch (Exception e) {
            System.out.println(e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @PostMapping()
    public ResponseEntity<?> welcomePost(){
        return welcome();
    }

    @PutMapping
    public ResponseEntity<?> welcomePut(){
        return welcome();
    }

    @DeleteMapping()
    public ResponseEntity<?> welcomeDelete(){
        return welcome();
    }
    
    @GetMapping("/{path}")
    public ResponseEntity<?> welcomePathGet(){
        return welcome();
    }

    @PostMapping("/{path}")
    public ResponseEntity<?> welcomePathPost(){
        return welcome();
    }

    @PutMapping("/{path}")
    public ResponseEntity<?> welcomePathPut(){
        return welcome();
    }
    
    @DeleteMapping("/{path}")
    public ResponseEntity<?> welcomePathDelete(){
        return welcome();
    }

}
