package com.aluracursos.screenmatch.modelos;

public class Pelicula {
    public String nombre;
    public int fechaLanzamiento;
    public int duracionMinutos;
    public boolean incluidoEnPlan;
    private double sumaEvaluaciones = 0;
    private int totalEvaluaciones = 3;

    public void muestraFichaTecnica(){
        System.out.println("com.aluracursos.screenmatch.modelos.Pelicula: " + nombre);
        System.out.println("Lanzamiento: " + fechaLanzamiento);
        System.out.println("Duracion: " + duracionMinutos);

    }
    public void evalua(double nota1,double nota2, double nota3){
        sumaEvaluaciones=nota1+nota2+nota3;
    }
    public double rate(){
        return sumaEvaluaciones/ totalEvaluaciones;
    }
//Acceder a una variable privada
    public int getTotalEvaluaciones(){
        return totalEvaluaciones;
    }


}
