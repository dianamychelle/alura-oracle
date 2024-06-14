package com.aluracursos.screenmatch.modelos;

import com.aluracursos.screenmacth.calculos.Clasificable;

public class Pelicula extends Titulo implements Clasificable {
    private String director;

    //Constructor de la clase madre,definido en titulo
    public Pelicula(String nombre, int fechaDeLanzamiento) {
        super(nombre, fechaDeLanzamiento);
    }

    //GETTERS AND SETTERS
    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    @Override
    public int getClasificacion() {
        return (int) (calculaMedia() / 2);
    }

    @Override
    public String toString() {
        return "Pelicula:"+this.getNombre() +"("+getFechaDeLanzamiento()+")";
    }
}
