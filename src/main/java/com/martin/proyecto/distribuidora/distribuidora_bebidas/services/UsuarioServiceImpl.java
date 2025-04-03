package com.martin.proyecto.distribuidora.distribuidora_bebidas.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.martin.proyecto.distribuidora.distribuidora_bebidas.entities.Carro;
import com.martin.proyecto.distribuidora.distribuidora_bebidas.entities.Rol;
import com.martin.proyecto.distribuidora.distribuidora_bebidas.entities.Usuario;
import com.martin.proyecto.distribuidora.distribuidora_bebidas.repositories.CarroRepository;
import com.martin.proyecto.distribuidora.distribuidora_bebidas.repositories.RolRepository;
import com.martin.proyecto.distribuidora.distribuidora_bebidas.repositories.UsuarioRepository;

import jakarta.transaction.Transactional;

@Service
public class UsuarioServiceImpl implements UsuarioService{

    @Autowired
    private UsuarioRepository repository;

    @Autowired
    private RolRepository rolRepository;
    
    @Autowired
    private CarroRepository carroRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Transactional
    @Override
    public List<Usuario> findAll() {
        return (List<Usuario>) repository.findAll();
    }

    @Transactional
    @Override
    public Optional<Usuario> findById(String id) {
        return repository.findById(id);
    }

    @Override
    public Usuario save(Usuario usuario) {

        Carro carrito = carroRepository.save(new Carro());
        usuario.setCarrito(carrito);

        if(usuario.getMail().contains("dbsoladmin.com")){
            Optional<Rol> optionalRol = rolRepository.findByNombre("admin");
            optionalRol.ifPresent(r -> {
                usuario.setRol(r);
                usuario.setRole(r.getNombre());
            });
        }else {
            Optional<Rol> optionalRol1 = rolRepository.findByNombre("usuario");
            optionalRol1.ifPresent(r -> {
                usuario.setRol(r);
                usuario.setRole(r.getNombre());
            });
        }
        
        usuario.setPassword(passwordEncoder.encode(usuario.getPassword()));
        return repository.save(usuario);
    }
        
    @Override
    public Optional<Usuario> update(String id, Usuario usuario) {
        Optional<Usuario> optionalUsuario = repository.findById(id);
        if(optionalUsuario.isPresent()){
            Usuario u = optionalUsuario.orElseThrow();
            u.setNombre(usuario.getNombre());
            u.setApellido(usuario.getApellido());
            return Optional.of(repository.save(u));
        }
        return optionalUsuario;
    }
            
    @Override
    public Optional<Usuario> delete(String id) {
        try {
            Optional<Usuario> optionalUsuario = repository.findById(id);
            optionalUsuario.ifPresent(u ->{
                repository.delete(u);
            });
            return optionalUsuario;    
        } catch (Exception e) {
            System.out.println(e);
            return null;
        }
    }

    @Override
    public boolean existsByMail(String mail) {
        return repository.existsByMail(mail);
    }

    @Override
    public boolean existsByUsername(String username) {
        return repository.existsByUsername(username);
    }

    public boolean existByRolNombre(string nombre) {
        return repository.existsByRolNombre(nombre);
    };

}
