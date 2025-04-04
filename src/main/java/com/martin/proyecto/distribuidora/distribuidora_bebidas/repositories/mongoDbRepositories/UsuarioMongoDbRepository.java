package com.martin.proyecto.distribuidora.distribuidora_bebidas.repositories.mongoDbRepositories;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.martin.proyecto.distribuidora.distribuidora_bebidas.entities.mongoDbEntities.UsuarioMongodb;

@Repository
public interface UsuarioMongoDbRepository extends MongoRepository<UsuarioMongodb,String>{

    Optional<UsuarioMongodb> findByMail(String mail);

    Optional<UsuarioMongodb> findByUsername(String username);

    
}
