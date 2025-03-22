package org.educatiom.lesson08_LlamadoAConstructores;


public class LlamadoAConstructoresExample {

    public static void main(String[] args) {

        System.out.println("--------------------- Creación de un Objeto. Orden de llamda ---------------------");
        //Creación de un Objeto. Orden de llamda
        /*"Esto es lo que sucede: el objeto se crea en varias etapas".
        1)  Primero, se asigna memoria para todas las variables miembro de la clase.
        2)  Luego se inicializa la clase base.
        3)  Luego se asignan valores a todas las variables, si se especifica alguna.
        4)  Finalmente, se llama al constructor.
        "Primero: primero la clase base, luego las variables fuera del constructor, luego el código del constructor".
        */

        System.out.println("--------------------- Carga de clases en memoria ---------------------");
        //Carga de clases en memoria
        /*Las clases en Java son archivos en el disco que contienen bytecode, que es código Java compilado. La máquina
        Java no los carga si no es necesario. Tan pronto como hay una llamada a una clase en algún lugar del código,
        la máquina Java verifica si está cargada. Y si no, lo carga y lo inicializa.*/

        /*Si necesita ejecutar código complejo (por ejemplo, cargar algo desde un archivo) para inicializar objetos,
        podemos hacerlo en un constructor. Sin embargo, las variables estáticas no tienen esta oportunidad. Pero dado
        que la necesidad aún persiste, puede agregue un bloque o bloques de inicialización estáticos a las clases.
        Son básicamente equivalentes a los constructores estáticos*/





    }
}
