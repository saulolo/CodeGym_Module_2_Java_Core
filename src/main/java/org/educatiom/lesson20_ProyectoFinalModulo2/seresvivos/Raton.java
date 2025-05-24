package org.educatiom.lesson20_ProyectoFinalModulo2.seresvivos;

import org.educatiom.lesson20_ProyectoFinalModulo2.modelo.Isla;
import org.educatiom.lesson20_ProyectoFinalModulo2.modelo.Ubicacion;

/**
 * Representa una especie de Ratón en la simulación, extendiendo las capacidades de un {@link Carnivoro}.
 * Define las características específicas de los ratones como su peso, límite por ubicación,
 * velocidad máxima, comida necesaria y su representación Unicode.
 */
public class Raton extends Carnivoro{

    private static final double PESO_DEFECTO = 0.05;
    private static final int MAX_POR_UBICACION_DEFECTO = 500;
    private static final int VELOCIDAD_MAX_DEFECTO = 1;
    private static final double COMIDA_NECESARIA_DEFECTO = 0.01;
    private static final String UNICODE = "🐁";

    /**
     * Constructor para crear una nueva instancia de Ratón.
     * Inicializa el Ratón con los valores por defecto de peso, máximo por ubicación,
     * velocidad máxima y comida necesaria, y establece su especie.
     */
    public Raton() {
        super(PESO_DEFECTO, MAX_POR_UBICACION_DEFECTO, VELOCIDAD_MAX_DEFECTO, COMIDA_NECESARIA_DEFECTO);
    }
    /**
     * Define el comportamiento de alimentación de un Ratón.
     * Actualmente, solo imprime un mensaje indicando que el Ratón está intentando comer.
     * La lógica específica de depredación y consumo de presas debería delegarse a la superclase {@link Carnivoro}.
     *
     * @param ubicacionActual La {@link Ubicacion} actual del Ratón.
     * @param isla La {@link Isla} en la que se encuentra el Ratón.
     */
    @Override
    public void comer(Ubicacion ubicacionActual, Isla isla) {
        System.out.println("El Ratón " + this.hashCode() + " está intentando comer en " + ubicacionActual);
        super.comer(ubicacionActual, isla); // Llama a la lógica de comer de Carnivoro
    }

    /**
     * Define el comportamiento de movimiento de un Ratón.
     * Actualmente, solo imprime un mensaje indicando que el Ratón está intentando moverse.
     * La lógica real de movimiento debería delegarse a la superclase {@link Animal}.
     *
     * @param ubicacionActual La {@link Ubicacion} actual del Ratón.
     * @param isla La {@link Isla} en la que se encuentra el Ratón.
     */
    @Override
    public void moverse(Ubicacion ubicacionActual, Isla isla) {
        System.out.println("El Ratón " + this.hashCode() + " está intentando moverse desde " + ubicacionActual);
        super.moverse(ubicacionActual, isla); // Llama a la lógica de movimiento de Animal
    }

    /**
     * Define el comportamiento de reproducción de un Ratón.
     * Un Ratón intenta reproducirse si hay al menos dos Ratones en la misma ubicación
     * y la ubicación tiene espacio para una nueva cría de Ratón.
     *
     * @param ubicacionActual La {@link Ubicacion} actual donde el Ratón intenta reproducirse.
     * @return Una nueva instancia de {@link Raton} si la reproducción es exitosa, de lo contrario, {@code null}.
     */
    @Override
    public Animal reproducirse(Ubicacion ubicacionActual) {
        System.out.println("El Ratón " + this.hashCode() + " está intentando reproducirse en " + ubicacionActual);

        // Se verifica que el ratón no tenga demasiada hambre para reproducirse.
        if (this.getNivelHambre() >= this.getComidaNecesaria() * 0.5) {
            return null; // Un ratón hambriento no se reproduce.
        }

        // Cuenta la cantidad de ratones en la ubicación actual.
        long ratonesPresentes = ubicacionActual.contarAnimalesDeEspecie(this.getEspecie());

        // Si hay al menos dos ratones y la ubicación puede aceptar más de esta especie.
        if (ratonesPresentes >= 2 && ubicacionActual.puedeAgregarAnimal(this.getEspecie(), this.maxPorUbicacion)) {
            return new Raton(); // Retorna una nueva cría de Ratón.
        }
        return null; // No se reproduce.
    }

    /**
     * Obtiene el carácter Unicode que representa a un Ratón.
     *
     * @return El String Unicode para un Ratón.
     */
    @Override
    public String getUnicode() {
        return UNICODE;
    }
}
