package com.martin.proyecto.distribuidora.distribuidora_bebidas.entities.mongoDbEntities;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Document(collection = "carritos")
public class CarroMongodb {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    @DBRef
    private List<CarroProductoMongodb> productos;

    public CarroMongodb(){
        productos = new ArrayList<>();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public List<CarroProductoMongodb> getProductos() {
        return productos;
    }

    public void setProductos(List<CarroProductoMongodb> productos) {
        this.productos = productos;
    }


    public CarroProductoMongodb findId(String id){
        for(CarroProductoMongodb p : productos){
            if(p.getProducto().getId().equals(id)){
                return p;
            }
        }
        return null;
    }

}
