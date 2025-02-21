package org.educatiom.lesson06_FuncionesLambdaYStreams.FuncionesLambdaPrincipales;

import java.util.function.Consumer;
import java.util.stream.Stream;

public class ConsumerExample {

    public static void main(String[] args) {


        System.out.println("------------------ Consumer -----------------------");
        //Consumer
        /*Recibe un (1)valor(parametro) y no retorna (2)nada.*/
/*        Consumer<String> consumer = (param) -> {
            System.out.println(param);
        };*/
        Consumer<String> consumer = System.out::println; /*Es lo mismo que el anterior ya que llamamos al method que esta
        que esta utilizando ese argumento.*/

        consumer.accept("Soy un consumer."); //(1) Recibe el valor: "Soy un consumer.
        //(2)No retorna nada: No tiene la palabra return dentro de la función.
    }
}
