package com.martin.proyecto.distribuidora.distribuidora_bebidas.entities.mongoDbEntities;

import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;

@Document(collection = "subcategorias_productos")
public class SubCategoriaProductoMongodb {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    @NotBlank(message = "El titulo no puede estar vacio")
    private String titulo;

    @NotBlank(message = "La descripcion no puede estar vacia")
    private String descripcion;

    private String imgSrc;

    @DBRef
    private ProductoMongodb productos;

    public SubCategoriaProductoMongodb(String titulo, String descripcion, String imgSrc) {
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.imgSrc = imgSrc;
    }

    public SubCategoriaProductoMongodb() {
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
}
