package com.martin.proyecto.distribuidora.distribuidora_bebidas.entities.mongoDbEntities;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "usuarios")
public class UsuarioMongodb {

    private String id;

    private String mail;

    private String username;

    private String nombre;

    private String apellido;

    private String password;

    public UsuarioMongodb (){

    }

    public UsuarioMongodb (String mail, String username, String nombre, String apellido, String password){
        this.mail = mail;
        this.username = username;
        this.nombre = nombre;
        this.apellido = apellido;
        this.password = password;
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

    @Override
    public String toString() {
        return "Usuario [id=" + id +", username=" + username +", nombre=" + nombre + ", apellido=" + apellido + ", password=" + password;
    }
    
}
