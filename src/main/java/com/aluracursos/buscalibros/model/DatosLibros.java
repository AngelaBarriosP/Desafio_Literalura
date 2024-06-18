package com.aluracursos.buscalibros.model;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record DatosLibros(
        @JsonAlias("id")
        Long Id,
        @JsonAlias("title")
        String titulo,
        @JsonAlias("authors")
        List<DatosAutor> autores,
        @JsonAlias("languages")
        ArrayList<String> idiomas,
        @JsonAlias("download_count")
        int cantidadDescargas
) {
}
