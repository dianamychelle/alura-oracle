package com.aluracursos.principal;
import com.aluracursos.screenmatch.exception.ErrorEnConversionDeDuracionException;
import com.aluracursos.screenmatch.modelos.Titulo;
import com.aluracursos.screenmatch.modelos.TituloOmdb;
import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.FileWriter;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PrincipalConBusqueda {
    public static void main(String[] args) throws IOException, InterruptedException {
        Scanner scanner = new Scanner(System.in);

        List<Titulo> titulos = new ArrayList<>();

        Gson gson = new GsonBuilder()
                .setFieldNamingPolicy(FieldNamingPolicy.UPPER_CAMEL_CASE)
                .setPrettyPrinting()
                .create();

        while(true){
            System.out.println("Escribe nombre de la pelicula:");
            var busqueda = scanner.nextLine();

            if(busqueda.equalsIgnoreCase("salir")){
                break;
            }


            String direccion = "https://www.omdbapi.com/?t="+
                    busqueda.replace(" ","+")+
                    "&apikey=f3eb0070";

            try{

                HttpClient client = HttpClient.newHttpClient();
                HttpRequest request = HttpRequest.newBuilder()
                        .uri(URI.create(direccion))
                        .build();

                HttpResponse<String> response = client
                        .send(request, HttpResponse.BodyHandlers.ofString());

                //------------------------------------De Json a Clase
                String json = response.body();
                System.out.println(response.body());
                //

                TituloOmdb miTituloOmdb = gson.fromJson(json, TituloOmdb.class);
                System.out.println(miTituloOmdb);


                Titulo miTitulo = new Titulo(miTituloOmdb);
                System.out.println("Titulo convertido: " + miTitulo);

                titulos.add(miTitulo);

            }catch(NumberFormatException e){
                System.out.println("Ocurrió un error");
                System.out.println(e.getMessage());
            }catch(IllegalArgumentException e){
                System.out.println("Ocurrió un error en la URI");
            }catch(ErrorEnConversionDeDuracionException e){
                System.out.println(e.getMessage());
            }

        }
        System.out.println(titulos);

        FileWriter escritura = new FileWriter("titulos.json");
        escritura.write(gson.toJson(titulos));
        escritura.close();

        System.out.println("Finalizó la ejecucion");

    }
}
