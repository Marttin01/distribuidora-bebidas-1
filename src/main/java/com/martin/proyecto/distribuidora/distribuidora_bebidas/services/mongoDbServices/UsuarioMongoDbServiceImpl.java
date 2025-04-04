package com.martin.proyecto.distribuidora.distribuidora_bebidas.services.mongoDbServices;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.martin.proyecto.distribuidora.distribuidora_bebidas.entities.Usuario;
import com.martin.proyecto.distribuidora.distribuidora_bebidas.entities.mongoDbEntities.UsuarioMongodb;
import com.martin.proyecto.distribuidora.distribuidora_bebidas.repositories.mongoDbRepositories.UsuarioMongoDbRepository;

import jakarta.transaction.Transactional;

@Service
public class UsuarioMongoDbServiceImpl implements UsuarioMongoDbService{

    @Autowired
    private UsuarioMongoDbRepository usuarioRepository;

    @Transactional
    @Override
    public List<UsuarioMongodb> findAll() {
        return usuarioRepository.findAll();
    }

    @Transactional
    @Override
    public Optional<UsuarioMongodb> findById(String id) {
        return usuarioRepository.findById(id);
    }

    @Override
    public Usuario save(UsuarioMongodb usuario) {
        return null;
    }
    
    @Override
    public Optional<UsuarioMongodb> update(String id, UsuarioMongodb usuario) {
        return Optional.empty();
    }

    @Override
    public Optional<UsuarioMongodb> delete(String id) {
        return Optional.empty();
    }

}
