package org.educatiom.lesson20_ProyectoFinalModulo2.seresvivos;

import org.educatiom.lesson20_ProyectoFinalModulo2.modelo.Isla;
import org.educatiom.lesson20_ProyectoFinalModulo2.modelo.Ubicacion;

/**
 * Representa una especie de Caballo en la simulación, extendiendo las capacidades de un {@link Herbivoro}.
 * Define las características específicas de los caballos como su peso, límite por ubicación,
 * velocidad máxima, comida necesaria y su representación Unicode.
 */
public class Caballo extends Herbivoro{

    private static final double PESO_DEFECTO = 400;
    private static final int MAX_POR_UBICACION_DEFECTO = 20;
    private static final int VELOCIDAD_MAX_DEFECTO = 4;
    private static final double COMIDA_NECESARIA_DEFECTO = 60;
    private static final String UNICODE = "🐎";

    /**
     * Constructor para crear una nueva instancia de Caballo.
     * Inicializa el Caballo con los valores por defecto de peso, máximo por ubicación,
     * velocidad máxima y comida necesaria, y establece su especie.
     */
    public Caballo() {
        super(PESO_DEFECTO, MAX_POR_UBICACION_DEFECTO, VELOCIDAD_MAX_DEFECTO, COMIDA_NECESARIA_DEFECTO);
    }
    /**
     * Define el comportamiento de alimentación de un Caballo.
     * Actualmente, solo imprime un mensaje indicando que el Caballo intenta comer.
     * La lógica específica de consumo de plantas debería delegarse a la superclase {@link Herbivoro}.
     *
     * @param ubicacionActual La {@link Ubicacion} actual del Caballo.
     * @param isla La {@link Isla} en la que se encuentra el Caballo.
     */
    @Override
    public void comer(Ubicacion ubicacionActual, Isla isla) {
        System.out.println("El Caballo " + this.hashCode() + " está intentando comer en " + ubicacionActual);
        super.comer(ubicacionActual, isla); // Llama a la lógica de comer de Herbivoro (para comer plantas)
    }

    /**
     * Define el comportamiento de movimiento de un Caballo.
     * Actualmente, solo imprime un mensaje indicando que el Caballo intenta moverse.
     * La lógica real de movimiento debería delegarse a la superclase {@link Animal}.
     *
     * @param ubicacionActual La {@link Ubicacion} actual del Caballo.
     * @param isla La {@link Isla} en la que se encuentra el Caballo.
     */
    @Override
    public void moverse(Ubicacion ubicacionActual, Isla isla) {
        System.out.println("El Caballo " + this.hashCode() + " está intentando moverse desde " + ubicacionActual);
        super.moverse(ubicacionActual, isla); // Llama a la lógica de movimiento de Animal
    }

    /**
     * Define el comportamiento de reproducción de un Caballo.
     * Un Caballo intenta reproducirse si hay al menos dos Caballos en la misma ubicación
     * y la ubicación tiene espacio para una nueva cría de Caballo.
     *
     * @param ubicacionActual La {@link Ubicacion} actual donde el Caballo intenta reproducirse.
     * @return Una nueva instancia de {@link Caballo} si la reproducción es exitosa, de lo contrario, {@code null}.
     */
    @Override
    public Animal reproducirse(Ubicacion ubicacionActual) {
        System.out.println("El Caballo " + this.hashCode() + " está intentando reproducirse en " + ubicacionActual);

        // Se verifica que el caballo no tenga demasiada hambre para reproducirse.
        if (this.getNivelHambre() >= this.getComidaNecesaria() * 0.5) {
            return null; // Un caballo hambriento no se reproduce.
        }

        // Cuenta la cantidad de caballos en la ubicación actual.
        long caballosPresentes = ubicacionActual.contarAnimalesDeEspecie(this.getEspecie());

        // Si hay al menos dos caballos y la ubicación puede aceptar más de esta especie.
        if (caballosPresentes >= 2 && ubicacionActual.puedeAgregarAnimal(this.getEspecie(), this.maxPorUbicacion)) {
            return new Caballo(); // Retorna una nueva cría de Caballo.
        }
        return null; // No se reproduce.
    }

    /**
     * Obtiene el carácter Unicode que representa a un Caballo.
     *
     * @return El String Unicode para un Caballo.
     */
    @Override
    public String getUnicode() {
        return UNICODE;
    }
}
