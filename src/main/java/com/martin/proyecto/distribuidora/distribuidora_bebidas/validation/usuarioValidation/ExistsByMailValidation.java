package com.martin.proyecto.distribuidora.distribuidora_bebidas.validation;


import org.springframework.beans.factory.annotation.Autowired;

import com.martin.proyecto.distribuidora.distribuidora_bebidas.services.UsuarioService;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class ExistsByMailValidation implements ConstraintValidator<ExistsByMail,String>{

    @Autowired
    private UsuarioService service;

    @Override
    public boolean isValid(String mail, ConstraintValidatorContext context) {
        if(service == null)return true;
        return !service.existsByMail(mail);
    }

}
