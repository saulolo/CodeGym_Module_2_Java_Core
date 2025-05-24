package org.educatiom.lesson20_ProyectoFinalModulo2.utilidades;

import java.util.HashMap;
import java.util.Map;

/**
 * Una clase de utilidad que almacena y proporciona las probabilidades de que un depredador
 * se coma a una presa específica en la simulación.
 * Las probabilidades se definen como un porcentaje (0-100).
 */
public class TablaProbabilidades {

    /**
     * Un mapa anidado que almacena las probabilidades de comer.
     * La clave exterior es la especie del depredador (String).
     * El mapa interior tiene como clave la especie de la presa (String) y como valor
     * la probabilidad de que el depredador la coma (Integer).
     */
    private static final Map<String, Map<String, Integer>> PROBABILIDADES_COMER = new HashMap<>();


     //Bloque estático que inicializa la tabla de probabilidades de comer cuando la clase es cargada.
     //Aquí se definen las interacciones de depredación entre las diferentes especies de animales.
     static {
         // Probabilidades de lo que come un Lobo.
         Map<String, Integer> loboProb = new HashMap<>();
         loboProb.put("Caballo", 10);
         loboProb.put("Ciervo", 15);
         loboProb.put("Conejo", 60);
         loboProb.put("Raton", 80);
         loboProb.put("Cabra", 60);
         loboProb.put("Oveja", 70);
         loboProb.put("Jabali", 15);
         loboProb.put("Bufalo", 10);
         loboProb.put("Pato", 40);
         PROBABILIDADES_COMER.put("Lobo", loboProb);

         // Probabilidades de lo que come una Boa.
         Map<String, Integer> boaProb = new HashMap<>();
         boaProb.put("Zorro", 15);
         boaProb.put("Conejo", 20);
         boaProb.put("Raton", 40);
         boaProb.put("Pato", 10);
         PROBABILIDADES_COMER.put("Boa", boaProb);

         // Probabilidades de lo que come un Zorro.
         Map<String, Integer> zorroProb = new HashMap<>();
         zorroProb.put("Conejo", 70);
         zorroProb.put("Raton", 90);
         zorroProb.put("Pato", 60);
         zorroProb.put("Oruga", 40);
         PROBABILIDADES_COMER.put("Zorro", zorroProb);

         // Probabilidades de lo que come un Oso.
         Map<String, Integer> osoProb = new HashMap<>();
         osoProb.put("Boa", 80);
         osoProb.put("Caballo", 40);
         osoProb.put("Ciervo", 80);
         osoProb.put("Conejo", 80);
         osoProb.put("Raton", 90);
         osoProb.put("Cabra", 70);
         osoProb.put("Oveja", 70);
         osoProb.put("Jabali", 50);
         osoProb.put("Bufalo", 20);
         PROBABILIDADES_COMER.put("Oso", osoProb);

         // Probabilidades de lo que come un Aguila.
         Map<String, Integer> aguilaProb = new HashMap<>();
         aguilaProb.put("Zorro", 10);
         aguilaProb.put("Conejo", 90);
         aguilaProb.put("Raton", 90);
         aguilaProb.put("Pato", 80);
         PROBABILIDADES_COMER.put("Aguila", aguilaProb);
     }

    /**
     * Obtiene la probabilidad de que un depredador de una especie dada coma a una presa de otra especie dada.
     * Si no se encuentra una probabilidad específica, se retorna 0 (lo que implica que no hay interacción de depredación).
     *
     * @param depredadorEspecie El nombre de la especie del animal depredador.
     * @param presaEspecie El nombre de la especie del animal que podría ser la presa.
     * @return Un valor entero que representa la probabilidad (en porcentaje) de que el depredador
     * coma a la presa, o 0 si no hay una probabilidad definida.
     */
    public static int getProbabilidad(String depredadorEspecie, String presaEspecie) {
        Map<String, Integer> presas = PROBABILIDADES_COMER.get(depredadorEspecie);
        if (presas != null) {
            return presas.getOrDefault(presaEspecie, 0); // Retorna 0 si la presa no está en la lista del depredador.
        }
        return 0; // Retorna 0 si el depredador no está en la tabla.
    }

}
