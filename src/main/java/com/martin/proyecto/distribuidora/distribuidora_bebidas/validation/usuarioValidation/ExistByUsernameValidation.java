package com.martin.proyecto.distribuidora.distribuidora_bebidas.validation;

import com.martin.proyecto.distribuidora.distribuidora_bebidas.services.UsuarioService;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class ExistByUsernameValidation implements ConstraintValidator<ExistByUsername, String> {

    private UsuarioService service;

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        return !service.existsByUsername(value);
    }

}
