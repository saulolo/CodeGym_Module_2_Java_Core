package org.educatiom.lesson06_FuncionesLambdaYStreams;

import java.util.*;
import java.util.stream.Collectors;

public class CollectorsExample {

    public static void main(String[] args) {

        System.out.println("--------------------- Collectors---------------------------");
        //Collectors
        /*tiene varios métodos estáticos que devuelven objetos de colección listos para usar, algo para cada ocasión.*/


        System.out.println("--------------------- toList() ---------------------------");
        //toList()
        /*Un objeto que convierte un stream en una lista (List<T>).*/
        ArrayList<String> list = new ArrayList<String>();
        Collections.addAll(list, "Hello", "how's", "life?");

        List<String> result = list.stream()
                .filter( s -> Character.isUpperCase(s.charAt(0)) )
                .toList();
        System.out.println("result = " + result);;

        System.out.println("--------------------- toSet() ---------------------------");
        //toSet()
        /*Un objeto que convierte un stream en un set (Set<T>).*/
        ArrayList<String> list1 = new ArrayList<>();
        Collections.addAll(list1,"Hello", "how's", "life?");

        Set<String> stringSet = list1.stream()
                .filter(s -> Character.isUpperCase(s.charAt(0)))
                .collect(Collectors.toSet());

        System.out.println("stringSet = " + stringSet);

        System.out.println("--------------------- toMap() ---------------------------");
        //toMap()
        /*Un objeto que convierte un stream en un map ( Map<K, V>).*/
        ArrayList<String> list2 = new ArrayList<String>();
        Collections.addAll(list, "a=2", "b=3", "c=4", "d==3");

        Map<String, String> stringMap = list2.stream()
                .map( e -> e.split("=") )
                .filter( e -> e.length == 2 )
                .collect( Collectors.toMap(e -> e[0], e -> e[1]) );

        System.out.println("stringMap = " + stringMap);

        System.out.println("--------------------- joining() ---------------------------");
        //joining()
        /*Concatena los elementos de una secuencia en una sola cadena.*/
        ArrayList<String> list3 = new ArrayList<>();
        Collections.addAll(list3, "a=2", "b=3", "c=4", "d==3");
        String result6 = list3.stream().collect(Collectors.joining(", "));
        System.out.println("result6 = " + result6);

        System.out.println("--------------------- mapping() ---------------------------");
        //mapping()
        /*Convierte los elementos de una cadena en unMap<K, V>.*/

        System.out.println("--------------------- groupingBy() ---------------------------");
        //mapping()
        /*Agrupa los elementos y devuelve Map<K, V>*/

    }
}
