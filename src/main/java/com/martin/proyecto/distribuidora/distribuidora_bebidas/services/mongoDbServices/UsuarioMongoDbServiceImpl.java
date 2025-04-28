package com.martin.proyecto.distribuidora.distribuidora_bebidas.services.mongoDbServices;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.martin.proyecto.distribuidora.distribuidora_bebidas.entities.mongoDbEntities.CarroMongodb;
import com.martin.proyecto.distribuidora.distribuidora_bebidas.entities.mongoDbEntities.UsuarioMongodb;
import com.martin.proyecto.distribuidora.distribuidora_bebidas.repositories.mongoDbRepositories.CarroMongoDbRepository;
import com.martin.proyecto.distribuidora.distribuidora_bebidas.repositories.mongoDbRepositories.UsuarioMongoDbRepository;

import jakarta.transaction.Transactional;

@Service
public class UsuarioMongoDbServiceImpl implements UsuarioMongoDbService{

    private final PasswordEncoder passwordEncoder;

    @Autowired
    private UsuarioMongoDbRepository usuarioRepository;

    @Autowired
    private CarroMongoDbRepository carritoRepository;

    UsuarioMongoDbServiceImpl(PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }

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
    public UsuarioMongodb save(UsuarioMongodb usuario) {
        
        CarroMongodb carrito = carritoRepository.save(new CarroMongodb());
        usuario.setCarrito(carrito);

        usuario.setPassword(passwordEncoder.encode(usuario.getPassword()));
        usuario.setRol(usuario.getMail().contains("distribuidorasol")?"admin":"user");

        return usuarioRepository.save(usuario);
        
    }
    
    @Override
    public Optional<UsuarioMongodb> update(String id, UsuarioMongodb usuario) {
        Optional<UsuarioMongodb> optionalUsuario = usuarioRepository.findById(id);
        if(optionalUsuario.isPresent()){
            UsuarioMongodb u = optionalUsuario.orElseThrow();
            u.setUsername(usuario.getUsername());
            u.setNombre(usuario.getNombre());
            u.setApellido(usuario.getApellido());
            return Optional.of(usuarioRepository.save(u));
        }
        return optionalUsuario;
    }

    @Override
    public Optional<UsuarioMongodb> delete(String id) {
        return Optional.empty();
    }

}
