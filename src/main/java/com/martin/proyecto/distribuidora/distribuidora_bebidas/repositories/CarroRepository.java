package com.martin.proyecto.distribuidora.distribuidora_bebidas.repositories;


import org.springframework.context.annotation.Profile;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.martin.proyecto.distribuidora.distribuidora_bebidas.entities.Carro;

@Repository
@Profile("jpa")
public interface CarroRepository extends CrudRepository<Carro,String>{


}
