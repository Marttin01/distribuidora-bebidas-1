package com.martin.proyecto.distribuidora.distribuidora_bebidas.services.mongoDbServices;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.martin.proyecto.distribuidora.distribuidora_bebidas.entities.mongoDbEntities.SubCategoriaProductoMongodb;

@Service
public interface SubCategoriaProductoMongoDbService {

    List<SubCategoriaProductoMongodb> findAll();

    Optional<SubCategoriaProductoMongodb> findById(String id);

    SubCategoriaProductoMongodb save(SubCategoriaProductoMongodb subcategoria);    

}
