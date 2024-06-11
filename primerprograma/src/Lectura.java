import java.util.Scanner;

public class Lectura {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Peli fav:");
        String peliFav = sc.nextLine();
        System.out.println("Fecha de lanzamiento:");
        String peliLanz = sc.nextLine();
        System.out.println("Nota de la peli:");
        double peliNota = sc.nextDouble();

        System.out.println(peliFav + " " + peliLanz + " "+ peliNota);
    }
}
