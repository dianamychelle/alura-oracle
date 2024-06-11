import java.util.Scanner;

public class Loops {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double mediaEvaluaciones = 0;
        double nota = 0;
        int totalEvaluaciones=0;
/*
        for(int i=0;i<3;i++){
            System.out.println("Dame tu nota para la peli:");
            nota = sc.nextDouble();
            mediaEvaluaciones= mediaEvaluaciones + nota;
        }
        mediaEvaluaciones = mediaEvaluaciones/3;
        System.out.println("Media:"+mediaEvaluaciones);
*/
        while(nota!=-1){
            System.out.println("Dame tu nota para la peli:");
            nota = sc.nextDouble();
            if(nota!=-1){
                mediaEvaluaciones += nota;
                totalEvaluaciones++;
            }
        }
        mediaEvaluaciones = mediaEvaluaciones/3;
        System.out.println("Media:"+mediaEvaluaciones);

    }
}
