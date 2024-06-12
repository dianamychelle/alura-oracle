import com.aluracursos.screenmatch.modelos.Pelicula;

public class Principal {
    public static void main(String[] args) {
        Pelicula primeraPelicula =  new Pelicula();

        primeraPelicula.nombre = "Donnie Darko";
        primeraPelicula.fechaLanzamiento = 2001;
        primeraPelicula.duracionMinutos = 120;

        primeraPelicula.muestraFichaTecnica();
        primeraPelicula.evalua(10,9,9);
        //System.out.println(primeraPelicula.sumaEvaluaciones);
        System.out.println(primeraPelicula.rate());
        //System.out.println(primeraPelicula.getTotalEvaluaciones()); accediento a la private var

//        com.aluracursos.screenmatch.modelos.Pelicula segundaPelicula =  new com.aluracursos.screenmatch.modelos.Pelicula();
//        segundaPelicula.nombre = "Le silence de la mer";
//        segundaPelicula.fechaLanzamiento = 2004;
//        segundaPelicula.duracionMinutos = 93;
//
//        segundaPelicula.muestraFichaTecnica();
//
//        primeraPelicula.evalua(10,10,9);
//        System.out.println(primeraPelicula.rate());

    }
}
