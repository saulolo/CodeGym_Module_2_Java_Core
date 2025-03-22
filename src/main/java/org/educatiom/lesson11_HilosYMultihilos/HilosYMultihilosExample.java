package org.educatiom.lesson11_HilosYMultihilos;

public class HilosYMultihilosExample {



    public static void main(String[] args) {

        System.out.println("--------------------- Hilos y Multihilos ---------------------");
        //Hilos y Multihilos
        /*Debido a que la computadora tiene un solo procesador, solo puede ejecutar un comando a la vez. Así que esto es
        lo que sucede: el procesador cambia constantemente entre subprocesos. Cambia a un nuevo subproceso, ejecuta
        algunos comandos, luego cambia al siguiente subproceso, ejecuta algunos comandos, etc. Pero dado que el cambio
        entre subprocesos ocurre cientos de veces por segundo, nos parece que todos los subprocesos se ejecutan
        simultáneamente.*/

        //Pasos para crear un Hilo
        /*1)  Crear un objeto Hilo
        2) Pásalo el method que quieres ejecutar
        3)  Llame al method de inicio en el objeto Thread creado.*/
        //Ej:

        System.out.println("--------------------- Runnable ---------------------");
        //Runnable
        /*Para decirle a un objeto Thread qué method específico debe iniciar, necesitamos pasarle un método de alguna
        manera. En Java, esto se hace usando la interfaz Runnable . Esta interfaz contiene un solo method abstracto:
        void run() . La clase Thread tiene un constructor Thread(Runnable Runnable) . Puede pasar cualquier objeto que implemente la interfaz Runnable .*/

        class Printer implements Runnable {

            @Override
            public void run() {
                System.out.println("Estoy imprimiendo.");
            }
        }

        Printer printer = new Printer();
        Thread childThread = new Thread(printer);
        childThread.start();

        System.out.println("--------------------- Sleep ---------------------");
        //Sleep
        /*Es un method estatico de la clase Thread, su porposito es hacer que el programa se "duerma" por un rato.
        * Este method se usa a menudo en subprocesos secundarios cuando necesita hacer algo regularmente pero no con
        * demasiada frecuencia.*/
        try {
            Thread.sleep(2000); // se congela durante 2000 milisegundos = 2 segundos y termina
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }


        System.out.println("--------------------- interrupt() ---------------------");
        //interrupt
        /*Nota: No se puede cancelar un fjulo o detener un hilo, Solo él puede detenerse a sí mismo, Pero puede enviar
        una señal a un subproceso, de alguna manera diciéndole que ya no es necesario realizar el trabajo y que debe
        terminar. Así como el subproceso principal termina regresando del method principal, un subproceso secundario
        termina regresando del method de ejecución. Puede agregar alguna variable, como un booleano . Si es verdadero ,
        el hilo se ejecuta. Si es falso  , el hilo debe terminar.*/
        /*Nota"La palabra clave volatile en Java se usa para indicar que una variable puede ser modificada por múltiples
        hilos al mismo tiempo. En la sentencia que proporcionaste:
        public static volatile int numSeconds = 3;
        */
        class Clock implements Runnable{

            @Override
            public void run() {
                Thread current = Thread.currentThread();
                while (!current.isInterrupted()) {
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    System.out.println("Tick 2");
                }

            }
        }


    }


}
