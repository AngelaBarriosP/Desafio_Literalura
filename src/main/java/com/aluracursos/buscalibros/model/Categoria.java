package com.aluracursos.buscalibros.model;

public enum Categoria {
    INGLES ("en"),
    ESPANOL ("es"),
    FRANCES ("fr"),
    PORTUGUES ("pt");

    private String categoriaGutendex;

    Categoria (String categoriaGutendex){
        this.categoriaGutendex = categoriaGutendex;
    }

    public static Categoria fromString(String text) {
        for (Categoria categoria : Categoria.values()) {
            if (categoria.categoriaGutendex.equalsIgnoreCase(text)) {
                return categoria;
            }
        }
        throw new IllegalArgumentException("Ninguna categoria encontrada: " + text);
    }
}
