package org.educatiom.lesson03_OOP_ComposicionAgregacionYHerencia;

public class AsociacionExample {

    public static void main(String[] args) {

        System.out.println("--------------------- Asociacion ---------------------------");
        //Asociacion
        /*Las clases y los objetos se pueden relacionar entre sí. La herencia describe una relación "ES A". Un león ES
        UN animal. Esta relación se expresa fácilmente usando herencia, donde Animalsería la clase padre y Lionsería la
        clase hija. Pero no todas las relaciones en el mundo se describen correctamente de esta manera. Por ejemplo, un
        teclado defiitivamente tiene alguna relación con una computadora, pero no es una computadora . Las manos tienen
        alguna relación con una persona, pero no son una persona. Estos casos representan un tipo diferente de relación,
        no "ES A", sino "TIENE A". Las manos no son una persona, pero una persona TIENE manos. Un teclado no es una
        computadora, pero una computadora TIENE UN teclado. "TIENE UN"*/

        //Agregación
        /*La agregación es un tipo especial de asociación que indica que una clase (un objeto) es parte de otra clase*/

        //Composición
        /* La composición es un tipo más estricto de relación. Al usar composición, un objeto tiene otro objeto, pero no
        puede pertenecer a otro objeto del mismo tipo. El ejemplo más simple es el motor de un automóvil. Si un automóvil
        tiene un motor, ese motor no puede pertenecer a otro automóvil.*/
        /*
                +-------+                 +--------+
                |  Car  |<>-------------->| Engine |
                +-------+                 +--------+
                   Composición: cada coche tiene un motor.
                   si el coche se destruye, el motor también se destruye

                +-------+                 +-----------+
                |  Car  |o--------------->| Passengers |
                +-------+                 +-----------+
                   Agregación: puede haber pasajeros en un automóvil (pueden entrar y salir)
         */

    }
}
