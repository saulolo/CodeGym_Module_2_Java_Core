package org.educatiom.lesson06_FuncionesLambdaYStreams.FuncionesLambdaPrincipales;

import java.util.function.BiConsumer;

public class BiConsumerExample {

    public static void main(String[] args) {

        System.out.println("------------------ BiConsumer -----------------------");
        //BiConsumer
        /*Recibe dos valores y no retorna nada.*/
        BiConsumer<String, String> biConsumer = (s1, s2) -> System.out.println(s1 + " " + s2);

        biConsumer.accept("Soy un", "biConsumer.");
    }
}
