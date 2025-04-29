package com.martin.proyecto.distribuidora.distribuidora_bebidas.entities.mongoDbEntities;

import java.util.Date;

import org.springframework.data.mongodb.core.mapping.Document;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.validation.constraints.NotBlank;

@Document(collection = "productos")
public class ProductoMongodb {
    
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    @NotBlank(message = "El titulo no puede estar vacio")
    private String titulo;

    private String descripcion;

    @NotBlank(message =  "El stock no puede estar vacio")
    private Long stock;

    @NotBlank(message = "El precio no puede estar vacio")
    private Long precio;

    private Date fechaCreacion;

    private boolean activo;

    public ProductoMongodb(){
        this.fechaCreacion = new Date();
    }

    public ProductoMongodb(String titulo, String descripcion, Long stock, Long precio){
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.stock = stock;
        this.precio = precio;
    }

    @PrePersist
    private void ifStock(){
        if(this.stock == 0){
            this.activo = false;
        }else this.activo = true;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Long getStock() {
        return stock;
    }

    public void setStock(Long stock) {
        this.stock = stock;
    }

    public Long getPrecio() {
        return precio;
    }

    public void setPrecio(Long precio) {
        this.precio = precio;
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

    public String toString() {
        return "Producto [id=" + id +", titulo=" + titulo +", descripcion=" + descripcion + ", stock=" + stock + ", precio=" + precio;
    };

}
