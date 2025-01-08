package org.educatiom.lesson01_OOP_EncapsulaciónYPolimorfismo;

public class OOPConceptosBasicosExample {

    public static void main(String[] args) {

        System.out.println("--------------------- Pilares de la POO ---------------------------");
        //Abstracción
        /*Simplificar la complejidad mostrando solo los detalles esenciales de un objeto y ocultando los innecesarios.
        Ejemplo: Una clase Coche puede tener atributos como marca y modelo, pero no necesita exponer cómo funciona
        internamente el motor.*/

        //Encapsulamiento
        /*Proteger los datos de un objeto restringiendo el acceso directo y permitiendo su manipulación solo a través de
        métodos específicos.
        Ejemplo: Usar métodos get y set para acceder a atributos privados.*/

        //Herencia
        /*Permitir que una clase (subclase) herede propiedades y comportamientos de otra clase (superclase), promoviendo
        la reutilización del código.
        Ejemplo: Una clase Vehículo puede ser la base de Coche y Moto.*/

        //Polimorfismo
        /*Permitir que los objetos de diferentes clases relacionadas se comporten de manera diferente usando una interfaz
         común.
         Ejemplo: Un method mover() puede tener implementaciones distintas en las clases Coche y Bicicleta.*/


    }
}
