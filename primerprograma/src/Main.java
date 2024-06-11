//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        int fechaDeLanzamiento = 1999;
        boolean incluidoEnElPlan = true;
        double notaPelicula = 8.2;
        double media = (9 + 8 + 6)/3;
        String sinopsis = """
        Matrix es una pelicula futrista sobre...
        Fue lanzada en:"""+fechaDeLanzamiento;
        int clasificacion = (int) (media/2);

        System.out.println("Welcome to Screen Match");
        System.out.println("Movie:Matrix");
        System.out.println(sinopsis);
        System.out.println(clasificacion);




    }
}