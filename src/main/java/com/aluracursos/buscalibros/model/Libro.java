package com.aluracursos.buscalibros.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import jakarta.persistence.*;

import java.util.List;
@Entity
@Table(name = "libros")
public class Libro {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long autoID;
    private Long Id;
    @Column(unique = true)
    private String titulo;
    private int cantidadDescargas;
    @Enumerated(EnumType.STRING)
    private Categoria idioma;
    @OneToOne(mappedBy = "libro", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Autor autor;


    public Libro(){}

    public Libro(DatosLibros libros){
        this.Id = libros.Id();
        this.titulo = libros.titulo();
        this.idioma = Categoria.fromString(libros.idiomas().get(0).trim());
        this.cantidadDescargas = libros.cantidadDescargas();

    }

    public Long getId() {
        return Id;
    }

    public void setId(Long Id) {
        this.Id = Id;
    }

    public Categoria getIdioma() {
        return idioma;
    }

    public void setIdioma(Categoria idioma) {
        this.idioma = idioma;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Long getAutoID() {
        return autoID;
    }

    public void setAutoID(Long autoID) {
        this.autoID = autoID;
    }

    public Autor getAutor() {
        return autor;
    }

    public void setAutor(Autor autor) {
        this.autor = autor;
    }

    public int getCantidadDescargas() {
        return cantidadDescargas;
    }

    public void setCantidadDescargas(int cantidadDescargas) {
        this.cantidadDescargas = cantidadDescargas;
    }

    @Override
    public String toString() {
        return "\n----- LIBRO -----" + "\n" +
                "Titulo: " + titulo + "\n" +
                "Autor: " + autor.getNombre() + "\n" +
                "Idioma: " + idioma + "\n" +
                "Cantidad de descargas: " + cantidadDescargas + "\n" +
                "-----------------\n"
                ;
    }
}
