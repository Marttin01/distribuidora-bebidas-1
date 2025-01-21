package com.martin.proyecto.distribuidora.distribuidora_bebidas.entities;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "carritos")
public class Carro {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "carro", orphanRemoval = true)
    private List<CarroProducto> productos;

    public Carro(){
        productos = new ArrayList <>();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public List<CarroProducto> getProductos() {
        return productos;
    }

    public void setProductos(List<CarroProducto> productos) {
        this.productos = productos;
    }

    public CarroProducto findId(String id){
        for(CarroProducto p : productos){
            if(p.getProducto().getId().equals(id)){
                return p;
            }
        }
        return null;
    }

}
