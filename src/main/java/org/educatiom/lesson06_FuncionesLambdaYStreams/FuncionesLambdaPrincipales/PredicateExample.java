package org.educatiom.lesson06_FuncionesLambdaYStreams.FuncionesLambdaPrincipales;

import java.util.function.Predicate;

public class PredicateExample {

    public static void main(String[] args) {

        System.out.println("------------------ Predicate -----------------------");
        //Predicate
        /*Recibe un valor y devuelve un booleano (true o false).*/
        Predicate<String> predicate = str -> str.length() > 5;

        System.out.println(predicate.test("Soy un predicate"));
    }
}
