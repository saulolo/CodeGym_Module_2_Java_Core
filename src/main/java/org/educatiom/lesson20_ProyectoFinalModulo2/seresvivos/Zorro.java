package org.educatiom.lesson20_ProyectoFinalModulo2.seresvivos;

import org.educatiom.lesson20_ProyectoFinalModulo2.modelo.Isla;
import org.educatiom.lesson20_ProyectoFinalModulo2.modelo.Ubicacion;

/**
 * Representa una especie de Zorro en la simulación, extendiendo las capacidades de un {@link Carnivoro}.
 * Define las características específicas de los zorros como su peso, límite por ubicación,
 * velocidad máxima, comida necesaria y su representación Unicode.
 */
public class Zorro extends Carnivoro{

    private static final double PESO_DEFECTO = 8;
    private static final int MAX_POR_UBICACION_DEFECTO = 30;
    private static final int VELOCIDAD_MAX_DEFECTO = 2;
    private static final double COMIDA_NECESARIA_DEFECTO = 2;
    private static final String UNICODE = "🦊";

    /**
     * Constructor para crear una nueva instancia de Zorro.
     * Inicializa el Zorro con los valores por defecto de peso, máximo por ubicación,
     * velocidad máxima y comida necesaria, y establece su especie.
     */
    public Zorro() {
        super(PESO_DEFECTO, MAX_POR_UBICACION_DEFECTO, VELOCIDAD_MAX_DEFECTO, COMIDA_NECESARIA_DEFECTO);
    }

    /**
     * Define el comportamiento de alimentación de un Zorro.
     * Actualmente, solo imprime un mensaje indicando que el Zorro está intentando comer.
     * La lógica específica de depredación y consumo de presas debería delegarse a la superclase {@link Carnivoro}.
     *
     * @param ubicacionActual La {@link Ubicacion} actual del Zorro.
     * @param isla La {@link Isla} en la que se encuentra el Zorro.
     */
    @Override
    public void comer(Ubicacion ubicacionActual, Isla isla) {
        System.out.println("El Zorro " + this.hashCode() + " está intentando comer en " + ubicacionActual);
        super.comer(ubicacionActual, isla); // Llama a la lógica de comer de Carnivoro
    }

    /**
     * Define el comportamiento de movimiento de un Zorro.
     * Actualmente, solo imprime un mensaje indicando que el Zorro está intentando moverse.
     * La lógica real de movimiento debería delegarse a la superclase {@link Animal}.
     *
     * @param ubicacionActual La {@link Ubicacion} actual del Zorro.
     * @param isla La {@link Isla} en la que se encuentra el Zorro.
     */
    @Override
    public void moverse(Ubicacion ubicacionActual, Isla isla) {
        System.out.println("El Zorro " + this.hashCode() + " está intentando moverse desde " + ubicacionActual);
        super.moverse(ubicacionActual, isla); // Llama a la lógica de movimiento de Animal
    }

    /**
     * Define el comportamiento de reproducción de un Zorro.
     * Un Zorro intenta reproducirse si hay al menos dos Zorros en la misma ubicación
     * y la ubicación tiene espacio para una nueva cría de Zorro.
     *
     * @param ubicacionActual La {@link Ubicacion} actual donde el Zorro intenta reproducirse.
     * @return Una nueva instancia de {@link Zorro} si la reproducción es exitosa, de lo contrario, {@code null}.
     */
    @Override
    public Animal reproducirse(Ubicacion ubicacionActual) {
        System.out.println("El Zorro " + this.hashCode() + " está intentando reproducirse en " + ubicacionActual);

        // Se verifica que el zorro no tenga demasiada hambre para reproducirse.
        if (this.getNivelHambre() >= this.getComidaNecesaria() * 0.5) {
            return null; // Un zorro hambriento no se reproduce.
        }

        long zorrosPresentes = ubicacionActual.contarAnimalesDeEspecie(this.getEspecie());
        // Si hay al menos dos zorros y la ubicación puede aceptar más de esta especie.
        if (zorrosPresentes >= 2 && ubicacionActual.puedeAgregarAnimal(this.getEspecie(), this.maxPorUbicacion)) {
            return new Zorro(); // Retorna una nueva cría de Zorro.W
        }
        return null; // No se reproduce.
    }

    /**
     * Obtiene el carácter Unicode que representa a un Zorro.
     *
     * @return El String Unicode para un Zorro.
     */
    @Override
    public String getUnicode() {
        return UNICODE;
    }
}
