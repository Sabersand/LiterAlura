package com.aluracursos.LiterAlura.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Libros {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long Id;
    private String titulo;
    private String autores;
    private String idiomas;
    private Integer descargas;

    public Libros(){}

    public Libros(DatosLibros datosLibros){
        this.titulo = datosLibros.titulo();
        this.autores = datosLibros.autores();
        this.idiomas = datosLibros.idiomas();
        this.descargas = datosLibros.descargas();
    }




    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutores() {
        return autores;
    }

    public void setAutores(String autores) {
        this.autores = autores;
    }

    public String getIdiomas() {
        return idiomas;
    }

    public void setIdiomas(String idiomas) {
        this.idiomas = idiomas;
    }

    public Integer getDescargas() {
        return descargas;
    }

    public void setDescargas(Integer descargas) {
        this.descargas = descargas;
    }
}




