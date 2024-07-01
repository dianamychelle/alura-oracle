import java.sql.SQLOutput;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        ConsultaPelicula consulta = new ConsultaPelicula();
        System.out.println("Numero:");

        try{
            var numeroDePelicula = Integer.valueOf(sc.nextLine());
            Pelicula pelicula = consulta.buscaPelicula(numeroDePelicula);
            System.out.println(pelicula);
        }catch (NumberFormatException e){
            System.out.println("Numero no encontrado dentro de la API"+e.getMessage());
        }catch (RuntimeException e){
            System.out.println(e.getMessage());
            System.out.println("Finalizando aplicación.Hasta pronto");
        }

        }
    }