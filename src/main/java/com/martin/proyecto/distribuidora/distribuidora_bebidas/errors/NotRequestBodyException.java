package com.martin.proyecto.distribuidora.distribuidora_bebidas.errors;

public class NotRequestBodyException extends RuntimeException{
    public NotRequestBodyException(String message){
        super(message);
    }
}
