package com.martin.proyecto.distribuidora.distribuidora_bebidas.validation.usuarioValidation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

@Constraint(validatedBy = ExistByUsernameValidation.class)
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface ExistByUsername {

	String message() default "Ya existe el username en la base de datos";

	Class<?>[] groups() default { };

	Class<? extends Payload>[] payload() default { };

}

