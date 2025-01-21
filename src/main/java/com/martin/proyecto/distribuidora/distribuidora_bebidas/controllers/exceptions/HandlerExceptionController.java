package com.martin.proyecto.distribuidora.distribuidora_bebidas.controllers.exceptions;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.client.HttpClientErrorException.Forbidden;

import com.martin.proyecto.distribuidora.distribuidora_bebidas.entities.Error;

@RestControllerAdvice
public class HandlerExceptionController {

    @ExceptionHandler(ArithmeticException.class)
    public ResponseEntity<?> divisionByZero(Exception e){
        Error error = new Error(e.getMessage(), "Error division por cero",HttpStatus.INTERNAL_SERVER_ERROR.value(), new Date());   
             
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(error);
    }

    @ExceptionHandler(Forbidden.class)
    public ResponseEntity<?> pathNotFound(Exception e){
        Error error = new Error(e.getMessage(), "Error ruta no encontrada",HttpStatus.NOT_FOUND.value(), new Date());

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
    }


