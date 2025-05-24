package org.educatiom.lesson20_ProyectoFinalModulo2.seresvivos;

import org.educatiom.lesson20_ProyectoFinalModulo2.modelo.Isla;
import org.educatiom.lesson20_ProyectoFinalModulo2.modelo.Ubicacion;

/**
 * Representa una especie de Cabra en la simulación, extendiendo las capacidades de un {@link Herbivoro}.
 * Define las características específicas de las cabras como su peso, límite por ubicación,
 * velocidad máxima, comida necesaria y su representación Unicode.
 */
public class Cabra extends Herbivoro{

    private static final double PESO_DEFECTO = 60;
    private static final int MAX_POR_UBICACION_DEFECTO = 140;
    private static final int VELOCIDAD_MAX_DEFECTO = 3;
    private static final double COMIDA_NECESARIA_DEFECTO = 10;
    private static final String UNICODE = "🐐";

    /**
     * Constructor para crear una nueva instancia de Cabra.
     * Inicializa la Cabra con los valores por defecto de peso, máximo por ubicación,
     * velocidad máxima y comida necesaria, y establece su especie.
     */
    public Cabra() {
        super(PESO_DEFECTO, MAX_POR_UBICACION_DEFECTO, VELOCIDAD_MAX_DEFECTO, COMIDA_NECESARIA_DEFECTO);
    }
    /**
     * Define el comportamiento de alimentación de una Cabra.
     * Actualmente, solo imprime un mensaje indicando que la Cabra intenta comer.
     * La lógica específica de consumo de plantas debería delegarse a la superclase {@link Herbivoro}.
     *
     * @param ubicacionActual La {@link Ubicacion} actual de la Cabra.
     * @param isla La {@link Isla} en la que se encuentra la Cabra.
     */
    @Override
    public void comer(Ubicacion ubicacionActual, Isla isla) {
        System.out.println("La Cabra " + this.hashCode() + " está intentando comer en " + ubicacionActual);
        super.comer(ubicacionActual, isla); // Llama a la lógica de comer de Herbivoro (para comer plantas)
    }

    /**
     * Define el comportamiento de movimiento de una Cabra.
     * Actualmente, solo imprime un mensaje indicando que la Cabra intenta moverse.
     * La lógica real de movimiento debería delegarse a la superclase {@link Animal}.
     *
     * @param ubicacionActual La {@link Ubicacion} actual de la Cabra.
     * @param isla La {@link Isla} en la que se encuentra la Cabra.
     */
    @Override
    public void moverse(Ubicacion ubicacionActual, Isla isla) {
        System.out.println("La Cabra " + this.hashCode() + " está intentando moverse desde " + ubicacionActual);
        super.moverse(ubicacionActual, isla); // Llama a la lógica de movimiento de Animal
    }

    /**
     * Define el comportamiento de reproducción de una Cabra.
     * Una Cabra intenta reproducirse si hay al menos dos Cabras en la misma ubicación
     * y la ubicación tiene espacio para una nueva cría de Cabra.
     *
     * @param ubicacionActual La {@link Ubicacion} actual donde la Cabra intenta reproducirse.
     * @return Una nueva instancia de {@link Cabra} si la reproducción es exitosa, de lo contrario, {@code null}.
     */
    @Override
    public Animal reproducirse(Ubicacion ubicacionActual) {
        System.out.println("La Cabra " + this.hashCode() + " está intentando reproducirse en " + ubicacionActual);

        // Se verifica que la cabra no tenga demasiada hambre para reproducirse.
        if (this.getNivelHambre() >= this.getComidaNecesaria() * 0.5) {
            return null; // Una cabra hambrienta no se reproduce.
        }

        // Cuenta la cantidad de cabras en la ubicación actual.
        long cabrasPresentes = ubicacionActual.contarAnimalesDeEspecie(this.getEspecie());

        // Si hay al menos dos cabras y la ubicación puede aceptar más de esta especie.
        if (cabrasPresentes >= 2 && ubicacionActual.puedeAgregarAnimal(this.getEspecie(), this.maxPorUbicacion)) {
            return new Cabra(); // Retorna una nueva cría de Cabra.
        }
        return null; // No se reproduce.
    }

    /**
     * Obtiene el carácter Unicode que representa a una Cabra.
     *
     * @return El String Unicode para una Cabra.
     */
    @Override
    public String getUnicode() {
        return UNICODE;
    }
}
