package com.aluracursos.LiterAlura.principal;

import com.aluracursos.LiterAlura.model.DatosLibros;
import com.aluracursos.LiterAlura.model.Libros;
import com.aluracursos.LiterAlura.repository.LibrosRepository;
import com.aluracursos.LiterAlura.service.ConsumoApi;
import com.aluracursos.LiterAlura.service.ConvierteApi;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Principal {
    private final Scanner teclado = new Scanner(System.in);
    private final ConsumoApi consumoApi = new ConsumoApi();
    private final ConvierteApi conversor = new ConvierteApi();
    private final String URL_BASE = "http://gutendex.com/books";
    private List<DatosLibros> datosLibros = new ArrayList<>();
    private List<Libros> libros;


    @Autowired
    private LibrosRepository repositorio;

    public Principal(LibrosRepository repositorio) {
        this.repositorio = repositorio;
    }


    public void menuPrincipal() {
        var opcionElegida = -1;
        while (opcionElegida != 0) {
            var menu = """
                    1.- Buscar libros por título.
                    2.- Historial de libros registrados.
                    3.- Historial de autores registrados.
                    4.- Listar autores según el año en el que estuvieron vivos.
                    5.- Listar libros por idioma.
                    6.- Top 10 libros más descargados.
                    7.- Buscar autores por nombre.


                    0.- Salir.

                    """;
            System.out.println(menu);
            opcionElegida = teclado.nextInt();
            teclado.nextLine();

            switch (opcionElegida) {
                case 1:
                    buscarLibroPorTitulo();
                    break;
                case 2:
//                    historialDeLibros();
                    break;
                case 3:
//                    historialDeAutores();
                    break;
                case 4:
//                    autoresPorAño();
                    break;
                case 5:
//                    librosPorIdioma();
                    break;
                case 6:
//                    top10Descargas();
                    break;
                case 7:
//                    buscarPorAutor();
                    break;
                case 0:
                    System.out.println("Cerrando la aplicación.....");
                    System.out.println("Guardando datos......");
                    System.out.println("Muchas gracias por utilizar los servicios de LiterAlura!");
                    break;
                default:
                    System.out.println("Opción no valida, por favor, ingrese una opción de las listadas en el menú disponible");

            }
        }

    }

    private DatosLibros getDatosLibros() {
        System.out.println("Escribe el nombre del libro que deseas buscar");
        var nombreLibro = teclado.nextLine();
        var json = consumoApi.obtenerDatos(URL_BASE + "?search=" + nombreLibro.replace(" ", "+").toLowerCase());
        System.out.println(json);
        DatosLibros datos = conversor.obtenerDatos(json, DatosLibros.class);
        return datos;
    }

    private void buscarLibroPorTitulo() {
        DatosLibros datos = getDatosLibros();
        Libros libros = new Libros(datos);
        repositorio.save(libros);
        datosLibros.add(datos);
        System.out.println(datos);


    }
}
