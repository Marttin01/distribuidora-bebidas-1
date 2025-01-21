package com.martin.proyecto.distribuidora.distribuidora_bebidas.entities;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "carritos_productos")
public class CarroProducto {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "carritos_id")
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private Carro carro;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "productos_id")
    private Producto producto;

    private Integer cantidad;

    public CarroProducto(){
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    public Carro getCarro() {
        return carro;
    }

    public void setCarro(Carro carro) {
        this.carro = carro;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

}
