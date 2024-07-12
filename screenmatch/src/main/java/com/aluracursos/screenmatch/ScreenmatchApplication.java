package com.aluracursos.screenmatch;

import com.aluracursos.screenmatch.model.DatosEpisodio;
import com.aluracursos.screenmatch.model.DatosSerie;
import com.aluracursos.screenmatch.model.DatosTemporadas;
import com.aluracursos.screenmatch.service.ConsumoAPI;
import com.aluracursos.screenmatch.service.ConvierteDatos;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class ScreenmatchApplication implements CommandLineRunner {
	@Override
	public void run(String... args) throws Exception {
		//System.out.println("Este es mi primer Adios mundo en Spring.Bienvenido. ");

		var consumoApi = new ConsumoAPI();

		//Consumo del API para toda la informacion de la serie
		var json = consumoApi.obtenerDatos("https://www.omdbapi.com/?t=Game+of+Thrones&apikey=f3eb0070");
		System.out.println("Json de la serie:"+json);

		ConvierteDatos conversor = new ConvierteDatos();

		//Obtener datos especificos de nuestro JSON
		var datos = conversor.obtenerDatos(json, DatosSerie.class);
		System.out.println("Datos especificos de la serie "+datos);

		//Obtengo los datos especificos pero de un episodio
		json = consumoApi.obtenerDatos("https://www.omdbapi.com/?t=Game+of+Thrones&Season=1&episode=1&apikey=f3eb0070");
		DatosEpisodio episodios = conversor.obtenerDatos(json, DatosEpisodio.class);
		System.out.println("Datos especificos del espisodio "+episodios);

		List<DatosTemporadas> temporadas = new ArrayList<>();
		for (int i = 1; i <= datos.totalDeTemporadas() ; i++) {
			json = consumoApi.obtenerDatos("https://www.omdbapi.com/?t=Game+of+Thrones&Season="+i+"&apikey=f3eb0070");
			var datosTemporadas = conversor.obtenerDatos(json, DatosTemporadas.class);
			temporadas.add(datosTemporadas);
		}
		temporadas.forEach(System.out::println);

	}

	public static void main(String[] args) {
		SpringApplication.run(ScreenmatchApplication.class, args);
	}

}
