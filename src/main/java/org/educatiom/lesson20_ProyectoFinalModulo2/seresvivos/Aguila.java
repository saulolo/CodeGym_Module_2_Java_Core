package org.educatiom.lesson20_ProyectoFinalModulo2.seresvivos;

import org.educatiom.lesson20_ProyectoFinalModulo2.modelo.Isla;
import org.educatiom.lesson20_ProyectoFinalModulo2.modelo.Ubicacion;

/**
 * Representa una especie de Águila en la simulación, extendiendo las capacidades de un {@link Carnivoro}.
 * Define las características específicas de las águilas como su peso, límite por ubicación,
 * velocidad máxima, comida necesaria y su representación Unicode.
 */
public class Aguila extends Carnivoro{

    private static final double PESO_DEFECTO = 6;
    private static final int MAX_POR_UBICACION_DEFECTO = 20;
    private static final int VELOCIDAD_MAX_DEFECTO = 3;
    private static final double COMIDA_NECESARIA_DEFECTO = 1;
    private static final String UNICODE = "🦅";

    /**
     * Constructor para crear una nueva instancia de Águila.
     * Inicializa el Águila con los valores por defecto de peso, máximo por ubicación,
     * velocidad máxima y comida necesaria, y establece su especie.
     */
    public Aguila() {
        super(PESO_DEFECTO, MAX_POR_UBICACION_DEFECTO, VELOCIDAD_MAX_DEFECTO, COMIDA_NECESARIA_DEFECTO);
    }

    /**
     * Define el comportamiento de alimentación de un Águila.
     * Actualmente, solo imprime un mensaje indicando que el Águila intenta comer.
     * La lógica específica de depredación y consumo de presas debería implementarse aquí
     * o delegarse a la superclase {@link Carnivoro}.
     *
     * @param ubicacionActual La {@link Ubicacion} actual del Águila.
     * @param isla La {@link Isla} en la que se encuentra el Águila.
     */
    @Override
    public void comer(Ubicacion ubicacionActual, Isla isla) {
        // Lógica de comer de Carnivoro debería ser llamada o implementada aquí
        System.out.println("La Águila " + this.hashCode() + " está intentando comer en " + ubicacionActual);
        super.comer(ubicacionActual, isla); // Llama a la lógica de comer de Carnivoro
    }

    /**
     * Define el comportamiento de movimiento de un Águila.
     * Actualmente, solo imprime un mensaje indicando que el Águila intenta moverse.
     * La lógica real de movimiento debería delegarse a la superclase {@link Animal}.
     *
     * @param ubicacionActual La {@link Ubicacion} actual del Águila.
     * @param isla La {@link Isla} en la que se encuentra el Águila.
     */
    @Override
    public void moverse(Ubicacion ubicacionActual, Isla isla) {
        System.out.println("La Águila " + this.hashCode() + " está intentando moverse desde " + ubicacionActual);
        super.moverse(ubicacionActual, isla); // Llama a la lógica de movimiento de Animal
    }

    /**
     * Define el comportamiento de reproducción de un Águila.
     * Un Águila intenta reproducirse si hay al menos dos Águilas en la misma ubicación
     * y la ubicación tiene espacio para una nueva cría de Águila.
     *
     * @param ubicacionActual La {@link Ubicacion} actual donde el Águila intenta reproducirse.
     * @return Una nueva instancia de {@link Aguila} si la reproducción es exitosa, de lo contrario, {@code null}.
     */
    @Override
    public Animal reproducirse(Ubicacion ubicacionActual) {
        System.out.println("La Águila " + this.hashCode() + " está intentando reproducirse en " + ubicacionActual);

        // Se verifica que el águila no tenga demasiada hambre para reproducirse.
        if (this.getNivelHambre() >= this.getComidaNecesaria() * 0.5) {
            return null; // Un águila hambrienta no se reproduce.
        }

        // Cuenta la cantidad de águilas en la ubicación actual.
        long aguilasPresentes = ubicacionActual.contarAnimalesDeEspecie(this.getEspecie());

        if (aguilasPresentes >= 2 && ubicacionActual.puedeAgregarAnimal(this.getEspecie(), this.maxPorUbicacion)) {
            return new Aguila(); // Retorna una nueva cría de Águila.
        }
        return null; // No se reproduce.
    }

    /**
     * Obtiene el carácter Unicode que representa a un Águila.
     *
     * @return El String Unicode para un Águila.
     */
    @Override
    public String getUnicode() {
        return UNICODE;
    }
}
