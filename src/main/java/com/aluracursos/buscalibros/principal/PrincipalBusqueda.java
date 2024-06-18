package com.aluracursos.buscalibros.principal;

import com.aluracursos.buscalibros.model.*;
import com.aluracursos.buscalibros.repositorio.LibroRepository;
import com.aluracursos.buscalibros.service.ConsumoAPI;
import com.aluracursos.buscalibros.service.ConvierteDatos;
import org.springframework.dao.DataIntegrityViolationException;

import java.util.*;
import java.util.stream.Collectors;

public class PrincipalBusqueda {
    ConsumoAPI consumoAPI = new ConsumoAPI();
    ConvierteDatos convierteDatos = new ConvierteDatos();
    private final String URL_BASE = "https://gutendex.com/books";
    Scanner teclado = new Scanner(System.in);

    private LibroRepository repositorio;

    public PrincipalBusqueda(LibroRepository repository) {
        this.repositorio = repository;
    }

    public void muestraElMenu() {
        var opcion = -1;

            try {
                while (opcion != 0) {
                    var menu = """
                            ------------
                            Elija la opción a través de su número:
                            
                            1 - Buscar libros por título
                            2 - Listar libros registrados
                            3 - Listar autores registrados
                            4 - Listar autores vivos en un determinado año
                            5 - Listar libros por idioma
                                                
                            0 - Salir
                            """;
                    System.out.println(menu);
                    opcion = teclado.nextInt();
                    teclado.nextLine();
                    switch (opcion) {
                        case 1:
                            encuentraTitulo();
                            break;
                        case 2:
                            librosRegistrados();
                            break;
                        case 3:
                            autoresRegistrados();
                            break;
                        case 4:
                            buscarAutoresVivos();
                            break;
                        case 5:
                            buscarLibroPorIdioma();
                            break;
                        case 0:
                            System.out.println("Cerrando la aplicación...");
                            break;
                        default:
                            System.out.println("Opción inválida, intente nuevamente \n");
                    }
                }
            }
            catch(InputMismatchException e){
                System.out.println("Error: El valor ingresado no es un número entero válido.");
            }
        }


    public DatosLibros busquedaGeneralPorTitulo() {
        System.out.println("Ingrese el título completo o la palabra clave del libro que está buscando: ");
        var tituloBuscado = teclado.nextLine();
        var jsonListaLibros = consumoAPI.obtenerDatos(URL_BASE + "/?search=" + tituloBuscado.toLowerCase().replace(" ", "%20"));
        var gutendexApiReport = convierteDatos.obtenerDatos(jsonListaLibros, GutendexApiReport.class);
        System.out.println(gutendexApiReport);

        Optional<DatosLibros> libroBuscado = gutendexApiReport.listaLibros().stream()
                .findFirst();
        if (libroBuscado.isPresent()) {
            DatosLibros libroEncontrado = libroBuscado.get();
            System.out.println(libroEncontrado);
            return libroEncontrado;
        }
        return null;
    }

    public void encuentraTitulo() {
        try {
            DatosLibros datosLibros = busquedaGeneralPorTitulo();
            Libro libro = new Libro(datosLibros);
            Autor autor = new Autor(datosLibros.autores().get(0));

            autor.setLibro(libro);
            libro.setAutor(autor);
            System.out.println(libro);
            //System.out.println(autor);

            repositorio.save(libro);
        } catch (NullPointerException e){
            System.out.println("Libro no encontrado.");
        } catch (DataIntegrityViolationException e){
            System.out.println("No se puede registrar el mismo libro más de una vez.");
        }
    }

    private void librosRegistrados() {
        List<Libro> libros = repositorio.findAll();

        libros.stream()
                .forEach(System.out::println);

    }

    private void autoresRegistrados() {
        List<Autor> autores = repositorio.mostrarTodosLosAutores();
        autores.forEach(System.out::println);
    }

    private void buscarAutoresVivos() {
        System.out.println("Ingrese el año vivo de autor(es) que desea buscar:");
        int anoBuscado = teclado.nextInt();
        List<Autor> autoresVivos = repositorio.autoresVivosEnFecha(anoBuscado);
        autoresVivos.forEach(System.out::println);
    }

    private void buscarLibroPorIdioma() {
        try {
            System.out.println("""
                    Ingrese el idioma para buscar los libros:
                    es - Español
                    en - Inglés
                    fr - Francés
                    pt - Portugués
                                
                    """);
            var idiomaElegido = teclado.nextLine();
            var idioma = Categoria.fromString(idiomaElegido.toLowerCase().trim());
            List<Libro> librosPorGenero = repositorio.librosPorIdioma(idioma);
            if (librosPorGenero.isEmpty()){
                System.out.println("No se encontraron libros en el idioma seleccionado.");
            } else {
                librosPorGenero.forEach(System.out::println);
            }
        } catch (IllegalArgumentException e){
            System.out.println("Ingrese una opción válida dentro de la lista de idiomas disponible.");
        }
    }


}

