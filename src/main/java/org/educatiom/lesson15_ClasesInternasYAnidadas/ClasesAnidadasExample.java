package org.educatiom.lesson15_ClasesInternasYAnidadas;

import java.util.ArrayList;

public class ClasesAnidadasExample {

    public class Car
    {
        int height = 160;
        ArrayList doors = new ArrayList();

        public Car() {
            doors.add(new Door());
            doors.add(new Door());
            doors.add(new Door());
            doors.add(new Door());
        }

        class Door {
            public int getDoorHeight()
            {
                return (int)(height * 0.80);
            }
        }
    }

    public static void main(String[] args) {

        System.out.println("--------- Clases Anidadas ----------");
        //Clases Anidadas
        /*"Si una clase se declara dentro de otra clase, entonces es una clase anidada. Las clases anidadas no estáticas
        se denominan clases internas".

        "Los objetos de una clase interna están anidados dentro de los objetos de la clase externa y, por lo tanto,
        pueden acceder a las variables de la clase externa".*/

    }
}
