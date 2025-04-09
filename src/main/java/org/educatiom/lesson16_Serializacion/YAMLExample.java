package org.educatiom.lesson16_Serializacion;

import java.util.Date;
import java.util.List;
import java.util.Set;

public class YAMLExample {

    public static void main(String[] args) {

        System.out.println("--------- YAML ----------");
        //YAML
        /*Otro formato de datos de texto es YAML ( Y Yet Another Markup Language ; más tarde, YAML Ain't Markup Language).
        Se utiliza para serializar objetos para su transmisión a través de la red (al igual que XML y JSON se utilizan
        de esta manera).
        Debido a que es legible por humanos, también se usa para escribir archivos de configuración, por ejemplo, para
        Docker, Kubernetes, Ansible, etc. Cuando es necesario guardar YAML en un archivo (por ejemplo, un archivo de
        configuración), usamos uno de dos extensiones: .yaml o .yml.
        Los datos se almacenan como pares clave-valor, donde la clave es una cadena y el valor puede ser de varios
        tipos de datos (cadena, número, verdadero/falso, matriz, etc.). Las claves se escriben sin comillas.
        Ejemplo:
        */

    }

    class Family {
        private Date weddingDate;
        private Person wife;
        private Person husband;
        private List<Person> children;

        // Getters and setters are omitted
    }

    class Person {
        private final String name;
        private final boolean isWoman;
        private int age;

        public Person(String name, int age, boolean isWoman) {
            this.name = name;
            this.age = age;
            this.isWoman = isWoman;
        }

// Getters and setters are omitted

    }
    //Objetos
/*    Person wife = new Person("Ann", 37, true);
    Person husband = new Person("Alex", 40, false);
        var children = List.of(
                new Person("Iris", 12, true),
                new Person("Olivia", 5, true)
        );
        Date weddingDate = new Date(*//* some long *//*);

        Family family = new Family();
        family.setWeddingDate(weddingDate);
        family.setWife(wife);
        family.setHusband(husband);
        family.setChildren(children);*/

    //Representación válida en YAML:
    /*
    ---
    fecha de la boda: 2000-12-03
    esposa:
     nombre: Ann
     edad: 37
     es mujer: sí
    esposo:
     nombre: Alex
     edad: 40
     es mujer: sin
    hijos:
     - nombre: Iris
       edad: 12
       es mujer: verdadero
     - nombre: Olivia
       edad: 5
       esMujer: cierto
    ---
    * */

}
