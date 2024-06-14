package com.aluracursos.LiterAlura.model;
import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public record DatosLibros(
        @JsonAlias("Title")String titulo,
        @JsonAlias("Authors") List<String> autores,
        @JsonAlias("Languages")List<Idiomas> idiomas,
        @JsonAlias("Download_count")Integer descargas) {
}
