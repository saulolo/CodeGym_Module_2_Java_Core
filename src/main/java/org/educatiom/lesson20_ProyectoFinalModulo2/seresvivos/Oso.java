package org.educatiom.lesson20_ProyectoFinalModulo2.seresvivos;

import org.educatiom.lesson20_ProyectoFinalModulo2.modelo.Isla;
import org.educatiom.lesson20_ProyectoFinalModulo2.modelo.Ubicacion;

/**
 * Representa una especie de Oso en la simulación, extendiendo las capacidades de un {@link Carnivoro}.
 * Define las características específicas de los osos como su peso, límite por ubicación,
 * velocidad máxima, comida necesaria y su representación Unicode.
 */
public class Oso extends Carnivoro{

    private static final double PESO_DEFECTO = 500;
    private static final int MAX_POR_UBICACION_DEFECTO = 5;
    private static final int VELOCIDAD_MAX_DEFECTO = 2;
    private static final double COMIDA_NECESARIA_DEFECTO = 80;
    private static final String UNICODE = "🐻";

    /**
     * Constructor para crear una nueva instancia de Oso.
     * Inicializa el Oso con los valores por defecto de peso, máximo por ubicación,
     * velocidad máxima y comida necesaria, y establece su especie.
     */
    public Oso() {
        super(PESO_DEFECTO, MAX_POR_UBICACION_DEFECTO, VELOCIDAD_MAX_DEFECTO, COMIDA_NECESARIA_DEFECTO);
    }

    /**
     * Define el comportamiento de alimentación de un Oso.
     * Actualmente, solo imprime un mensaje indicando que el Oso está intentando comer.
     * La lógica específica de depredación y consumo de presas debería delegarse a la superclase {@link Carnivoro}.
     *
     * @param ubicacionActual La {@link Ubicacion} actual del Oso.
     * @param isla La {@link Isla} en la que se encuentra el Oso.
     */
    @Override
    public void comer(Ubicacion ubicacionActual, Isla isla) {
        System.out.println("El Oso " + this.hashCode() + " está intentando comer en " + ubicacionActual);
        super.comer(ubicacionActual, isla); // Llama a la lógica de comer de Carnivoro
    }

    /**
     * Define el comportamiento de movimiento de un Oso.
     * Actualmente, solo imprime un mensaje indicando que el Oso está intentando moverse.
     * La lógica real de movimiento debería delegarse a la superclase {@link Animal}.
     *
     * @param ubicacionActual La {@link Ubicacion} actual del Oso.
     * @param isla La {@link Isla} en la que se encuentra el Oso.
     */
    @Override
    public void moverse(Ubicacion ubicacionActual, Isla isla) {
        System.out.println("El Oso " + this.hashCode() + " está intentando moverse desde " + ubicacionActual);
        super.moverse(ubicacionActual, isla); // Llama a la lógica de movimiento de Animal
    }

    /**
     * Define el comportamiento de reproducción de un Oso.
     * Un Oso intenta reproducirse si hay al menos dos Osos en la misma ubicación
     * y la ubicación tiene espacio para una nueva cría de Oso.
     *
     * @param ubicacionActual La {@link Ubicacion} actual donde el Oso intenta reproducirse.
     * @return Una nueva instancia de {@link Oso} si la reproducción es exitosa, de lo contrario, {@code null}.
     */
    @Override
    public Animal reproducirse(Ubicacion ubicacionActual) {
        System.out.println("El Oso " + this.hashCode() + " está intentando reproducirse en " + ubicacionActual);

        // Se verifica que el oso no tenga demasiada hambre para reproducirse.
        if (this.getNivelHambre() >= this.getComidaNecesaria() * 0.5) {
            return null; // Un oso hambriento no se reproduce.
        }

        // Cuenta la cantidad de osos en la ubicación actual.
        long ososPresentes = ubicacionActual.contarAnimalesDeEspecie(this.getEspecie());

        // Si hay al menos dos osos y la ubicación puede aceptar más de esta especie.
        if (ososPresentes >= 2 && ubicacionActual.puedeAgregarAnimal(this.getEspecie(), this.maxPorUbicacion)) {
            return new Oso(); // Retorna una nueva cría de Oso.
        }
        return null; // No se reproduce.
    }

    /**
     * Obtiene el carácter Unicode que representa a un Oso.
     *
     * @return El String Unicode para un Oso.
     */
    @Override
    public String getUnicode() {
        return UNICODE;
    }
}
