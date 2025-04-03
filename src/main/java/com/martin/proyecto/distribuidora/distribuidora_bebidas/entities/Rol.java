package com.martin.proyecto.distribuidora.distribuidora_bebidas.entities;

import com.martin.proyecto.distribuidora.distribuidora_bebidas.validation.rolValidation.ExistByNombre;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;


@Entity
@Table(name = "roles")
public class Rol {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotBlank(message = "No puede estar vacion el nombre del rol")
    @Size(min = 2)
    @ExistByNombre
    private String nombre;

    @NotBlank(message = "No puede estar vacia la descripcion del rol")
    private String descripcion;
    
    public Rol(){}

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @Override
    public String toString() {
        return "Rol [id=" + id + ", nombre=" + nombre + ", descripcion=" + descripcion + "]";
    }
    
}
