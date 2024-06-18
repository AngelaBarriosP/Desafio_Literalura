package com.aluracursos.buscalibros.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import jakarta.persistence.*;

@Entity
@Table(name = "autores")
public class Autor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;
    @Column(unique = true)
    private String nombre;
    private int añoNacimiento;
    private int añoFallecimiento;
    @OneToOne
    @JoinColumn(name = "libros_autoId")
    private Libro libro;

    public Autor(){}

    public Autor (DatosAutor autor){
        this.nombre = autor.nombre();
        this.añoNacimiento = autor.añoNacimiento();
        this.añoFallecimiento = autor.añoFallecimiento();
    }

    @Override
    public String toString() {
        return "\nAutor: " + nombre + "\n" +
                "Fecha de nacimiento: " + añoNacimiento + "\n" +
                "Fecha de fallecimiento: " + añoFallecimiento + "\n" +
                "Libro: " + libro.getTitulo()
                ;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getAñoNacimiento() {
        return añoNacimiento;
    }

    public void setAñoNacimiento(int añoNacimiento) {
        this.añoNacimiento = añoNacimiento;
    }

    public int getAñoFallecimiento() {
        return añoFallecimiento;
    }

    public void setAñoFallecimiento(int añoFallecimiento) {
        this.añoFallecimiento = añoFallecimiento;
    }

    public Libro getLibro() {
        return libro;
    }

    public void setLibro(Libro libro) {
        this.libro = libro;
    }

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }
}
