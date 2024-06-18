package com.aluracursos.buscalibros.service;

public interface IConvierteDatos {

    <T> T obtenerDatos (String json, Class<T> clase);
}
