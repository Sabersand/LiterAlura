package com.aluracursos.LiterAlura.principal;

import com.aluracursos.LiterAlura.service.ConvierteDatos;
import com.aluracursos.LiterAlura.service.ConsumoApi;
import com.aluracursos.LiterAlura.model.*;
import com.aluracursos.LiterAlura.repository.AutorRepository;
import com.aluracursos.LiterAlura.repository.LibrosRepository;
import java.util.*;


public class Principal {

    private static final String URL_BASE = "https://gutendex.com/books/";
    private ConsumoApi consumoApi = new ConsumoApi();
    private ConvierteDatos convierteDatos = new ConvierteDatos();
    private Scanner teclado = new Scanner(System.in);
    private List<DatosLibros> datosLibros = new ArrayList<>();
    private LibrosRepository repository;
    private AutorRepository repositoryAutor;
    private List<Libros> libros;
    private List<Autor> autor;

    public Principal (){}
    public Principal(LibrosRepository repository, AutorRepository repositoryAutor) {
        this.repository = repository;
        this.repositoryAutor = repositoryAutor;
    }

    public void opcionesMenu (){
        var opcion = -1;
        while (opcion != 0) {

            infoMenu();
            scannerSoloNumeros();

            opcion = teclado.nextInt();
            teclado.nextLine();

            switch (opcion) {
                case 1:
                    buscarLibro();
                    break;
                case 2:
                    mostrarLibrosRegistrados();
                    break;
                case 3:
                    mostrarAutoresRegistrados();
                    break;
                case 4:
                    buscarAutorVivoEnAño();
                    break;
                case 5:
                    buscarLibrosPorIdioma();
                    break;
                case 0:
                    System.out.println("Cerrando la aplicación...");
                    System.out.println("Muchas gracias por usar Literalura!");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Opción no válida, por favor ingresa otra opción del menú");
            }
        }
    }


    public void buscarLibro() {
        System.out.println("Vamos a buscar libros!");
        System.out.println("Ingrese nombre del libro que deseas buscar: ");
        var buscaLibro = teclado.nextLine();
        var json = consumoApi.obtenerDatos(URL_BASE + "?search=" + buscaLibro.replace(" ", "%20"));
        var buscador = convierteDatos.obtenerDatos(json, DatosGenerales.class);

        Optional<DatosLibros> libroBuscado = buscador.resultado().stream()
                .filter(l -> l.titulo().toUpperCase().contains(buscaLibro.toUpperCase()))
                .findFirst();


        if (libroBuscado.isPresent()) {
            DatosLibros datosLibros = libroBuscado.get();
            DatosAutor datosAutor = datosLibros.autor().get(0);
            Autor autor = repositoryAutor.findByNombre(datosAutor.nombre());


            if (autor == null) {

                autor = new Autor(datosAutor);
                repositoryAutor.save(autor);
            }



            Libros libro = repository.findByTituloContainsIgnoreCase(datosLibros.titulo());


            if (libro == null) {
                System.out.println("¡Libro encontrado!");
                libro = new Libros(datosLibros, autor);
                repository.save(libro);
                System.out.println(libro);
            }else {
                System.out.println("Libro ya esta Registrado");
            }
        } else {
            System.out.println("Libro no encontrado");
        }
    }

    private void mostrarLibrosRegistrados(){
        libros = repository.findAll();
        libros.forEach(System.out::println);
    }

    private void mostrarAutoresRegistrados(){
        autor = repositoryAutor.findAll();
        autor.forEach(System.out::println);
    }

    private void buscarLibrosPorIdioma(){
        System.out.println("""
        --------------------------------
        Ingrese numero de idioma deseado
        
        1- Ingles
        2- Español
        3- Portuges
        4- Italiano
        
        -------------------------------
        """);
        scannerSoloNumeros();
        var  numero = teclado.nextInt();
        switch (numero) {
            case 1:
                buscarIdioma("en");
                break;
            case 2:
                buscarIdioma("es");
                break;
            case 3:
                buscarIdioma("pt");
                break;
            case 4:
                buscarIdioma("it");
                break;
            default:
                System.out.println("Opción inválida");
        }
    }
    private void buscarIdioma(String idioma) {
        try {
            libros = repository.findByIdiomas(idioma);

            if (libros == null) {
                System.out.println("No hay Libros registrados");
            } else {
                libros.forEach(System.out::println);
            }
        }catch (Exception e){
            System.out.println("Error en la busqueda");
        }

    }

    private void buscarAutorVivoEnAño () {
        System.out.println("Ingrese año");
        scannerSoloNumeros();
        var año = teclado.nextInt();
        autor = repositoryAutor.autoresVivosEnDeterminadoAño(año);
        if (autor == null) {
            System.out.println("No hay registro de autores en ese año");
        } else {
            autor.forEach(System.out::println);
        }

    }

    private void infoMenu(){
        var menu = """
                    ----------------------------------------
                        MENU:
                    
                    1 - Buscar libros por titulo
                    2 - Mostrar libros registrados
                    3 - Mostrar autores registrados
                    4 - Mostrar autores vivos en determinado año
                    5 - Mostrar libros por idiomas
               
                        
                    0 - Salir
                    -----------------------------------------
                    
                    
                    Por favor, ingrese una de las opciones listadas:
                    """;
        System.out.println(menu);
    }

    private void scannerSoloNumeros() {
        while (!teclado.hasNextInt()) {
            System.out.println("Opción no válida, por favor, ingrese sólo los números de las opciones listadas");
            teclado.next();
        }

    }
}
