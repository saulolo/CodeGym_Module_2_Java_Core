package org.educatiom.lesson06_FuncionesLambdaYStreams.FuncionesLambdaPrincipales;

import java.util.concurrent.Callable;

public class CallableExample {

    public static void main(String[] args) {


        System.out.println("------------------ Callable -----------------------");
        //Callable
        /*No recibe valores pero retorna un resultado (El tipo de return si se lo debemos de pasar) y puede lanzar una
        excepción.
        Nota: Esta función se utiliza para trabajar con concurrencia, hilos y promesas (future) .*/

        Callable<String> callable = () -> "Hola, Soy un Callable";

        try {
            System.out.println(callable.call());
        }catch (Exception e) {
            throw new RuntimeException(e);
        }



    }
}
