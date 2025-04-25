package com.martin.proyecto.distribuidora.distribuidora_bebidas.services;

import java.util.List;
import java.util.Optional;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import com.martin.proyecto.distribuidora.distribuidora_bebidas.entities.Carro;

@Service
@Profile("jpa")
public interface CarroService {

    List<Carro> findAll();

    Optional<Carro> findById(String id);

    Carro save(Carro carro);

    Optional<Carro> delete (String id);

    Carro addProducto (String id, String id2);

    Carro deleteProducto (String id, String id2);

}
