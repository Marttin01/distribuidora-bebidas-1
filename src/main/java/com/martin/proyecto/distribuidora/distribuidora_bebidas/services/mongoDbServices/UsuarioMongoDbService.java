package com.martin.proyecto.distribuidora.distribuidora_bebidas.services.mongoDbServices;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.martin.proyecto.distribuidora.distribuidora_bebidas.entities.Usuario;
import com.martin.proyecto.distribuidora.distribuidora_bebidas.entities.mongoDbEntities.UsuarioMongodb;

@Service
public interface UsuarioMongoDbService {
    
    List<UsuarioMongodb> findAll();

    Optional<UsuarioMongodb> findById(String id);
    
    Usuario save(UsuarioMongodb usuario);

    Optional<UsuarioMongodb> update(String id, UsuarioMongodb usuario);

    Optional<UsuarioMongodb> delete(String id);

}
