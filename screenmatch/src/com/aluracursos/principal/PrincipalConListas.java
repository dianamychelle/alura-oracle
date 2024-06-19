package com.aluracursos.principal;

import com.aluracursos.screenmatch.modelos.Pelicula;
import com.aluracursos.screenmatch.modelos.Serie;
import com.aluracursos.screenmatch.modelos.Titulo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class PrincipalConListas {
    public static void main(String[] args) {
        //1
        Pelicula miPelicula = new Pelicula("Encanto",2021);
        miPelicula.evalua(9);
        //2
        Pelicula otraPelicula = new Pelicula("Matrix",1998);
        otraPelicula.evalua(10);
        //3
        Pelicula peliculaDeDiana = new Pelicula("El castillo vagabundo",2004);
        peliculaDeDiana.evalua(8);
        //4
        Serie casaDragon = new Serie("La casa del dragón",2022);

        ArrayList<Titulo> lista = new ArrayList<>();
        lista.add(peliculaDeDiana);
        lista.add(miPelicula);
        lista.add(otraPelicula);
        lista.add(casaDragon);

        /*
        * Aplicaremos un For each para recorrelo. Titulo corresponde al objeto que haacemos referencia.
        * Vamos a definir item, a cada uno de los elementos que contiene la lista.
        * Tambien se hizo un casteo, ya que para SOLO la clase Pelicula tiene el metodo de getClasificacion() y aqui tambien se
        * requerira para Series
        * */
        for (Titulo item : lista) {
            System.out.println("Nombre:"+item.getNombre());

            if(item instanceof Pelicula pelicula && pelicula.getClasificacion() >2){
                System.out.println("Clasificacion:"+pelicula.getClasificacion());

            }
        }
        //ArrayList de tipo String + Nombre = new ArrayList<>()
        //Ordenamiento de array de artistas
        ArrayList<String> listaDeArtistas = new ArrayList<>();
        listaDeArtistas.add("Penelope Cruz");
        listaDeArtistas.add("Tony Banderas");
        listaDeArtistas.add("Ricardo Darin");
        System.out.println("Lista de artista NO ordenada"+listaDeArtistas);

        Collections.sort(listaDeArtistas);
        System.out.println("Lista de artista ordenada"+listaDeArtistas);

        //Ordenamiento de array de titulos por NOMBRE
        Collections.sort(lista);
        System.out.println("Titulos ordenados"+lista);

        //Ordenamiento de array de titulos por FECHA LANZAMIENTO
        lista.sort(Comparator.comparing(Titulo::getFechaDeLanzamiento));
        System.out.println("Lista ordenada por fecha:"+lista);






    }
}
