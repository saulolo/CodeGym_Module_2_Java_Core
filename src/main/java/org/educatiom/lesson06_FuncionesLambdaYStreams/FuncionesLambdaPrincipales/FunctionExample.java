package org.educatiom.lesson06_FuncionesLambdaYStreams.FuncionesLambdaPrincipales;

import java.util.function.Function;

public class FunctionExample {

    public static void main(String[] args) {

        System.out.println("------------------ Function -----------------------");
        //Function
        /*Recibe un valor (1ro es el tipo de valor que recibe y el 2do es el tipo de valor que va a retornar) y retorna
        un resultado.*/
        Function<Integer, String> function = (num) -> "El número es: " + num;

        System.out.println(function.apply(2));
    }
}
