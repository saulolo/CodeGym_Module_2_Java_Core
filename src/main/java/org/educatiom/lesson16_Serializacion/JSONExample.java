package org.educatiom.lesson16_Serializacion;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class JSONExample {

    public static void main(String[] args) {

        System.out.println("--------- JSON ----------");
        //JSON
        /*JSON es uno de los formatos más populares para representar datos como texto. Por ejemplo, JSON se usa para
        transferir datos entre el frontend y el backend, en archivos de configuración, en juegos, en editores de texto
        y en muchas otras áreas.*/
        /*ejemplos:
        {
        "name": "Dale",
        "age": 7
        }
        * */
    }

    /*Representando un objeto Java como JSON
    Ahora tomemos un objeto Java y veamos cómo se ve como JSON.
    Primero, definamos una clase:*/
    public class Human{

        String name;
        boolean male;
        int age;
        Set<Human> parents;

        public Human(String name, boolean male, int age) {
            this.name = name;
            this.male = male;
            this.age = age;
        }

        //Objeto:
        /*
        Human father = new Human("Peter", true, 31);
        Human mother = new Human("Mary", false, 28);
        mother.parents = new HashSet<>();
        Human son = new Human("Paul", true, 7);
        son.parents = Set.of(father, mother);
        */

        //Y ahora tratemos de representar el son objeto con la mayor precisión posible en formato JSON:
        /*
        {
            "name": "Paul",
            "male": true,
            "age": 7,
            "parents": [
            {
                "name": "Pedro",
                "male": true,
                "age": 31,
                "parents": null
            },
            {
                "name": "Maria",
                "male": false,
                "age": 28,
                "parents": null
            }
        ]
        }
        */

    }
}
