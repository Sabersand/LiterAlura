package com.aluracursos.LiterAlura.repository;

import com.aluracursos.LiterAlura.model.Libros;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface LibrosRepository extends JpaRepository<Libros, Long> {

    Optional<Libros> findByTituloContainsIgnoreCase(String nombreLibro);

}
