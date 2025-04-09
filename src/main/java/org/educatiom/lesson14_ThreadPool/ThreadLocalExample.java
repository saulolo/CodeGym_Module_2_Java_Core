package org.educatiom.lesson14_ThreadPool;

public class ThreadLocalExample {

    public static void main(String[] args) {

        System.out.println("--------- ThreadLocal ----------");
        //ThreadLocal
        /*La clase ThreadLocal se utiliza para almacenar variables. Una característica distintiva de esta clase es que
        mantiene una copia independiente separada de un valor para cada subproceso que lo usa.*/

        /*¿Por qué la clase Random no es adecuada para generar números aleatorios en aplicaciones de subprocesos múltiples?
        * Random no es adecuado para entornos de subprocesos múltiples, porque cuando varios subprocesos acceden a una
        * clase al mismo tiempo, el rendimiento se ve afectado. Para abordar este problema, JDK 7 introdujo la clase
        * java.util.concurrent.ThreadLocalRandom para generar números aleatorios en un entorno multihilo. Consta de dos
        * clases: ThreadLocal y Random .
        * */

    }
}
