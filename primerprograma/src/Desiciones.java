public class Desiciones {
    public static void main(String[] args) {
        int fechaDeLanzamiento = 1999;
        boolean incluidoEnElPlan = true;
        double notaPelicula = 8.2;
        String tipoPlan = "plus";

        if(fechaDeLanzamiento>2022){
            System.out.println("Pelicula reciente");
        }else{
            System.out.println("Pelicula NO reciente");
        }

        if(incluidoEnElPlan || tipoPlan.equals("plus")){
            System.out.println("Que bendicion, tienes el plan plus");
        }else{
            System.out.println("Actualiza el plan plox");
        }
    }
}
