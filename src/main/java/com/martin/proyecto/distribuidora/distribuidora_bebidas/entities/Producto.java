package com.martin.proyecto.distribuidora.distribuidora_bebidas.entities;

import java.util.Date;
import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;

@Entity
@Table(name = "productos")
public class Producto {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    
    private String titulo;

    private String descripcion;

    private Long stock;

    private Long precio;

    @Column(name = "fecha_creacion")
    private Date fechaCreacion;

    private boolean activo;

    Producto (){
        this.fechaCreacion = new Date();
    }

    Producto(String titulo, String descripcion, Long stock, Long precio){
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.stock = stock;
        this.precio = precio;
    }

    @PrePersist
    private void ifStock(){
        if(this.stock == 0){
            this.activo = false;
        }else {
            this.activo = true;
        }
        ifId();
    }

    
    private void ifId(){
        if(this.id == null){
            this.id = UUID.randomUUID().toString();
            ifStock();
        }
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

    @Override
    public String toString() {
        return "Producto [id=" + id + ", titulo=" + titulo + ", descripcion=" + descripcion + ", stock=" + stock
                + ", precio=" + precio + "]";
    }

}
