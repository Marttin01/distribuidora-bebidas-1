package com.martin.proyecto.distribuidora.distribuidora_bebidas.errors;

public class NotFoundProductException extends RuntimeException {
    public NotFoundProductException(String message){
        super(message);
    }
}
