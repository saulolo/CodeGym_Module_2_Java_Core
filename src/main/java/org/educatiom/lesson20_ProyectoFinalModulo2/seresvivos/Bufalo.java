package org.educatiom.lesson20_ProyectoFinalModulo2.seresvivos;

import org.educatiom.lesson20_ProyectoFinalModulo2.modelo.Isla;
import org.educatiom.lesson20_ProyectoFinalModulo2.modelo.Ubicacion;

/**
 * Representa una especie de Búfalo en la simulación, extendiendo las capacidades de un {@link Herbivoro}.
 * Define las características específicas de los búfalos como su peso, límite por ubicación,
 * velocidad máxima, comida necesaria y su representación Unicode.
 */
public class Bufalo extends Herbivoro{

    private static final double PESO_DEFECTO = 700;
    private static final int MAX_POR_UBICACION_DEFECTO = 10;
    private static final int VELOCIDAD_MAX_DEFECTO = 3;
    private static final double COMIDA_NECESARIA_DEFECTO = 100;
    private static final String UNICODE = "🐃" ;

    /**
     * Constructor para crear una nueva instancia de Búfalo.
     * Inicializa el Búfalo con los valores por defecto de peso, máximo por ubicación,
     * velocidad máxima y comida necesaria, y establece su especie.
     */
    public Bufalo() {
        super(PESO_DEFECTO, MAX_POR_UBICACION_DEFECTO, VELOCIDAD_MAX_DEFECTO, COMIDA_NECESARIA_DEFECTO);
    }
    /**
     * Define el comportamiento de alimentación de un Búfalo.
     * Actualmente, solo imprime un mensaje indicando que el Búfalo intenta comer.
     * La lógica específica de consumo de plantas debería delegarse a la superclase {@link Herbivoro}.
     *
     * @param ubicacionActual La {@link Ubicacion} actual del Búfalo.
     * @param isla La {@link Isla} en la que se encuentra el Búfalo.
     */
    @Override
    public void comer(Ubicacion ubicacionActual, Isla isla) {
        System.out.println("El Búfalo " + this.hashCode() + " está intentando comer en " + ubicacionActual);
        super.comer(ubicacionActual, isla); // Llama a la lógica de comer de Herbivoro (para comer plantas)
    }

    /**
     * Define el comportamiento de movimiento de un Búfalo.
     * Actualmente, solo imprime un mensaje indicando que el Búfalo intenta moverse.
     * La lógica real de movimiento debería delegarse a la superclase {@link Animal}.
     *
     * @param ubicacionActual La {@link Ubicacion} actual del Búfalo.
     * @param isla La {@link Isla} en la que se encuentra el Búfalo.
     */
    @Override
    public void moverse(Ubicacion ubicacionActual, Isla isla) {
        System.out.println("El Búfalo " + this.hashCode() + " está intentando moverse desde " + ubicacionActual);
        super.moverse(ubicacionActual, isla); // Llama a la lógica de movimiento de Animal
    }

    /**
     * Define el comportamiento de reproducción de un Búfalo.
     * Un Búfalo intenta reproducirse si hay al menos dos Búfalos en la misma ubicación
     * y la ubicación tiene espacio para una nueva cría de Búfalo.
     *
     * @param ubicacionActual La {@link Ubicacion} actual donde el Búfalo intenta reproducirse.
     * @return Una nueva instancia de {@link Bufalo} si la reproducción es exitosa, de lo contrario, {@code null}.
     */
    @Override
    public Animal reproducirse(Ubicacion ubicacionActual) {
        System.out.println("El Búfalo " + this.hashCode() + " está intentando reproducirse en " + ubicacionActual);

        // Se verifica que el búfalo no tenga demasiada hambre para reproducirse.
        if (this.getNivelHambre() >= this.getComidaNecesaria() * 0.5) {
            return null; // Un búfalo hambriento no se reproduce.
        }

        // Cuenta la cantidad de búfalos en la ubicación actual.
        long bufalosPresentes = ubicacionActual.contarAnimalesDeEspecie(this.getEspecie());

        // Si hay al menos dos búfalos y la ubicación puede aceptar más de esta especie.
        if (bufalosPresentes >= 2 && ubicacionActual.puedeAgregarAnimal(this.getEspecie(), this.maxPorUbicacion)) {
            return new Bufalo(); // Retorna una nueva cría de Búfalo.
        }
        return null; // No se reproduce.
    }

    /**
     * Obtiene el carácter Unicode que representa a un Búfalo.
     *
     * @return El String Unicode para un Búfalo.
     */
    @Override
    public String getUnicode() {
        return UNICODE;
    }
}
