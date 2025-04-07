package com.martin.proyecto.distribuidora.distribuidora_bebidas.entities.mongoDbEntities;

import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Document(collection = "carro_productos")
public class CarroProductoMongodb {
    
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    @DBRef
    private String carritoId;

    @DBRef
    private String productoId;

    private Integer cantidad;

    public CarroProductoMongodb(){

    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCarritoId() {
        return carritoId;
    }

    public void setCarritoId(String carritoId) {
        this.carritoId = carritoId;
    }

    public String getProductoId() {
        return productoId;
    }

    public void setProductoId(String productoId) {
        this.productoId = productoId;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }
    
}
