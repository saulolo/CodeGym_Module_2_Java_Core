package org.educatiom.lesson06_FuncionesLambdaYStreams.FuncionesLambdaPrincipales;

import java.util.function.UnaryOperator;

public class RunnableExample {

    public static void main(String[] args) {


        System.out.println("------------------ Runnable -----------------------");
        //Runnable
        /*No recibe valores y no retorna nada, solo ejecuta una tarea.
        * Nota: Esta función se utiliza para trabajar con concurrencia, hilos y promesas (future). */

        Runnable runnable = () -> System.out.println("Ejecutando tarea de tipo runnable.");

        runnable.run();
    }
}
