package org.educatiom.lesson12_HilosYMultihilosParte2;

public class HilosYMultihilosParte2Example {



    public static void main(String[] args) {

        System.out.println("--------- Problemas de suprocesos múltiples: acceso a un recurso compartido ----------");
        //Problemas de suprocesos múltiples: acceso a un recurso compartido
        /*Un programa es cada vez más complicado. Diferentes subprocesos cambian el estado de diferentes objetos en
        función de las tareas que realizan. Y pueden pisar los dedos de los pies unos a otros.

        Mutex: . Tiene dos estados: el objeto está disponible u ocupado . Estos estados también se denominan «bloqueado»
        y «desbloqueado» funciona como un cartel en la puerta de un baño que dice «disponible / ocupado.
        Los creadores de Java integraron este mutex en la clase Object. Así que ni siquiera tiene que crearlo. Es parte
        de cada objeto.».*/

        System.out.println("--------- Problema de subprocesos múltiples: caché local. Volátil ----------");
        //Problema de subprocesos múltiples: caché local. Volátil
        /*Un subproceso cambia una variable , como isCancel o isInterrupted en el ejemplo anterior, pero un segundo
        subproceso «no ve este cambio , porque sucedió en la memoria rápida. Esto es consecuencia del hecho de que los
        subprocesos no tienen acceso a la memoria caché de los demás. (Un procesador a menudo contiene varios núcleos
        independientes y los subprocesos pueden ejecutarse en núcleos físicamente diferentes).
        Para este problema surgio una solución: La palabra clave volátil nació. Ponemos esta palabra clave antes de una
        declaración de variable para indicar que su valor no se debe poner en el caché. Más precisamente, no era que no
        pudiera colocarse en el caché, era simplemente que siempre tenía que leerse y escribirse en la memoria normal
        (lenta).*/

        System.out.println("--------- Yield - Saltarse un movimiento ----------");
        //Yield - Saltarse un movimiento
        /*Méthod estático de la clase Thread. el procesador cambia constantemente entre subprocesos. A cada subproceso
        se le asigna una pequeña porción de tiempo de procesador, llamado cuanto . Cuando expira este tiempo, el
        procesador cambia a otro subproceso y comienza a ejecutar sus comandos. La llamada Thread.yield()le permite
        finalizar el cuanto del subproceso actual antes de tiempo. En otras palabras, le dice al procesador que cambie
        al siguiente hilo.
        Llamar a yield significa que "nuestro hilo ha terminado con su turno antes de lo previsto" y que el comando
        después de yield comenzará con un cuanto de tiempo completo. Este enfoque se puede utilizar para optimizar
        algunos procesos". También puedo decirte que Thread.sleep(0) en realidad funciona de la misma manera. Creo que
        no usará mucho el method de yield al principio, pero es útil conocerlo.*/

        System.out.println("--------- Join - Esperando que el hilo termine ----------");
        //Join - Esperando que el hilo termine
        /*Nos permite hacer que un hilo espere mientras otro hilo termina su trabajo*/


        System.out.println("--------- DeadLock y sus causas ----------");
        //DeadLock y sus causas
        /*(o bloqueo mutuo) es un problema común en la programación concurrente que ocurre cuando dos o más hilos se
        bloquean indefinidamente, esperando que el otro libere un recurso que necesitan para continuar. Esto resulta en
        una situación en la que ningún hilo puede avanzar, causando que el programa se "cuelgue" o deje de responder.

        //Estrategias para evitar los puntos muertos
        La mejor estrategia es una arquitectura reflexiva y un conjunto de reglas que rijan cuándo y en qué orden puede
        usar bloqueos (adquirir mutexes). El enfoque clásico del problema es desarrollar una jerarquía de bloqueos y
        establecer la regla de que ciertos bloqueos nunca pueden ser adquirido en un estado en el que ya se han
        adquirido otras cerraduras
        */

        System.out.println("--------- Wait-notify-notifyAll ----------");
        //Wait-notify-notifyAll
        /*"El method de espera solo se llama dentro de un bloque sincronizado, en un objeto mutex. En nuestro caso: esto.
        Además, suceden dos cosas:
        1) El hilo se duerme.
        2) El subproceso libera temporalmente el mutex (hasta que se despierta).
        "Después de eso, otros subprocesos pueden ingresar al bloque sincronizado y adquirir ese mismo mutex".
        "El method de notificación también solo se puede llamar dentro del bloque sincronizado de un objeto mutex.
         En nuestro caso: esto. Además, suceden dos cosas:"
         1) Todos los subprocesos que esperan en este objeto mutex se despiertan.
         2) Una vez que el subproceso actual sale del bloque sincronizado, uno de los subprocesos despiertos adquiere
         el mutex y continúa su trabajo. Cuando libera el mutex, otro subproceso despierto adquiere el mutex, etc*/

    }

}
