package com.martin.proyecto.distribuidora.distribuidora_bebidas.controllers.exceptions;

import java.util.Date;
import java.util.NoSuchElementException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.martin.proyecto.distribuidora.distribuidora_bebidas.errors.NotFoundProductException;
import com.martin.proyecto.distribuidora.distribuidora_bebidas.errors.NotRequestBodyException;
import com.martin.proyecto.distribuidora.distribuidora_bebidas.errors.NotUpdateRequestException;
import com.martin.proyecto.distribuidora.distribuidora_bebidas.entities.Error;

@RestControllerAdvice
public class ProductosHandlerExceptionController {

    @ExceptionHandler({NotFoundProductException.class, NoSuchElementException.class})
    public ResponseEntity<?> notFoundProduct(Exception e){
        Error error = new Error("El producto no pudo ser encontrado: ", "Producto no encontrado",HttpStatus.NOT_FOUND.value(), new Date());
        
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
    }

    @ExceptionHandler({NotRequestBodyException.class,HttpMessageNotReadableException.class})
    public ResponseEntity<?> notRequestBody(Exception e){
        Error error = new Error("La peticion esta vacia o es incorrecta", "No hay cuerpo en la peticion !", HttpStatus.BAD_REQUEST.value(), new Date());

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
    }

    @ExceptionHandler({NullPointerException.class})
    public ResponseEntity<?> nullPointer(Exception e){
        Error error = new Error("Peticion incorrecta con algun valor null!", "Algun atributo es null", HttpStatus.BAD_REQUEST.value(), new Date());

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
    }

    @ExceptionHandler({NotUpdateRequestException.class})
    public ResponseEntity<?> updateException(){
        Error error = new Error("Petión update vacia o con información incorrecta!", "Mal contenido de la peticion",HttpStatus.BAD_REQUEST.value(), new Date());

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
    }
}
