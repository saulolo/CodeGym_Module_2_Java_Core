package org.educatiom.lesson14_ThreadPool;

public class NewWorkStealingPoolExample {

    public static void main(String[] args) {

        System.out.println("--------- New Work Stealing Pool ----------");
        //New Work Stealing Pool
        /*Este grupo de subprocesos es especial. Su comportamiento se basa en la idea de "robar" el trabajo.
        Las tareas se ponen en cola y se distribuyen entre los procesadores. Pero si un procesador está ocupado, otro procesador
        libre puede robarle una tarea y ejecutarla. Este formato se introdujo en Java para reducir los conflictos en las
        aplicaciones de subprocesos múltiples. Está construido sobre el marco fork/join .*/


        System.out.println("--------- fork/join ----------");
        //fork/join
        /*El method de fork inicia una tarea de forma asíncrona en algún subproceso, y el method de join le permite
        esperar a que finalice esta tarea.*/

    }
}
