package org.educatiom.lesson16_Serializacion;

import java.io.InputStream;
import java.io.Serializable;

public class SerializacionExample {

    public static void main(String[] args) {

        System.out.println("--------- Serializacion ----------");
        //Serializacion
        /*Marcador de interfaz Serializable especial . Se llama marcador porque no contiene datos ni métodos. Solo se
        usa para "etiquetar" o "marcar" clases. Si creemos que nuestra clase almacena todos sus datos internamente,
        podemos marcarla con implements Serializable
        " La deserialización es el proceso de invertir la serialización: leer y reconstruir un objeto a partir de un flujo/archivo".
        */

        System.out.println("--------- transient ----------");
        //transient
        /* Si escribimos esta palabra clave antes de una variable miembro, se ignorará durante la serialización.
        Su estado no se guardará ni se reconstruirá. Eso es para aquellas clases en que la clase almacena datos que no
        juegan un papel importante en su estado y, sin embargo, evita que la clase se considere una clase serializable */


        class Cat implements Serializable{
            /*Cuando tratamos de serializar (guardar) un objeto, la máquina Java verifica si admite la serialización:
            ¿Implementa la interfaz Serializable? Si lo hace, entonces guarda el objeto. Si no, lanza una excepción para
            indicar que la serialización es imposible. Aquí debe comprender que un objeto serializable solo debe consistir
            en objetos serializables.*/

            public String name;
            public int age;
            transient public InputStream in = System.in;
        }

    }
}
