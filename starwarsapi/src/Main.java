import java.sql.SQLOutput;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        ConsultaPelicula consulta = new ConsultaPelicula();
        try{
            Pelicula pelicula = consulta.buscaPelicula(1);
            System.out.println(pelicula);
        }catch (RuntimeException e){
            System.out.println(e.getMessage());
            System.out.println("Finalizando aplicación.");
        }







        }
    }