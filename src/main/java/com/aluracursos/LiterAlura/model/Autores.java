package com.aluracursos.LiterAlura.model;

import jakarta.persistence.*;

import java.util.List;

public class Autores {

    @Entity
    @Table(name = "autores")
    public class Autor {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;
        @Column(unique = true)
        private String nombre;
        private Integer nacimiento;
        private Integer fallecimiento;
        @OneToMany(mappedBy = "autor", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
        private List<Libros> libros;

        public Autor() {

        }
    }
}