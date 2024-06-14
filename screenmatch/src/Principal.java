import com.aluracursos.screenmacth.calculos.CalculadoraDeTiempo;
import com.aluracursos.screenmacth.calculos.FiltroRecomendacion;
import com.aluracursos.screenmatch.modelos.Episodio;
import com.aluracursos.screenmatch.modelos.Pelicula;
import com.aluracursos.screenmatch.modelos.Serie;

import java.sql.SQLOutput;
import java.util.ArrayList;

public class Principal {
    public static void main(String[] args) {
        Pelicula miPelicula = new Pelicula("Encanto",2021);
        miPelicula.setDuracionEnMinutos(120);
        miPelicula.setIncluidoEnElPlan(true);

        miPelicula.muestraFichaTecnica();
        miPelicula.evalua(10);
        miPelicula.evalua(10);
        miPelicula.evalua(7.8);
        System.out.println(miPelicula.getTotalDelasEvaluaciones());
        System.out.println(miPelicula.calculaMedia());
        System.out.println("Média de evaluaciones de la película: " +miPelicula.calculaMedia());

        Serie casaDragon = new Serie("La casa del dragón",2022);
        casaDragon.setTemporadas(1);
        casaDragon.setMinutosPorEpisodio(50);
        casaDragon.setEpisodiosPorTemporada(10);
        casaDragon.muestraFichaTecnica();
        System.out.println(casaDragon.getDuracionEnMinutos());

        Pelicula otraPelicula = new Pelicula("Matrix",1998);
        otraPelicula.setDuracionEnMinutos(180);

        CalculadoraDeTiempo calculadora = new CalculadoraDeTiempo();
        calculadora.incluye(miPelicula);
        calculadora.incluye(casaDragon);
        calculadora.incluye(otraPelicula);
        System.out.println(calculadora.getTiempoTotal());

        FiltroRecomendacion filtroRecomendacion = new FiltroRecomendacion();
        filtroRecomendacion.filtra(miPelicula);

        Episodio episodio = new Episodio();
        episodio.setNumero(1);
        episodio.setNombre("La casa Targaryen");
        episodio.setSerie(casaDragon);
        episodio.setTotalVisualizaciones(50);

        filtroRecomendacion.filtra(episodio);

        Pelicula peliculaDeDiana = new Pelicula("El castillo vagabundo",2004);
        peliculaDeDiana.setDuracionEnMinutos(180);

        //Constructor
        Pelicula peliculaDeMich = new Pelicula("Le silence de la mer",2001);

        ArrayList<Pelicula> listaDePeliculas = new ArrayList<Pelicula>();
        listaDePeliculas.add(peliculaDeDiana);
        listaDePeliculas.add(miPelicula);
        listaDePeliculas.add(otraPelicula);
        System.out.println("Tamanio de la lista:"+listaDePeliculas.size());
        System.out.println("Primera pelicula del array:"+listaDePeliculas.get(0).toString());
        System.out.println("Todas las peliculas:"+listaDePeliculas.toString());















    }
}
