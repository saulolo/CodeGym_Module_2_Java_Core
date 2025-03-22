package org.educatiom.lesson08_LlamadoAConstructores;

import java.util.HashMap;
import java.util.Map;

public class BloqueEstaticoExample {

    public static Map<Double, String> labels = new HashMap<>();

    static {
        labels.put(2.0, "Guns and Roses");
        labels.put(1.0, "Bad Criminal");
        labels.put(4.3, "La Rubia del Cabaret");
        labels.put(3.6, "Nirvana");
        labels.put(2.3, "Mañana si");
    }



    public static void main(String[] args) {

        System.out.println("--------------------- Bloque de iniciación estático ---------------------");
        //Bloque de iniciación estático
        /*Si necesita ejecutar código complejo (por ejemplo, cargar algo desde un archivo) para inicializar objetos,
        podemos hacerlo en un constructor. Sin embargo, las variables estáticas no tienen esta oportunidad. Pero dado
        que la necesidad aún persiste, puede agregue un bloque o bloques de inicialización estáticos a las clases. Son
        básicamente equivalentes a los constructores estáticos*/

        System.out.println(labels);
    }
}
