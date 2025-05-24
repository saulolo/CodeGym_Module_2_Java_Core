package org.educatiom.lesson18_AnotacionesJava;

public class AnotacionesEnJavaExample {

    public static void main(String[] args) {

        System.out.println("--------- Anotaciones en Java ----------");
        //Anotaciones en Java

        System.out.println("--------- Enfoque de codificación declarativa e imperativa ----------");
        /*La programación funcional es un paradigma donde las funciones se entienden como funciones matemáticas, no como
        subrutinas, como en la programación procedimental . Es decir, en estos dos paradigmas interpretamos la palabra
        "función" de manera diferente. Recuerda esto y no los confundas. Java no permite que te confundas, ya que los
        subprogramas se denominan "méthodos", mientras que las funciones se refieren a funciones matemáticas (también:
        funciones lambda o referencia de méthod).*/

        /*Pros de la programación funcional
        * Fiabilidad del código mejorada
        * Prácticas pruebas unitarias
        * Oportunidades para la optimización del código durante la compilación
        * Oportunidades de concurrencia

        Contras de la programación funcional
        Las desventajas de la programación funcional se derivan de todas estas mismas características:
        * No hay instrucciones de asignación. En cambio, los nuevos valores se almacenan en nuevas variables, lo que
        lleva a la necesidad de asignar y liberar memoria constantemente. Como resultado, la recolección de basura
        altamente eficiente es una parte esencial de cualquier sistema que ejecute programas funcionales.
        * La evaluación no estricta significa que el orden de las llamadas a funciones es impredecible, lo que crea
        problemas de E/S cuando el orden de las operaciones es importante.

        Las anotaciones son una forma especial de metadatos sintácticos que se pueden declarar en el código. Se utilizan
        para analizar el código en la compilación o en tiempo de ejecución. Puede pensar en una anotación como una
        etiqueta, una etiqueta o una sugerencia del compilador.

        Antes de Java 5, usaban una interfaz que no hacía lo que esperamos que hagan las interfaces. No tenía métodos ni contrato. Simplemente marcó una clase como especial de alguna manera.

        Tal interfaz se denominó interfaz de marcador. Por el nombre, puede adivinar que su propósito es marcar clases
        para la JVM, el compilador o alguna biblioteca. Quedan algunas interfaces de marcador, como Serializable . Esta
        interfaz de marcador nos permite indicar que las instancias de una clase se pueden serializar.
        */

        /*Ejemplo de crear anotación:*/
        /*
        @Target({ElementType.TYPE, ElementType.METHOD})
        @Retention(RetentionPolicy.RUNTIME)
        public @interface Info {
            String author() default "Author";
            String version() default "0.0";
        }
         */
    }
}
