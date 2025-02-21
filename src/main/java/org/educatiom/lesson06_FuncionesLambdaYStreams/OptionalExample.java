package org.educatiom.lesson06_FuncionesLambdaYStreams;

import java.util.Optional;

public class OptionalExample {

    /*                                  SIN OPTIONAL                                   */
    public void printString(String s) {
        String str = s != null ? s : "";
        System.out.println(str);
    }


    /*                                  CON OPTIONAL                                   */
    public void printStrinWithOptional(String s) {
        Optional<String> str = Optional.ofNullable(s);
        System.out.println(str.orElse(""));
    }


    public static void main(String[] args) {

        System.out.println("------------- Optional -------------------");
        //Optional
        /* Esta clase permite a los programadores escribir un código un poco más bonito para evitar un
        NullPointerException . Comparemos: */

    }
}
