package com.aluracursos.LiterAlura.service;

public interface IConvierteApi {
    <T> T obtenerDatos(String json, Class<T> clase);
}
