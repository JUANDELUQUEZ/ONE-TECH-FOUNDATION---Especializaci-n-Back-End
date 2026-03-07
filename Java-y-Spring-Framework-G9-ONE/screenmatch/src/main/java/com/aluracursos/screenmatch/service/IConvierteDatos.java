package com.aluracursos.screenmatch.service;

public interface IConvierteDatos {
    // El <T> significa que el método es genérico y puede devolver cualquier tipo de objeto
    <T> T obtenerDatos(String json, Class<T> clase);
    
}
