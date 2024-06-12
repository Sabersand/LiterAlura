package com.aluracursos.LiterAlura.dto;

import com.fasterxml.jackson.annotation.JsonAlias;

public record LibrosDTO (Long id,
                         String titulo,
                         String autores,
                         String idiomas,
                         Integer descargas) {
}
