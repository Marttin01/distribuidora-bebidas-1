package com.martin.proyecto.distribuidora.distribuidora_bebidas.entities.mongoDbEntities;

import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Document(collection = "categorias_productos")
public class CategoriaProductoMongodb {
    
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    private String titulo;

    private String descripcion;

    private String imgSrc;

    @DBRef
    private ProductoMongodb productos;
    
    CategoriaProductoMongodb(){
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

    public String getImgSrc() {
        return imgSrc;
    }

    public void setImgSrc(String imgSrc) {
        this.imgSrc = imgSrc;
    }

    public ProductoMongodb getProductos() {
        return productos;
    }

    public void setProductos(ProductoMongodb productos) {
        this.productos = productos;
    }

}
