package org.educatiom.lesson14_ThreadPool;

public class SingleThreadExecutorExample {

    public static void main(String[] args) {

        System.out.println("--------- SingleThreadExecutor ----------");
        //SingleThreadExecutor
        /*Puede usar el method Executors.newSingleThreadExecutor para crear un ExecutorService con un grupo que incluya
          un único subproceso. La lógica del pool es la siguiente:
          El servicio ejecuta solo una tarea a la vez.
          Si enviamos N tareas para su ejecución, todas las N tareas serán ejecutadas una tras otra por el hilo único.
          Si se interrumpe el subproceso, se creará un nuevo subproceso para ejecutar las tareas restantes*/

        //ThreadFactory
        /*A ThreadFactory es un objeto que crea nuevos hilos a pedido.*/

    }
}
