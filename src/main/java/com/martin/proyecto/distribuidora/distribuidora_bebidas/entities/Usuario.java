package com.martin.proyecto.distribuidora.distribuidora_bebidas.entities;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.martin.proyecto.distribuidora.distribuidora_bebidas.validation.usuarioValidation.ExistByUsername;
import com.martin.proyecto.distribuidora.distribuidora_bebidas.validation.usuarioValidation.ExistsByMail;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;


@Entity
@Table(name = "usuarios")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    @ExistsByMail
    @NotBlank(message = "no puede estar vacio")
    @Email(message = "no tiene un formato valido")
    private String mail;

    @ExistByUsername
    @NotBlank(message = "No puede estar vacio")
    private String username;

    @NotBlank(message = "no puede estar vacio")
    private String nombre;

    @NotBlank(message = "no puede estar vacio")
    private String apellido;

    @NotBlank(message = "no puede estar vacia")
    @Size(min = 4)
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String password;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinTable(name = "usuarios_roles", joinColumns = @JoinColumn(name = "usuarios_id"), inverseJoinColumns = @JoinColumn(name = "roles_id"), uniqueConstraints = { @UniqueConstraint(columnNames = {"usuarios_id","roles_id"})})
    private Rol rol;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinTable(name = "usuarios_carritos", joinColumns = @JoinColumn(name = "usuarios_id"), inverseJoinColumns = @JoinColumn(name = "carritos_id"), uniqueConstraints = { @UniqueConstraint(columnNames = {"usuarios_id","carritos_id"})})
    private Carro carrito;

    @Column(name = "fecha_creacion")
    private Date fechaCreacion;

    private boolean activo = true;

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String role;

    public Usuario(){
        this.fechaCreacion = new Date();
    }

    public Usuario(String mail, String username, String nombre, String apellido, String password){
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

    public boolean isActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }

    public Date getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(Date fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public Rol getRol() {
        return rol;
    }

    public void setRol(Rol rol) {
        this.rol = rol;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public Carro getCarrito() {
        return carrito;
    }

    public void setCarrito(Carro carrito) {
        this.carrito = carrito;
    }

    @Override
    public String toString() {
        return "Usuario [id=" + id +", username=" + username +", nombre=" + nombre + ", apellido=" + apellido + ", password=" + password
                + ", activo=" + activo + "]";
    }

    
    
}
