package com.aluracursos.buscalibros.repositorio;

import com.aluracursos.buscalibros.model.Autor;
import com.aluracursos.buscalibros.model.Categoria;
import com.aluracursos.buscalibros.model.Libro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface LibroRepository extends JpaRepository<Libro, Long> {
    @Query("SELECT a FROM Libro l JOIN l.autor a")
    List<Autor> mostrarTodosLosAutores();

    @Query("SELECT a FROM Autor a WHERE a.añoNacimiento <= :ano AND a.añoFallecimiento >= :ano")
    List<Autor> autoresVivosEnFecha(int ano);

    @Query("SELECT l FROM Libro l WHERE l.idioma = :idioma")
    List<Libro> librosPorIdioma(Categoria idioma);
}
