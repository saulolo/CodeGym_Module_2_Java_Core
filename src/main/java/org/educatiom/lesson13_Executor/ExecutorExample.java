package org.educatiom.lesson13_Executor;

public class ExecutorExample {



    public static void main(String[] args) {

        System.out.println("--------- ThreadGroup - grupos de hilos ----------");
        //ThreadGroup - grupos de hilos
        /*se introdujo para evitar que un subproceso se detenga e interrumpa repetidamente todos los demás subprocesos.
        Un subproceso solo puede afectar a otros subprocesos en el mismo grupo de subprocesos. ThreadGroup es una clase
        para administrar grupos de subprocesos. Este enfoque le permite proteger subprocesos de cambios no deseados.
        La clase ThreadGroup tiene métodos que le permiten obtener listas de todos los subprocesos y afectarlos/cambiarlos.
        Cuando creamos un nuevo subproceso sin especificar explícitamente un grupo, se une al mismo grupo que el subproceso creador"
        Cada subproceso tiene una prioridad representada por un número del 1 al 10". "10 es la máxima prioridad". "1 es el más bajo".
        "Si no se da prioridad, entonces un subproceso obtiene prioridad 5 (normal)"
        "La clase Thread también tiene tres constantes:"
        public final static int MIN_PRIORITY = 1;
        public final static int NORM_PRIORITY = 5;
        public final static int MAX_PRIORITY = 10;
        "Déjame adivinar. MIN_PRIORITY es la prioridad mínima, MAX_PRIORITY es la máxima y NORM_PRIORITY es la prioridad
        predeterminada"..
        */

        System.out.println("--------- getName() ----------");
        //getName()
        /*Devuelve el nombre del grupo.*/

        System.out.println("--------- getParent() ----------");
        //getParent()
        /*Devuelve el grupo principal.*/

        System.out.println("--------- interrupt() ----------");
        //interrupt()
        /*Interrumpe todos los subproceos del grupoo.*/

        System.out.println("--------- isDaemon() ----------");
        //isDaemon()
        /*Comprueba si el grupo es un daemon.*/

        System.out.println("--------- setDaemon() ----------");
        //setDaemon()
        /*Establece la propiedad demonio del grupo.*/

        System.out.println("--------- activeCount() ----------");
        //activeCount()
        /*Devuelve el número de subprocesos activos en el grupo y sus subgrupos.*/

        System.out.println("--------- activeGroupCount() ----------");
        //activeGroupCount()
        /*Devuelve el número de grupos en vivo en el grupo y sus subgrupos*/

        System.out.println("--------- enumerate(Thread[] list) ----------");
        //enumerate(Thread[] list)
        /*Coloca todos los subprocesos en vivo en la matriz y devuelve el número de ellos.*/

        System.out.println("--------- getMaxPriority() ----------");
        //getMaxPriority()
        /*Devuelve la prioridad máxima para los subprocesos del grupo.*/

        System.out.println("--------- setMaxPriority(int priority) ----------");
        //setMaxPriority(int priority)
        /*Le permite establecer la prioridad máxima de los hilos en el grupo y subgrupos.*/

        //¿Por qué necesita la interfaz Executor?
        /*Antes de Java 5, tenía que escribir su propia gestión de subprocesos de código en su aplicación. Además, crear
        un nuevo hilo object es una operación que consume muchos recursos y no tiene sentido crear un nuevo subproceso
        para cada tarea ligera. Y debido a que este problema es familiar para absolutamente todos los desarrolladores de
        aplicaciones de subprocesos múltiples, decidieron llevar esta funcionalidad a Java como el marco Executor .

        ¿Cúal es la gran idea? Es simple: en lugar de crear un nuevo hilo para cada nueva tarea, los hilos se guardan en
        una especie de "almacenamiento", y cuando llega una nueva tarea, recuperamos un hilo existente en lugar de crear
        uno nuevo.

        Las principales interfaces de este marco son Executor , ExecutorService y ScheduledExecutorService , cada una de
        las cuales amplía la funcionalidad de la anterior.*/

    }

}
