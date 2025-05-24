package org.educatiom.lesson20_ProyectoFinalModulo2.seresvivos;

import org.educatiom.lesson20_ProyectoFinalModulo2.modelo.Isla;
import org.educatiom.lesson20_ProyectoFinalModulo2.modelo.Ubicacion;

/**
 * Representa una especie de Jabalí en la simulación, extendiendo las capacidades de un {@link Herbivoro}.
 * Define las características específicas de los jabalíes como su peso, límite por ubicación,
 * velocidad máxima, comida necesaria y su representación Unicode.
 */
public class Jabali extends Herbivoro{

    private static final double PESO_DEFECTO = 400;
    private static final int MAX_POR_UBICACION_DEFECTO = 50;
    private static final int VELOCIDAD_MAX_DEFECTO = 2;
    private static final double COMIDA_NECESARIA_DEFECTO = 50;
    private static final String UNICODE = "🐗";

    /**
     * Constructor para crear una nueva instancia de Jabalí.
     * Inicializa el Jabalí con los valores por defecto de peso, máximo por ubicación,
     * velocidad máxima y comida necesaria, y establece su especie.
     */
    public Jabali() {
        super(PESO_DEFECTO, MAX_POR_UBICACION_DEFECTO, VELOCIDAD_MAX_DEFECTO, COMIDA_NECESARIA_DEFECTO);
    }

    @Override
    public void comer(Ubicacion ubicacionActual, Isla isla) {
        System.out.println("El Jabalí " + this.hashCode() + " está intentando comer en " + ubicacionActual);
        super.comer(ubicacionActual, isla); // Llama a la lógica de comer de Herbivoro (para comer plantas)
    }

    /**
     * Define el comportamiento de movimiento de un Jabalí.
     * Actualmente, solo imprime un mensaje indicando que el Jabalí intenta moverse.
     * La lógica real de movimiento debería delegarse a la superclase {@link Animal}.
     *
     * @param ubicacionActual La {@link Ubicacion} actual del Jabalí.
     * @param isla La {@link Isla} en la que se encuentra el Jabalí.
     */
    @Override
    public void moverse(Ubicacion ubicacionActual, Isla isla) {
        System.out.println("El Jabalí " + this.hashCode() + " está intentando moverse desde " + ubicacionActual);
        super.moverse(ubicacionActual, isla); // Llama a la lógica de movimiento de Animal
    }

    /**
     * Define el comportamiento de reproducción de un Jabalí.
     * Un Jabalí intenta reproducirse si hay al menos dos Jabalíes en la misma ubicación
     * y la ubicación tiene espacio para una nueva cría de Jabalí.
     *
     * @param ubicacionActual La {@link Ubicacion} actual donde el Jabalí intenta reproducirse.
     * @return Una nueva instancia de {@link Jabali} si la reproducción es exitosa, de lo contrario, {@code null}.
     */
    @Override
    public Animal reproducirse(Ubicacion ubicacionActual) {
        System.out.println("El Jabalí " + this.hashCode() + " está intentando reproducirse en " + ubicacionActual);

        // Se verifica que el jabalí no tenga demasiada hambre para reproducirse.
        if (this.getNivelHambre() >= this.getComidaNecesaria() * 0.5) {
            return null; // Un jabalí hambriento no se reproduce.
        }

        // Cuenta la cantidad de jabalíes en la ubicación actual.
        long jabaliesPresentes = ubicacionActual.contarAnimalesDeEspecie(this.getEspecie());

        // Si hay al menos dos jabalíes y la ubicación puede aceptar más de esta especie.
        if (jabaliesPresentes >= 2 && ubicacionActual.puedeAgregarAnimal(this.getEspecie(), this.maxPorUbicacion)) {
            return new Jabali(); // Retorna una nueva cría de Jabalí.
        }
        return null; // No se reproduce.
    }

    /**
     * Obtiene el carácter Unicode que representa a un Jabalí.
     *
     * @return El String Unicode para un Jabalí.
     */
    @Override
    public String getUnicode() {
        return UNICODE;
    }
}
