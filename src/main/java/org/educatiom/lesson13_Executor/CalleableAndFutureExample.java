package org.educatiom.lesson13_Executor;

import javax.xml.crypto.Data;
import java.util.Date;
import java.util.concurrent.Callable;

public class CalleableAndFutureExample {

    public static void main(String[] args) {

        System.out.println("--------- Callable ----------");
        //Calleable
        /*El Problema de Runnable:
        ¿qué pasa si necesitamos que nuestro hilo devuelva algún resultado de su trabajo en forma de un número, una
        cadena o algún otro objeto?
        Para eso usamos la interfaz Callable el cual solo tiene un methos. Este method tiene el mismo propósito que el
        method de Runnable : contiene el código que se ejecutará en un subproceso paralelo. En cuanto a las diferencias,
        eche un vistazo al valor de retorno. Ahora puede ser cualquier tipo que especifique al implementar la interfaz:*/

        class CurrentData implements Callable<Long> {

            @Override
            public Long call() {
                return new Date().getTime();
            }
        }

        System.out.println("--------- Future ----------");
        //Future
        /*Future representa el resultado de cálculos asincrónicos (paralelos) (el valor devuelto por el method de Callable).
        Le permite verificar si los cálculos están hechos, esperar a que terminen, obtener el resultado de los cálculos
        y más.
        Los methods de  Future son: */

        System.out.println("--------- isDone() ----------");
        //isDone()
        /*este method devuelve verdadero si se realiza esta tarea (cálculo). Las tareas que finalizaron normalmente,
          finalizaron con una excepción o se cancelaron se consideran realizadas.*/

        System.out.println("--------- V get() ----------");
        //V get()
        /*si es necesario, este method bloquea el subproceso que lo llamó y devuelve el resultado de los cálculos cuando
        finalizan.*/

        System.out.println("--------- boolean cancel(boolean mayInterruptIfRunning) ----------");
        //boolean cancel(boolean mayInterruptIfRunning)
        /*Este method intenta detener la ejecución de la tarea. Si la tarea aún no ha comenzado a ejecutarse, nunca se
        ejecutará. Si la tarea estaba en curso, el parámetro mayInterruptIfRunning determina si se intentará interrumpir
        el subproceso que ejecuta la tarea. Después de llamar al method cancel , el method isDone siempre devolverá true .*/

        System.out.println("--------- isCancelled() ----------");
        //isCancelled()
        /*este method devuelve verdadero si la tarea se cancela antes de que finalice normalmente. El method siempre
        devolverá verdadero si el method de cancelación se llamó previamente y devolvió verdadero.*/

    }

}
