package com.martin.proyecto.distribuidora.distribuidora_bebidas.validation.rolValidation;

import com.martin.proyecto.distribuidora.distribuidora_bebidas.services.UsuarioService;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class ExistByNombreValidation implements ConstraintValidator<ExistByNombre,String>{
    
    private UsuarioService service;

    public boolean isValid(String value, ConstraintValidatorContext context){
        return !service.existByRolNombre(value);
    } 

}
