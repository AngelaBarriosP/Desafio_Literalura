<h1 align="center"> Presentación del segundo desafío BackEnd del programa Oracle Next Education </h1>

<h2>Desafio LiterAlura</h2>

<h2>Descripción del proyecto:</h2>
En este desafío creé una aplicación desde cero que le permite al usuario:
 1 - Buscar libros por título
 2 - Listar libros registrados
 3 - Listar autores registrados
 4 - Listar autores vivos en un determinado año
 5 - Listar libros por idioma

La información de los libros y sus autores se obtiene consumiendo la API Gutendex.

<h2>Funcionalidades:</h2>
Las siguientes son las caracteristicas técnicas más importantes de la aplicación:
<ul>
  <li>Se realiza la búsqueda del titulo del libro a partir de una palabra, o del titulo completo</li>
  <li>En caso de encontrar un libro, muestra la información general del libro encontrado, de lo contrario, informa que no ha encontrado ninguna coincidencia</li>
  <li>Muestra un listado con la información general (titulo, autor, idioma, cantidad de descargas) de todos los libros guardados en la base de datos PostgreSQL</li>
  <li>Muestra el listado con la información general (nombre, año de nacimiento, año de fallecimiento, libro) de todos los autores guardados en la base de datos</li>
  <li>No permite guardar más de una vez un titulo o autor en la base de datos</li>
  <li>El usuario ingresa un año cualquiera y el programa busca y muestra todos los autores que estaban vivos en ese año</li>
  <li>Se usó un "enum" para crear una variable de Categoria que engloba los idiomas en los que pueden estar las obras</li>
  <li>El usuario puede escoger cualquier idioma, escribirlo en mayúsculas, o con espacios, y el programa identificará correctamente el idioma correspondiente</li>
  <li>Se gestionaron diversos tipos de error que se puede presentar durante la ejecución del programa, como: InputMismatchException, NullPointerException, DataIntegrityViolationException.</li>
  <li>Se usaron variables de entorno para proteger la información de la conexión con la base de datos</li>
</ul>

Podrás observar como funciona en el siguiente video: https://youtu.be/ZLpUMVTKFl4

<h2>Tecnologías utilizadas:</h2>
Java, Spring Boot, JPA, PostgreSQL, Maven

Hecho por: Luz Angela Barrios Pulido
