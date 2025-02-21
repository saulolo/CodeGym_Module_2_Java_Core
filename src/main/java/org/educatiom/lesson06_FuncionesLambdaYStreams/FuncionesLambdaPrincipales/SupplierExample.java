package org.educatiom.lesson06_FuncionesLambdaYStreams.FuncionesLambdaPrincipales;

import java.util.function.BiConsumer;
import java.util.function.Supplier;

public class SupplierExample {

    public static void main(String[] args) {

        System.out.println("------------------ Supplier -----------------------");
        //Supplier
        /*No recibe ningun valor pero retorna un resultado.*/
        Supplier<String> supplier = () -> "Hola, soy un supplier";

        System.out.println(supplier.get());
    }
}
