package org.educatiom.lesson20_ProyectoFinalModulo2.seresvivos;

import org.educatiom.lesson20_ProyectoFinalModulo2.modelo.Isla;
import org.educatiom.lesson20_ProyectoFinalModulo2.modelo.Ubicacion;

/**
 * Representa una especie de Ciervo en la simulación, extendiendo las capacidades de un {@link Herbivoro}.
 * Define las características específicas de los ciervos como su peso, límite por ubicación,
 * velocidad máxima, comida necesaria y su representación Unicode.
 */
public class Ciervo extends Herbivoro{

    private static final double PESO_DEFECTO = 300;
    private static final int MAX_POR_UBICACION_DEFECTO = 20;
    private static final int VELOCIDAD_MAX_DEFECTO = 4;
    private static final double COMIDA_NECESARIA_DEFECTO = 50;
    private static final String UNICODE = "🐎";

    /**
     * Constructor para crear una nueva instancia de Ciervo.
     * Inicializa el Ciervo con los valores por defecto de peso, máximo por ubicación,
     * velocidad máxima y comida necesaria, y establece su especie.
     */
    public Ciervo() {
        super(PESO_DEFECTO, MAX_POR_UBICACION_DEFECTO, VELOCIDAD_MAX_DEFECTO, COMIDA_NECESARIA_DEFECTO);
    }

    /**
     * Define el comportamiento de alimentación de un Ciervo.
     * Actualmente, solo imprime un mensaje indicando que el Ciervo intenta comer.
     * La lógica específica de consumo de plantas debería delegarse a la superclase {@link Herbivoro}.
     *
     * @param ubicacionActual La {@link Ubicacion} actual del Ciervo.
     * @param isla La {@link Isla} en la que se encuentra el Ciervo.
     */
    @Override
    public void comer(Ubicacion ubicacionActual, Isla isla) {
        System.out.println("El Ciervo " + this.hashCode() + " está intentando comer en " + ubicacionActual);
        super.comer(ubicacionActual, isla); // Llama a la lógica de comer de Herbivoro (para comer plantas)
    }

    /**
     * Define el comportamiento de movimiento de un Ciervo.
     * Actualmente, solo imprime un mensaje indicando que el Ciervo intenta moverse.
     * La lógica real de movimiento debería delegarse a la superclase {@link Animal}.
     *
     * @param ubicacionActual La {@link Ubicacion} actual del Ciervo.
     * @param isla La {@link Isla} en la que se encuentra el Ciervo.
     */
    @Override
    public void moverse(Ubicacion ubicacionActual, Isla isla) {
        System.out.println("El Ciervo " + this.hashCode() + " está intentando moverse desde " + ubicacionActual);
        super.moverse(ubicacionActual, isla); // Llama a la lógica de movimiento de Animal
    }

    /**
     * Define el comportamiento de reproducción de un Ciervo.
     * Un Ciervo intenta reproducirse si hay al menos dos Ciervos en la misma ubicación
     * y la ubicación tiene espacio para una nueva cría de Ciervo.
     *
     * @param ubicacionActual La {@link Ubicacion} actual donde el Ciervo intenta reproducirse.
     * @return Una nueva instancia de {@link Ciervo} si la reproducción es exitosa, de lo contrario, {@code null}.
     */
    @Override
    public Animal reproducirse(Ubicacion ubicacionActual) {
        System.out.println("El Ciervo " + this.hashCode() + " está intentando reproducirse en " + ubicacionActual);

        // Se verifica que el ciervo no tenga demasiada hambre para reproducirse.
        if (this.getNivelHambre() >= this.getComidaNecesaria() * 0.5) {
            return null; // Un ciervo hambriento no se reproduce.
        }

        // Cuenta la cantidad de ciervos en la ubicación actual.
        long ciervosPresentes = ubicacionActual.contarAnimalesDeEspecie(this.getEspecie());

        // Si hay al menos dos ciervos y la ubicación puede aceptar más de esta especie.
        if (ciervosPresentes >= 2 && ubicacionActual.puedeAgregarAnimal(this.getEspecie(), this.maxPorUbicacion)) {
            return new Ciervo(); // Retorna una nueva cría de Ciervo.
        }
        return null; // No se reproduce.
    }

    /**
     * Obtiene el carácter Unicode que representa a un Ciervo.
     *
     * @return El String Unicode para un Ciervo.
     */
    @Override
    public String getUnicode() {
        return UNICODE;
    }
}
