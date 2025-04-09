package org.educatiom.lesson14_ThreadPool;

public class NewFixedThreadPoolExample {

    public static void main(String[] args) {

        System.out.println("--------- newFixedThreadPool ----------");
        //newFixedThreadPool
        /*El method newFixedThreadPool de la clase Executors crea un executorService con un número fijo de subprocesos.
        A diferencia del method newSingleThreadExecutor , especificamos cuántos subprocesos queremos en el grupo.

        Aquí hay otra pregunta interesante: si necesita usar un ejecutor para un solo hilo, ¿a qué method debe llamar?
        newSingleThreadExecutor() o newFixedThreadPool(1) ?. Ambos ejecutores tendrán un comportamiento equivalente.
        La única diferencia es que el method newSingleThreadExecutor() devolverá un ejecutor que no se puede reconfigurar
        más tarde para usar subprocesos adicionales.*/

    }
}
