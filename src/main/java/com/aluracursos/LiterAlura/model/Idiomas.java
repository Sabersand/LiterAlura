package com.aluracursos.LiterAlura.model;


public enum Idiomas {
    ACCION("Action", "Acción"),
    ROMANCE("Romance", "Romance"),
    COMEDIA("Comedy", "Comedia"),
    DRAMA("Drama", "Drama"),
    CRIMEN("Crime", "Crimen");

    private String categoriaOmdb;
    private String categoriaEspanol;
    Idiomas (String categoriaOmdb, String categoriaEspanol){
        this.categoriaOmdb = categoriaOmdb;
        this.categoriaEspanol = categoriaEspanol;
    }

    public static Idiomas fromString(String text) {
        for (Idiomas idiomas : Idiomas.values()) {
            if (idiomas.categoriaOmdb.equalsIgnoreCase(text)) {
                return idiomas;
            }
        }
        throw new IllegalArgumentException("Ninguna categoria encontrada: " + text);
    }

    public static Idiomas fromEspanol(String text) {
        for (Idiomas idiomas : Idiomas.values()) {
            if (idiomas.categoriaEspanol.equalsIgnoreCase(text)) {
                return idiomas;
            }
        }
        throw new IllegalArgumentException("Ninguna categoria encontrada: " + text);
    }

}
