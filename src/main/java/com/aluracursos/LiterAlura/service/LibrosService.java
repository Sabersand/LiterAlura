package com.aluracursos.LiterAlura.service;

import com.aluracursos.LiterAlura.model.Libros;
import com.aluracursos.LiterAlura.repository.LibrosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LibrosService {

    @Autowired
    private static LibrosRepository librosRepository;

    public List<Libros> getAllLibros() {
        return librosRepository.findAll();
    }

    public Libros getLibroById(Long id) {
        Optional<Libros> libro = librosRepository.findById(id);
        return libro.orElse(null);
    }

    public static Libros createLibro(Libros libro) {
        return librosRepository.save(libro);
    }

    public Libros updateLibro(Long id, Libros libro) {
        if (librosRepository.existsById(id)) {
            libro.setId(id);
            return librosRepository.save(libro);
        }
        return null;
    }

    public void deleteLibro(Long id) {
        if (librosRepository.existsById(id)) {
            librosRepository.deleteById(id);
        }
    }
}
