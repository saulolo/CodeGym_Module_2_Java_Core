package org.educatiom.lesson06_FuncionesLambdaYStreams.FuncionesLambdaPrincipales;

import java.util.function.UnaryOperator;

public class UnaryOperatorExample {

    public static void main(String[] args) {


        System.out.println("------------------ UnaryOperator -----------------------");
        //UnaryOperator
        /*Recibe un valor (parametro), lo procesa y retorna un valor del tipo al recibido.*/

        UnaryOperator<String> unaryOperator = (str) ->  "Soy un UnaryOperator";

        System.out.println(unaryOperator.apply("Hola "));
    }
}
