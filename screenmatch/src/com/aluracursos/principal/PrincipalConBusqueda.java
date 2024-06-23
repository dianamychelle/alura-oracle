package com.aluracursos.principal;
import com.aluracursos.screenmatch.modelos.Titulo;
import com.google.gson.Gson;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Scanner;

public class PrincipalConBusqueda {
    public static void main(String[] args) throws IOException, InterruptedException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Escribe nombre de la pelicula:");
        var busqueda = scanner.nextLine();

        String direccion = "https://www.omdbapi.com/?t="+busqueda+"&apikey=f3eb0070";

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(direccion))
                .build();

        HttpResponse<String> response = client
                .send(request, HttpResponse.BodyHandlers.ofString());

        //De Json a Clase
        String json = response.body();
        System.out.println(response.body());

        Gson gson = new Gson();
       //Titulo miTitulo = gson.fromJson(json, Titulo.class);
        System.out.println(miTitulo);


    }
}
