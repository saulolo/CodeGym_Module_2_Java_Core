package org.educatiom.lesson06_FuncionesLambdaYStreams.Streams;

import java.util.ArrayList;
import java.util.Collections;
import java.util.stream.Stream;

public class StreamExample {

    public static void main(String[] args) {

        System.out.println("--------------------- Stream con Lambdas ---------------------------");
        //Stream con Lambdas
        /* La clase Stream<T> tiene métodos que devuelven nuevos objetos Stream. Cada uno de estos flujos de datos
        realiza una acción simple, pero si los combina en cadenas y agrega funciones lambda interesantes , entonces
        tiene un mecanismo poderoso para generar el resultado que desea.
        Nota: un stream es un flujo de datos que va pasando como por una cinta transportadora y que vamos operando con
        cada elemento.

        Cuando trabajamos con Stream tenemos operadores finales (terminan el flujo) e intermedios (despues de operar con
        él se continua el flujo.*/


        System.out.println("--------------------- CREACIÓN DE STREAMS ---------------------------");

        System.out.println("--------------------- of() ---------------------------");
        //of()
        /*Crea una secuencia a partir de un conjunto de objetos.
        * Ej:*/
        Stream<Integer> stream = Stream.of(1, 2, 3); //Se permite pasar cualquier cantidad de elementos.

        System.out.println("--------------------- generate() ---------------------------");
        //generate()
        /*Genera un flujo de acuerdo con la regla especificada. e permite establecer una regla que se utilizará para
        generar el siguiente elemento de la secuencia cuando se solicite. Por ejemplo, puede dar un número aleatorio
        cada vez Ej:*/
        Stream<Double> stream1 = Stream.generate(Math::random);

        System.out.println("--------------------- concat() ---------------------------");
        //concat()
        /*Concatena dos flujos.Concatena los dos flujos pasados en uno Ej:*/
        Stream<Integer> stream2 = Stream.of(7, 8, 9);
        Stream<Integer> concatenar = Stream.concat(stream, stream2);

        System.out.println("--------------------- FILTRADO DE STREAMS ---------------------------");
        System.out.println("--------------------- filter() ---------------------------");
        //filter()
        /*Filtra los datos, solo pasa los datos que coinciden con la regla especificada.
        * Este method devuelve un nuevo flujo de datos que filtra el flujo de datos de origen de acuerdo con la regla
        * aprobada. Puede especificar la regla de filtrado mediante una función lambda , que luego el compilador
        * convertirá en un objeto Predicate<T>. Ej: */
        Stream<Integer> filtrar = stream.filter(x -> (x < 3)); //Conservar solo números menores de tres
        System.out.println("filtrar = " + filtrar);

        System.out.println("--------------------- distinct() ---------------------------");
        //distinct()
        /*Elimina duplicados. No transmite datos que ya se han encontrado.
        * Este method devuelve un nuevo flujo de datos que contiene solo los elementos únicos en el flujo de datos de
         * origen . Todos los datos duplicados se descartan. Ejemplo:*/
        Stream<Integer> stream4 = Stream.of(1, 2, 3, 4, 5, 2, 2, 2, 3, 4);
        Stream<Integer> noRepeat = stream4.distinct(); // 1, 2, 3, 4, 5

        System.out.println("--------------------- sorted() ---------------------------");
        //sorted()
        /*Ordena los datos.
        * Este method devuelve un nuevo flujo de datos que ordena los datos en el flujo de origen . Pasa un comparador,
         * que establece las reglas para comparar dos elementos del flujo de datos.*/
        Stream<Integer> stream3 = Stream.of(1, 4, 6, 4, 3, 2, 6, 1, 5);
        Stream<Integer> organizer = stream3.sorted();

        System.out.println("--------------------- peek() ---------------------------");
        //peek()
        /*Realiza una acción en cada elemento de la secuencia.
        * Este method devuelve un nuevo flujo de datos , aunque los datos que contiene son los mismos que los del flujo
        * de origen. Pero cuando se solicita el siguiente elemento de la secuencia, se llama a la función que pasó al
        * method.peek()*/

        System.out.println("--------------------- limit() ---------------------------");
        //limit()
        /*Devuelve una secuencia que se trunca para que no supere el límite especificado.
        * Este method devuelve un nuevo flujo de datos que contiene solo los primeros nelementos del flujo de datos de
        * origen . Todos los demás datos se descartan. Ejemplo:*/
        Stream<Integer> theLimit = stream3.limit(3); //1, 4, 6

        System.out.println("--------------------- skip() ---------------------------");
        //skip()
        /*Salta los primeros n elementos.
        * Este method devuelve un nuevo flujo de datos que contiene todos los mismos elementos que el flujo de origen ,
        * pero omite (ignora) los primeros nelementos. Ejemplo:*/
        Stream<Integer> theSkip = stream3.skip(2); //1, 4

        System.out.println("--------------------- CONVERSIÓN DE/A STREAMS ---------------------------");
        System.out.println("--------------------- map() ---------------------------");
        //map()
        /*Convierte datos de un tipo a otro. Este method toma como argumento de method una función que convierte un tipo
        de datos en otro.*/
        Stream<String> converStream = stream3.map(String::valueOf); //Convierete un Integer stream a un stream de tipo String.

        //Convertir una cadena en un número
        Stream<Integer> stream5 = Stream.of(1, 2, 3, 4, 5);
        Stream<String> stream6 = stream5.map(String::valueOf);
        Stream<Integer> stream7 = stream6.map(Integer::parseInt);

        System.out.println("--------------------- flatMap() ---------------------------");
        //flatMap()
        /*Convierte datos de un tipo a otro.*/

        System.out.println("--------------------- COMPROBACIÓN ---------------------------");
        System.out.println("--------------------- anyMatch() ---------------------------");
        //anyMatch()
        /*Comprueba si hay al menos un elemento en la transmisión que coincida con la regla especificada.*/
        boolean result = stream3.anyMatch((num) -> num >3);

        System.out.println("--------------------- allMatch() ---------------------------");
        //allMatch()
        /*Comprueba si todos los elementos de la secuencia coinciden con la regla especificada.*/
        boolean result2 = stream3.allMatch((num) -> num >2);

        System.out.println("--------------------- noneMatch() ---------------------------");
        //noneMatch()
        /*Comprueba si ninguno de los elementos de la secuencia coincide con la regla especificada.*/
        boolean result3 = stream3.noneMatch((num) -> num >6);

        System.out.println("--------------------- ENCONTRAR MÉTODOS ---------------------------");
        System.out.println("--------------------- Optional<T> findFirst() ---------------------------");
        //Optional<T> findFirst()
        /*Devuelve el primer elemento encontrado que coincide con la regla.
        * Nota: el method no devuelve un objeto T, sino un objeto contenedor Optional<T> para asegurar que nuna regrese
        * un null.*/
        ArrayList<String> list = new ArrayList<>();
        Collections.addAll(list, "Hola", "soy", "un", "findFirst");
        String result4 = list.stream().findFirst().get();
        System.out.println("result4 = " + result4);


        System.out.println("--------------------- Optional<T> findAny() ---------------------------");
        //Optional<T> findAny()
        /*Devuelve cualquier elemento en la transmisión que coincida con la regla y termina allí, es similar a
        findFirst(), pero es ideal para flujos que se usan en operaciones paralelas, Al procesar flujos en paralelo, es
        posible que ya se haya encontrado un elemento en alguna parte de un flujo, pero aún no está claro si es el
        primero o no*/
        Collections.addAll(list, "Hola", "ahora", "soy", "un", "findAny");
        String result5 = list.stream().min((s1, s2) -> s1.length() - s2.length()).get(); //Tambien aplica para max.
        System.out.println("result5 = " + result5);

        System.out.println("--------------------- Optional<T> min() ---------------------------");
        //Optional<T> min()
        /*	Busca el elemento mínimo en el flujo de datos.*/

        System.out.println("--------------------- Optional<T> max() ---------------------------");
        //Optional<T> max()
        /*Devuelve el elemento máximo en el flujo de datos.*/

        System.out.println("--------------------- long count() ---------------------------");
        //long count()
        /*Devuelve el número de elementos en el flujo de datos.*/

        System.out.println("--------------------- ELEMENTOS DE RECOGIDA ---------------------------");
        System.out.println("--------------------- R collect() ---------------------------");
        //R collect()
        /*Lee todos los datos de la secuencia y los devuelve como una colección.
        * Este objeto lee todos los datos del flujo, los convierte en un tipo específico de colección y los devuelve.
        * Y luego el propio method de recopilación devuelve esta colección.*/

    }
}
