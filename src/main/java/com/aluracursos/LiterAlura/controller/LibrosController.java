package com.aluracursos.LiterAlura.controller;

import com.aluracursos.LiterAlura.model.Libros;
import com.aluracursos.LiterAlura.service.LibrosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/libros")
public class LibrosController {

    @Autowired
    private LibrosService librosService;

    @GetMapping
    public List<Libros> getAllLibros() {
        return librosService.getAllLibros();
    }

    @GetMapping("/{id}")
    public Libros getLibroById(@PathVariable Long id) {
        return librosService.getLibroById(id);
    }

    @PostMapping
    public Libros createLibro(@RequestBody Libros libro) {
        return librosService.createLibro(libro);
    }

    @PutMapping("/{id}")
    public Libros updateLibro(@PathVariable Long id, @RequestBody Libros libro) {
        return librosService.updateLibro(id, libro);
    }

    @DeleteMapping("/{id}")
    public void deleteLibro(@PathVariable Long id) {
        librosService.deleteLibro(id);
    }
}
