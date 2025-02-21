package org.educatiom.lesson06_FuncionesLambdaYStreams.FuncionesLambdaPrincipales;

import java.util.function.BiFunction;

public class BiFunctionExample {

    public static void main(String[] args) {

        System.out.println("------------------ BiFunction -----------------------");
        //BiFunction
        /*Recibe dos valores (1ro y el 2do es el tipo de valor que recibe y el 3ro es el tipo de valor que va a retornar) y retorna un resultado.*/
        BiFunction<Integer, Integer, Integer> biFunction = Integer::sum;

        System.out.println(biFunction.apply(2, 3));
    }
}
