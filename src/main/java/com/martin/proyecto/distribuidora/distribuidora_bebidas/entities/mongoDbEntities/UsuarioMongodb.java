package com.martin.proyecto.distribuidora.distribuidora_bebidas.entities.mongoDbEntities;

import java.util.Date;

import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;

@Document(collection = "usuarios")
public class UsuarioMongodb {
    
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    @NotBlank(message = "No puede estar el mail vacio")
    private String mail;

    @NotBlank(message = "El username no puede estar vacio")
    private String username;

    @NotBlank(message = "El nombre no puede estar vacio")
    private String nombre;

    @NotBlank(message = "El apellido no puede estar vacio")
    private String apellido;

    @NotBlank(message = "La contraseña no puede estar vacia")
    private String password;

    private String rol;

    @DBRef
    private CarroMongodb carrito;

    private Date fechaCreacion;

    private boolean activo;

    public UsuarioMongodb (){
        fechaCreacion = new Date();
        activo = true;
    }

    public UsuarioMongodb (String mail, String username, String nombre, String apellido, String password){
        this.mail = mail;
        this.username = username;
        this.nombre = nombre;
        this.apellido = apellido;
        this.password = password;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

    public CarroMongodb getCarrito() {
        return carrito;
    }

    public void setCarrito(CarroMongodb carrito) {
        this.carrito = carrito;
    }

    public Date getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(Date fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public boolean isActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }

    @Override
    public String toString() {
        return "Usuario [id=" + id +", username=" + username +", nombre=" + nombre + ", apellido=" + apellido + ", password=" + password;
    }
    
}
