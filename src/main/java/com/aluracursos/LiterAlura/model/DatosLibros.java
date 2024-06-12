package com.aluracursos.LiterAlura.model;
import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record DatosLibros(
        @JsonAlias("Title")String titulo,
        @JsonAlias("Authors")String autores,
        @JsonAlias("Languages")String idiomas,
        @JsonAlias("Download_count")Integer descargas) {
}
