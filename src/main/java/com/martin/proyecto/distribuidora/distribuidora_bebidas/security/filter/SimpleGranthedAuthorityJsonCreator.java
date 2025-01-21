package com.martin.proyecto.distribuidora.distribuidora_bebidas.security.filter;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public abstract class SimpleGranthedAuthorityJsonCreator {

    @JsonCreator
    public SimpleGranthedAuthorityJsonCreator(@JsonProperty("authority") String rol){
    }

}
