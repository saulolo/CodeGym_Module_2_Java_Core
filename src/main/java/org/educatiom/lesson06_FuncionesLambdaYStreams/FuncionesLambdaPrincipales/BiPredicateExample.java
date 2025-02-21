package org.educatiom.lesson06_FuncionesLambdaYStreams.FuncionesLambdaPrincipales;

import java.util.function.BiPredicate;

public class BiPredicateExample {

    public static void main(String[] args) {

        System.out.println("------------------ BiPredicate -----------------------");
        //BiPredicate
        /*Recibe dos valores y devuelve un booleano (true o false).*/
        BiPredicate<Integer, Integer> biPredicate = (num1, num2) -> num1 > num2;

        System.out.println(biPredicate.test(2, 1));
    }
}
