package com.martin.proyecto.distribuidora.distribuidora_bebidas.repositories.mongoDbRepositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.martin.proyecto.distribuidora.distribuidora_bebidas.entities.mongoDbEntities.ProductoMongodb;



@Repository
public interface ProductoMongoDbRepository extends MongoRepository<ProductoMongodb,String>{

    
}