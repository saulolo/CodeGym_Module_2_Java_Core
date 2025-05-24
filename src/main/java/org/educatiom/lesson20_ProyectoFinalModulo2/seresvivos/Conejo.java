package org.educatiom.lesson20_ProyectoFinalModulo2.seresvivos;

import org.educatiom.lesson20_ProyectoFinalModulo2.modelo.Isla;
import org.educatiom.lesson20_ProyectoFinalModulo2.modelo.Ubicacion;

/**
 * Representa una especie de Conejo en la simulación, extendiendo las capacidades de un {@link Herbivoro}.
 * Define las características específicas de los conejos como su peso, límite por ubicación,
 * velocidad máxima, comida necesaria y su representación Unicode.
 */
public class Conejo extends Herbivoro{

    private static final double PESO_DEFECTO = 2;
    private static final int MAX_POR_UBICACION_DEFECTO = 150;
    private static final int VELOCIDAD_MAX_DEFECTO = 2;
    private static final double COMIDA_NECESARIA_DEFECTO = 0.45;
    private static final String UNICODE = "🐇";

    /**
     * Constructor para crear una nueva instancia de Conejo.
     * Inicializa el Conejo con los valores por defecto de peso, máximo por ubicación,
     * velocidad máxima y comida necesaria, y establece su especie.
     */
    public Conejo() {
        super(PESO_DEFECTO, MAX_POR_UBICACION_DEFECTO, VELOCIDAD_MAX_DEFECTO, COMIDA_NECESARIA_DEFECTO);
    }

    /**
     * Define el comportamiento de alimentación de un Conejo.
     * Actualmente, solo imprime un mensaje indicando que el Conejo intenta comer.
     * La lógica específica de consumo de plantas debería delegarse a la superclase {@link Herbivoro}.
     *
     * @param ubicacionActual La {@link Ubicacion} actual del Conejo.
     * @param isla La {@link Isla} en la que se encuentra el Conejo.
     */
    @Override
    public void comer(Ubicacion ubicacionActual, Isla isla) {
        System.out.println("El Conejo " + this.hashCode() + " está intentando comer en " + ubicacionActual);
        super.comer(ubicacionActual, isla); // Llama a la lógica de comer de Herbivoro (para comer plantas)
    }

    /**
     * Define el comportamiento de movimiento de un Conejo.
     * Actualmente, solo imprime un mensaje indicando que el Conejo intenta moverse.
     * La lógica real de movimiento debería delegarse a la superclase {@link Animal}.
     *
     * @param ubicacionActual La {@link Ubicacion} actual del Conejo.
     * @param isla La {@link Isla} en la que se encuentra el Conejo.
     */
    @Override
    public void moverse(Ubicacion ubicacionActual, Isla isla) {
        System.out.println("El Conejo " + this.hashCode() + " está intentando moverse desde " + ubicacionActual);
        super.moverse(ubicacionActual, isla); // Llama a la lógica de movimiento de Animal
    }

    /**
     * Define el comportamiento de reproducción de un Conejo.
     * Un Conejo intenta reproducirse si hay al menos dos Conejos en la misma ubicación
     * y la ubicación tiene espacio para una nueva cría de Conejo.
     *
     * @param ubicacionActual La {@link Ubicacion} actual donde el Conejo intenta reproducirse.
     * @return Una nueva instancia de {@link Conejo} si la reproducción es exitosa, de lo contrario, {@code null}.
     */
    @Override
    public Animal reproducirse(Ubicacion ubicacionActual) {
        System.out.println("El Conejo " + this.hashCode() + " está intentando reproducirse en " + ubicacionActual);

        // Se verifica que el conejo no tenga demasiada hambre para reproducirse.
        if (this.getNivelHambre() >= this.getComidaNecesaria() * 0.5) {
            return null; // Un conejo hambriento no se reproduce.
        }

        // Cuenta la cantidad de conejos en la ubicación actual.
        long conejosPresentes = ubicacionActual.contarAnimalesDeEspecie(this.getEspecie());

        if (conejosPresentes >= 2 && ubicacionActual.puedeAgregarAnimal(this.getEspecie(), this.maxPorUbicacion)) {
            return new Conejo(); // Retorna una nueva cría de Conejo.
        }
        return null; // No se reproduce.
    }

    /**
     * Obtiene el carácter Unicode que representa a un Conejo.
     *
     * @return El String Unicode para un Conejo.
     */
    @Override
    public String getUnicode() {
        return UNICODE;
    }
}
