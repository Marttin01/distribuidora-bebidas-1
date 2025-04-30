package com.martin.proyecto.distribuidora.distribuidora_bebidas.entities.mongoDbEntities;

import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import com.martin.proyecto.distribuidora.distribuidora_bebidas.entities.Producto;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Document(collection = "carro_productos")
public class CarroProductoMongodb {
    
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    @DBRef
    private CarroMongodb carrito;

    @DBRef
    private ProductoMongodb producto;

    private Integer cantidad;

    public CarroProductoMongodb(){

    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public CarroMongodb getCarrito() {
        return carrito;
    }

    public void setCarrito(CarroMongodb carrito) {
        this.carrito = carrito;
    }

    public ProductoMongodb getProducto() {
        return producto;
    }

    public void setProducto(ProductoMongodb producto) {
        this.producto = producto;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }
    
}
