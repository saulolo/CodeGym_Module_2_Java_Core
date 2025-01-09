package org.educatiom.lesson02_OOP_SobrecargaAnulacionClasesAbstractas.ClaseAbstractaExample;

public class MetodosDeAnulacionExample {

    public static void main(String[] args) {

        System.out.println("--------------------- Metodos De Anulacion ---------------------------");
        //Metodos De Anulación
        /*Anulación de methods, en la programación orientada a objetos, es una característica del lenguaje que permite
        que una subclase o clase secundaria proporcione una implementación específica de un method que ya proporciona
        una de sus superclases o clases principales. Eso es básicamente correcto. La anulación le permite tomar algún
        method de una clase principal y escribir su propia implementación en cada clase derivada. La nueva implementación
        en la clase secundaria "reemplaza" a la principal.*/

        //Limitación de la anulacion de methods
        /*1. Un method anulado debe tener los mismos argumentos que el method de la clase principal.
        * 2. El method invalidado debe tener el mismo tipo de valor devuelto que el method de la clase principal.
        * 3. El modificador de acceso del method anulado tampoco puede diferir del original. */

    }
}
