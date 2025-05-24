package org.educatiom.lesson20_ProyectoFinalModulo2.seresvivos;

import org.educatiom.lesson20_ProyectoFinalModulo2.modelo.Isla;
import org.educatiom.lesson20_ProyectoFinalModulo2.modelo.Ubicacion;

/**
 * Representa una especie de Boa en la simulación, extendiendo las capacidades de un {@link Carnivoro}.
 * Define las características específicas de las boas como su peso, límite por ubicación,
 * velocidad máxima, comida necesaria y su representación Unicode.
 */
public class Boa extends Carnivoro{

    private static final double PESO_DEFECTO = 15;
    private static final int MAX_POR_UBICACION_DEFECTO = 30;
    private static final int VELOCIDAD_MAX_DEFECTO = 1;
    private static final double COMIDA_NECESARIA_DEFECTO = 3;
    private static final String UNICODE = "🐍";

    /**
     * Constructor para crear una nueva instancia de Boa.
     * Inicializa la Boa con los valores por defecto de peso, máximo por ubicación,
     * velocidad máxima y comida necesaria, y establece su especie.
     */
    public Boa() {
        super(PESO_DEFECTO, MAX_POR_UBICACION_DEFECTO, VELOCIDAD_MAX_DEFECTO, COMIDA_NECESARIA_DEFECTO);
    }

    /**
     * Define el comportamiento de alimentación de una Boa.
     * Actualmente, solo imprime un mensaje indicando que la Boa intenta comer.
     * La lógica específica de depredación y consumo de presas debería implementarse aquí
     * o delegarse a la superclase {@link Carnivoro}.
     *
     * @param ubicacionActual La {@link Ubicacion} actual de la Boa.
     * @param isla La {@link Isla} en la que se encuentra la Boa.
     */
    @Override
    public void comer(Ubicacion ubicacionActual, Isla isla) {
        System.out.println("la Boa " + this.hashCode() + " está intentando comer en " + ubicacionActual);
        super.comer(ubicacionActual, isla); // Llama a la lógica de comer de Carnivoro
    }

    /**
     * Define el comportamiento de movimiento de una Boa.
     * Actualmente, solo imprime un mensaje indicando que la Boa intenta moverse.
     * La lógica real de movimiento debería delegarse a la superclase {@link Animal}.
     *
     * @param ubicacionActual La {@link Ubicacion} actual de la Boa.
     * @param isla La {@link Isla} en la que se encuentra la Boa.
     */
    @Override
    public void moverse(Ubicacion ubicacionActual, Isla isla) {
        System.out.println("la Boa " + this.hashCode() + " está intentando moverse desde " + ubicacionActual);
        super.moverse(ubicacionActual, isla); // Llama a la lógica de movimiento de Animal
    }

    /**
     * Define el comportamiento de reproducción de una Boa.
     * Una Boa intenta reproducirse si hay al menos dos Boas en la misma ubicación
     * y la ubicación tiene espacio para una nueva cría de Boa.
     *
     * @param ubicacionActual La {@link Ubicacion} actual donde la Boa intenta reproducirse.
     * @return Una nueva instancia de {@link Boa} si la reproducción es exitosa, de lo contrario, {@code null}.
     */
    @Override
    public Animal reproducirse(Ubicacion ubicacionActual) {
        System.out.println("La Boa " + this.hashCode() + " está intentando reproducirse en " + ubicacionActual);

        // Se verifica que la boa no tenga demasiada hambre para reproducirse.
        if (this.getNivelHambre() >= this.getComidaNecesaria() * 0.5) {
            return null; // Una boa hambrienta no se reproduce.
        }

        long boasPresentes = ubicacionActual.contarAnimalesDeEspecie(this.getEspecie());
        if (boasPresentes >= 2 && ubicacionActual.puedeAgregarAnimal(this.getEspecie(), this.maxPorUbicacion)) {
            return new Boa();
        }
        return null;
    }

    /**
     * Obtiene el carácter Unicode que representa a una Boa.
     *
     * @return El String Unicode para una Boa.
     */
    @Override
    public String getUnicode() {
        return UNICODE;
    }
}
