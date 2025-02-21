package org.educatiom.lesson06_FuncionesLambdaYStreams.FuncionesLambdaPrincipales;

import java.util.Comparator;
import java.util.function.Consumer;

public class ComparatorExample {

    public static void main(String[] args) {


        System.out.println("------------------ Comparator -----------------------");
        //Comparator
        /*Compara dos objetos de tipo T y devuelve un int indicando el orden.*/
        Comparator<String> compararPorLongitud = Comparator.comparingInt(String::length);

         /*Es lo mismo que el anterior ya que llamamos al method que esta
        que esta utilizando ese argumento.*/
        System.out.println(compararPorLongitud.compare("Eliany", "Saul"));
        }
    }
