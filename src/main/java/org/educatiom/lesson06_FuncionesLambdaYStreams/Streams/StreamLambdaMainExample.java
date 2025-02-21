package org.educatiom.lesson06_FuncionesLambdaYStreams.Streams;

import java.util.Arrays;
import java.util.List;

public class StreamLambdaMainExample {

    public static void main(String[] args) {

        List<String> names = Arrays.asList("Saul", "Felipe", "Eliany", "Saul", "Alejandra", "Leidy","Saul", "Diego");

        System.out.println("1.Imprimiendo por bucles");
        System.out.println(names); //Imprimiendo por bucles

        System.out.println("\n------------- 2. forEach() --------------");
        //Operador final que aplica una acción a cada elemento.

        /*A partir de la version 17 de java no necesito poner .Stream, ya lo convierte implicitamente a un stream cuando
        llamo al foreach. La forma explcita seria asi:
        names.stream()
                  .forEach((name) -> System.out.println(name));
        */
        names.forEach(System.out::println); //Imprimiendo con stream.

        System.out.println("\n------------- 3. filter() ---------------");
        //Operador intermedio que filtra los elementos de cumplen una condición.
        names.stream()
                .filter((name) -> name.length() > 5) //Solo pasan los nombres con mas de 5 caracteres
                .forEach(System.out::println);

        System.out.println("\n------------- 4. map() ---------------");
        //Operador intermedio que transforma los elementos aplicando una función.
        names.stream()
                .map(String::toUpperCase) //Convierte el stream recibo en mayúsculas.
                .filter((name) -> name.startsWith("F")) //Si quiero utilizo otro perador intermedio con filter.
                .forEach(System.out::println);

        System.out.println("\n------------- 5. sorted() ---------------");
        //Operador intermedio que ordena los elementos del stream.
        names.stream()
                .sorted()
                .forEach(System.out::println);

        System.out.println("\n------------- 6. reduce() ---------------");
        //Operador intermedio que combina todos los elementos en un solo valor o sea me convierte un array en un string por asi decirlo.
        String result = names.stream()
                .reduce("Resultado:", (nameA,nameB) -> nameA + " " + nameB);
        System.out.println(result);

        System.out.println("\n------------- 7. reduce() con isPresent() ---------------");
        //Operador final que valida Si hay un valor presente, realiza la acción dada con el valor, de lo contrario no hace nada.
        names.stream()
                .reduce((nameA,nameB) -> nameA + " " + nameB)
                .ifPresent(System.out::println);

        System.out.println("\n------------- 8. collect() ---------------");
        //Operador intermedio que eecoge los elementos en una colección.
        names.stream()
                .map(String::toUpperCase)
                .toList() // .collect(Collectors.toList()) ==> Crea una nueva lista a partir del stream anterior convertido a mayusculas.
                //A partir de java 17 se obvia el operador collect.
                .forEach(System.out::println);

        System.out.println("\n------------- 9. distinct() ---------------");
        //Operador intermedio que elimina los elementos duplicados.
        names.stream()
                .distinct()
                .forEach(System.out::println);

        System.out.println("\n------------- 10. limit() ---------------");
        //Operador intermedio que limita el número de elementos procesados.
        names.stream()
                .limit(3)
                .forEach(System.out::println);

        System.out.println("\n------------- 11. skip() ---------------");
        //Operador intermedio que omite un número especifico de elementos.
        names.stream()
                .skip(2)
                .forEach(System.out::println);

        System.out.println("\n------------- 12. anyMatch() ---------------");
        //Operador final que verifica si algun elemento cumple una condición.

        boolean result2 = names.stream().anyMatch((name) -> name.startsWith("S"));

        System.out.println(result2);

        System.out.println("\n------------- 13. allMatch() ---------------");
        //Operador final que verifica si todos los elementos cumplen una condición.
        boolean result3 = names.stream().allMatch((name) -> name.startsWith("A"));
        System.out.println(result3);

        System.out.println("\n------------- 14. noneMatch() ---------------");
        //Operador final que verifica si ningún elemento cumplen una condición.
        boolean result4 = names.stream().noneMatch((name) -> name.startsWith("E"));
        System.out.println(result4);

    }
}
