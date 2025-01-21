package com.martin.proyecto.distribuidora.distribuidora_bebidas.services;

import java.util.List;
import java.util.Optional;


import com.martin.proyecto.distribuidora.distribuidora_bebidas.entities.Carro;

public interface CarroService {

    List<Carro> findAll();

    Optional<Carro> findById(String id);

    Carro save(Carro carro);

    Optional<Carro> delete (String id);

    Carro addProducto (String id, String id2);

    Carro deleteProducto (String id, String id2);

}
