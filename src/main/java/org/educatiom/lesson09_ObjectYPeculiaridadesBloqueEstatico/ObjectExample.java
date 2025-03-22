package org.educatiom.lesson09_ObjectYPeculiaridadesBloqueEstatico;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ObjectExample {

    public static void main(String[] args) {

        System.out.println("--------------------- Object ---------------------");
        //Object
        /*Es la clase padre de todas las clases y tiene varios métodos. los creadores de Java identificaron varios
        métodos que, en su opinión, todas las clases deberían tener y los agregaron a la clase Object Y cuando se
        combina con polimorfismo (la capacidad de anular los métodos de la clase Object en clases derivadas), se
        convierte en una herramienta muy poderosa*/

        System.out.println("--------------------- toString() ---------------------");
        //toString()
        /*Devuelve una representación de cadena del objeto.*/
        String text = "Probando el toString.";

        System.out.println("--------------------- hasCode() y equals() ---------------------");
        //hasCode() y equals()
        /*Un par de métodos utilizados para comparar objetos. en Java, los objetos en una colección siempre se
        comparan/recuperan usando hashCode() antes de compararlos/recuperarlos usando iguales.  Y si objetos idénticos
        tienen códigos hash diferentes, entonces los objetos se considerarán diferentes y el método de igualdad ni
        siquiera será llamado*/
        System.out.println(text.hashCode()); //1750473180

        System.out.println("--------------------- getClass() ---------------------");
        //getClass()
        /*Devuelve un objeto especial que describe la clase actual.*/
        Class s = int.class;
        String name = s.getName();
        System.out.println(name); //int

        System.out.println("--------------------- notify(), notifyAll(), wait() ---------------------");
        //notify(), notifyAll(), wait()
        /*Métodos para controlar el acceso a un objeto desde diferentes hilos. Para la sincronización de subprocesos.
        * Java tiene un mecanismo incorporado para controlar el acceso a recursos compartidos (objetos) desde diferentes
        * subprocesos. Un subproceso puede declarar que un objeto está ocupado y otros subprocesos tendrán que esperar
        * hasta que se libere el objeto ocupado. */

        System.out.println("--------------------- finalize() ---------------------");
        //finalize()
        /*Este method le permite liberar recursos nativos que no son de Java: cerrar archivos, transmisiones, etc.
        * Java 7 tiene una nueva declaración para reemplazar el method finalize . Se llama try-with-resources .
        No es realmente un reemplazo para finalizar , sino que es un enfoque alternativo".
        * "Es casi como try-catch . La cosa es que, a diferencia del method finalize (), el bloque finalmente en una
        instrucción try- catch-finally siempre se ejecuta. Los programadores también han usado esta técnica cuando han
        * necesitado liberar recursos, cerrar hilos, etc.*/

        System.out.println("--------------------- clone() ---------------------");
        //clone()
        /*Este method le permite clonar un objeto: crea un duplicado del objeto.
        * La interfaz Cloneable es lo que se llama una 'interfaz de marcador': no ​​tiene ningún method y se usa
        para marcar ciertas clases. Si el desarrollador de una clase cree que los objetos de la clase se pueden clonar,
        * lo marca con esta interfaz (es decir, hace que la clase implemente Cloneable)*/
        /*" a) Agregue la interfaz Cloneable a su clase"
        " b) Anule el method de clonación y llame a la implementación de la superclase dentro de su implementación:"
        * */
/*        class Point implements Cloneable {
            int x;
            int y;

            public Object clone() {
                return super.clone();
            }
        }*/

        /*"O puede escribir una implementación del method de clonación por su cuenta:"*/
/*        class Point
        {
            int x;
            int y;

            public Object clone()
            {
                Point point = new Point();
                point.x = this.x;
                point.y = this.y;
                return point;
            }
        }*/

    }
}
