package org.educatiom.lesson06_FuncionesLambdaYStreams.FuncionesLambdaPrincipales;

import java.util.function.BinaryOperator;

public class BinaryOperatorExample {

    public static void main(String[] args) {

        System.out.println("------------------ BinaryOperator -----------------------");
        //BinaryOperator
        /*Recibe dos valores del mismo tipo y devuelve un valor del mismo tipo.*/
        BinaryOperator<Integer> binaryOperator = Integer::sum;

        System.out.println(binaryOperator.apply(2, 8));
    }
}
