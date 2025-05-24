package org.educatiom.lesson20_ProyectoFinalModulo2.seresvivos;

import org.educatiom.lesson20_ProyectoFinalModulo2.modelo.Isla;
import org.educatiom.lesson20_ProyectoFinalModulo2.modelo.Ubicacion;

import java.util.concurrent.ThreadLocalRandom;

/**
 * Representa una especie de Lobo en la simulación, extendiendo las capacidades de un {@link Carnivoro}.
 * Define las características específicas de los lobos como su peso, límite por ubicación,
 * velocidad máxima, comida necesaria y su representación Unicode.
 */
public class Lobo extends Carnivoro{

    private static final double PESO_DEFECTO = 50;
    private static final int MAX_POR_UBICACION_DEFECTO = 30;
    private static final int VELOCIDAD_MAX_DEFECTO = 3;
    private static final double COMIDA_NECESARIA_DEFECTO = 8;
    private static final String UNICODE = "🐺";

    /**
     * Constructor para crear una nueva instancia de Lobo.
     * Inicializa el Lobo con los valores por defecto de peso, máximo por ubicación,
     * velocidad máxima y comida necesaria, y establece su especie.
     */
    public Lobo() {
        super(PESO_DEFECTO, MAX_POR_UBICACION_DEFECTO, VELOCIDAD_MAX_DEFECTO, COMIDA_NECESARIA_DEFECTO);
    }

    /**
     * Define el comportamiento de alimentación de un Lobo.
     * Delega la lógica de alimentación a la implementación de la superclase {@link Carnivoro}.
     *
     * @param ubicacionActual La {@link Ubicacion} actual del Lobo.
     * @param isla La {@link Isla} en la que se encuentra el Lobo.
     */
    @Override
    public void comer(Ubicacion ubicacionActual, Isla isla) {
        super.comer(ubicacionActual, isla);
    }

    /**
     * Define el comportamiento de movimiento de un Lobo.
     * Delega la lógica de movimiento a la implementación de la superclase {@link Carnivoro}.
     *
     * @param ubicacionActual La {@link Ubicacion} actual del Lobo.
     * @param isla La {@link Isla} en la que se encuentra el Lobo.
     */
    @Override
    public void moverse(Ubicacion ubicacionActual, Isla isla) {
        super.moverse(ubicacionActual, isla);
    }

    /**
     * Define el comportamiento de reproducción de un Lobo.
     * Un Lobo intenta reproducirse si no tiene demasiada hambre, hay al menos dos Lobos en la misma ubicación
     * y la ubicación tiene espacio para una nueva cría de Lobo. Hay una probabilidad fija del 70% de éxito.
     *
     * @param ubicacionActual La {@link Ubicacion} actual donde el Lobo intenta reproducirse.
     * @return Una nueva instancia de {@link Lobo} si la reproducción es exitosa, de lo contrario, {@code null}.
     */
    @Override
    public Animal reproducirse(Ubicacion ubicacionActual) {
        // Se verifica que el lobo no tenga demasiada hambre para reproducirse.
        if (this.getNivelHambre() >= this.getComidaNecesaria() * 0.5) {
            System.out.println(this.getEspecie() + " " + this.hashCode() + " tiene demasiada hambre para reproducirse en " + ubicacionActual + ".");
            return null; // Un lobo hambriento no se reproduce.
        }

        long lobosPresentes = ubicacionActual.contarAnimalesDeEspecie(this.getEspecie());
        if (lobosPresentes >= 2 && ubicacionActual.puedeAgregarAnimal(this.getEspecie(), this.maxPorUbicacion)) {
            // Aplica una probabilidad de reproducción del 70%.
            if (ThreadLocalRandom.current().nextDouble(0, 100) < 70) {
                System.out.println("Lobo " + this.hashCode() + " se reproduce con éxito en " + ubicacionActual + ".");
                return new Lobo(); // Devuelve una nueva cría de Lobo.
            } else {
                System.out.println("Lobo " + this.hashCode() + " intentó reproducirse pero falló en " + ubicacionActual + ".");
            }
        }
        return null; // No se reproduce si las condiciones no se cumplen o la probabilidad falla.
    }

    /**
     * Obtiene el carácter Unicode que representa a un Lobo.
     *
     * @return El String Unicode para un Lobo.
     */
    @Override
    public String getUnicode() {
        return UNICODE;
    }
}
