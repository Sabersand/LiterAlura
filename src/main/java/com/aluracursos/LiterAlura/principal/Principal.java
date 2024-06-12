package com.aluracursos.LiterAlura.principal;

import com.aluracursos.LiterAlura.service.ConsumoApi;

public class Principal {
    private ConsumoApi consumoApi = new ConsumoApi();
    private final String URL_BASE = "https://www.omdbapi.com/?t=";
    private final String API_KEY = "OMDB_API";
}
