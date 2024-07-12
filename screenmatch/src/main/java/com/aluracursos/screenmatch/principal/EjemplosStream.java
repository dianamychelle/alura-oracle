package com.aluracursos.screenmatch.principal;

import java.util.Arrays;
import java.util.List;

public class EjemplosStream {
    public void muestraEjemplo(){
        List<String> nombres = Arrays.asList("Diana", "Mich", "Perez", "Mau", "Chayo");
        nombres.stream()
                .sorted()
                .limit(4)
                .filter(n -> n.startsWith("M"))
                .map(n -> n.toUpperCase())
                .forEach(System.out::println);
    }
}
