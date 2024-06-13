package com.aluracursos.LiterAlura.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import jakarta.persistence.*;
import jdk.jfr.Category;

import java.util.List;

@Entity
public class Libros {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long Id;
    @Column(unique = true)
    private String titulo;
    private String autor;
    @Enumerated(EnumType.STRING)
    private Idiomas idiomas;
    private Integer descargas;
    @OneToOne(mappedBy = "libros", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Autores> autores;


    public Libros(){}

    public Libros(DatosLibros datosLibros){
        this.titulo = datosLibros.titulo();
        this.autor = datosLibros.autores();
        this.idiomas = Idiomas.fromString(datosLibros.idiomas().split(",")[0].trim());
        this.descargas = datosLibros.descargas();
    }

//Getters & Setters


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

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public Idiomas getIdiomas() {
        return idiomas;
    }

    public void setIdiomas(Idiomas idiomas) {
        this.idiomas = idiomas;
    }

    public Integer getDescargas() {
        return descargas;
    }

    public void setDescargas(Integer descargas) {
        this.descargas = descargas;
    }

    public List<Autores> getAutores() {
        return autores;
    }

    public void setAutores(List<Autores> autores) {
        this.autores = autores;
    }
}




