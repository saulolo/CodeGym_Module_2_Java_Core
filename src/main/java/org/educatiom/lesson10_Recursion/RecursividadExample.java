package org.educatiom.lesson10_Recursion;

public class RecursividadExample {

    public static void countDown(int x) {
        if (x <= 0) {
            System.out.println("Boom!");
        } else {
            System.out.println(x);
            countDown(x - 1); //Se llama a si mismo.
        }
    }

    public static void main(String[] args) {

        System.out.println("--------------------- Object ---------------------");
        //Object
        /*Es cuando un method se llama a si mismo.
        * Ej: */
        countDown(10);

        /*"Con cada llamada, se crea en la memoria otra copia de los argumentos del method, con nuevos valores. Cuando
        volvemos al method anterior, sus variables se usan allí. En otras palabras, durante la recursividad en realidad
        llamamos a otro method, pero con el mismo código que el nuestro! "*/

        /*"Hay muchísimas tareas que se pueden dividir en subtareas separadas que son idénticas a la tarea original.
        Por ejemplo, debe recorrer todos los elementos de un árbol XML. Cada elemento puede tener varios elementos
        secundarios, y estos tienen su propios elementos secundarios".
        "O necesita mostrar la lista de archivos que están en un directorio y todos sus subdirectorios. Así que escribe
        un method que muestra los archivos del directorio actual. Luego, para obtener los archivos de todos los
        subdirectorios, llama a su method usando un argumento diferente: un subdirectorio".*/


    }
}
