package com.aluracursos.screenmatch.principal;
import com.aluracursos.screenmatch.model.DatosEpisodio;
import com.aluracursos.screenmatch.model.DatosSerie;
import com.aluracursos.screenmatch.model.DatosTemporadas;
import com.aluracursos.screenmatch.service.ConsumoAPI;
import com.aluracursos.screenmatch.service.ConvierteDatos;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

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
        temporadas.forEach(t ->t.episodios().forEach(e -> System.out.println(e.titulo())));






    }
}
