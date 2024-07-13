package com.aluracursos.screenmatch.principal;
import com.aluracursos.screenmatch.model.DatosEpisodio;
import com.aluracursos.screenmatch.model.DatosSerie;
import com.aluracursos.screenmatch.model.DatosTemporadas;
import com.aluracursos.screenmatch.model.Episodio;
import com.aluracursos.screenmatch.service.ConsumoAPI;
import com.aluracursos.screenmatch.service.ConvierteDatos;

import java.sql.SQLOutput;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;


public class Principal {
    private Scanner teclado = new Scanner(System.in);
    private ConsumoAPI consumoApi = new ConsumoAPI();
    private final String URL_BASE = "https://www.omdbapi.com/?t=";
    private final String API_KEY = "&apikey=f3eb0070";

    private ConvierteDatos conversor = new ConvierteDatos();

    public void muestraElMenu(){

        System.out.println("Serie que deseas buscar:");
        var nombreSerie = teclado.nextLine();
        nombreSerie= nombreSerie.replace(" ", "+");

        //JSON General
        var json = consumoApi.obtenerDatos(URL_BASE + nombreSerie + API_KEY);
        System.out.println("Json de la serie:"+json);

        //Obtener datos especificos de nuestro JSON a tipo JAVA
        var datos = conversor.obtenerDatos(json, DatosSerie.class);
        System.out.println("Datos especificos de la serie "+datos);


        //Obtengo los datos de todas las temporadas
        List<DatosTemporadas> temporadas = new ArrayList<>();
        for (int i = 1; i <= datos.totalDeTemporadas() ; i++) {
            json = consumoApi.obtenerDatos(URL_BASE+ nombreSerie + "&Season=" + i+ API_KEY);
            var datosTemporadas = conversor.obtenerDatos(json, DatosTemporadas.class);
            temporadas.add(datosTemporadas);
        }
        //temporadas.forEach(System.out::println);

        /*
        //Mostrar el titulo de los episodios por cada temporada
        for (int i = 0; i < datos.totalDeTemporadas() ; i++) {
            List<DatosEpisodio> episodiosTemporada = temporadas.get(i).episodios();

            for(int j = 0; j < episodiosTemporada.size(); j++) {
                System.out.println(episodiosTemporada.get(j).titulo());

            }
        }
        */

        //Podemos simplificar lo de "Mostrar titulo de los episodios por cada temporada" con funcion Lambda
        //temporadas.forEach(t ->t.episodios().forEach(e -> System.out.println(e.titulo())));

        //Convertir la info a una lista Datos Episodio
        List<DatosEpisodio> datosEpisodios = temporadas.stream()
                .flatMap(t -> t.episodios().stream())
                .collect(Collectors.toList());

        //Top 5 episodios
        System.out.println("Top 5 episodios");
        datosEpisodios.stream()
                .filter(e -> !e.evaluacion().equalsIgnoreCase("N/A"))
                .peek(e -> System.out.println("Primer filtro N/A" +e))
                .sorted(Comparator.comparing(DatosEpisodio::evaluacion).reversed())
                .peek(e -> System.out.println("Segundo filtro Mayor a menor" +e))
                .limit(5)
                .map(e -> e.titulo().toUpperCase())
                .peek(e -> System.out.println("Tercer filtro mayusculas" +e))
                .forEach(System.out::println);


        //Convirtiendo los datos a una lista del tipo episodio
        List<Episodio> episodios = temporadas.stream()
                .flatMap(t -> t.episodios().stream()
                        .map(d -> new Episodio(t.numero(),d)))
                .collect(Collectors.toList());
        /*
        episodios.forEach(System.out::println);
        */


        /*
        // Busqueda de episodios a partir de x año
        System.out.println("a partir de que año deseas ver los episodios?");
        var fecha = teclado.nextInt();
        teclado.nextLine();

        LocalDate fechaBusqueda = LocalDate.of(fecha, 1, 1);

        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        episodios.stream()
                .filter(e -> e.getFechaDeLanzamiento() != null && e.getFechaDeLanzamiento().isAfter(fechaBusqueda))
                .forEach(e -> System.out.println(
                        "Temporada: " + e.getTemporada() +
                                " Episodio: " + e.getTitulo() +
                                " Fecha de Lanzamiento: " + e.getFechaDeLanzamiento().format(dtf)
                ));
        */







    }
}
