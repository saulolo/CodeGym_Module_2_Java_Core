package org.educatiom.lesson20_ProyectoFinalModulo2.seresvivos;

import org.educatiom.lesson20_ProyectoFinalModulo2.modelo.Isla;
import org.educatiom.lesson20_ProyectoFinalModulo2.modelo.Ubicacion;

/**
 * Representa una especie de Oruga en la simulación, extendiendo las capacidades de un {@link Herbivoro}.
 * Define las características específicas de las orugas como su peso, límite por ubicación,
 * velocidad máxima, comida necesaria y su representación Unicode.
 * Notablemente, las orugas tienen una velocidad máxima de 0, lo que significa que no se mueven.
 */
public class Oruga extends Herbivoro{

    private static final double PESO_DEFECTO = 0.01;
    private static final int MAX_POR_UBICACION_DEFECTO = 1000;
    private static final int VELOCIDAD_MAX_DEFECTO = 0;
    private static final double COMIDA_NECESARIA_DEFECTO = 0;
    private static final String UNICODE = "🐛";

    /**
     * Constructor para crear una nueva instancia de Oruga.
     * Inicializa la Oruga con los valores por defecto de peso, máximo por ubicación,
     * velocidad máxima y comida necesaria, y establece su especie.
     */
    public Oruga() {
        super(PESO_DEFECTO, MAX_POR_UBICACION_DEFECTO, VELOCIDAD_MAX_DEFECTO, COMIDA_NECESARIA_DEFECTO);
    }

    /**
     * Define el comportamiento de alimentación de una Oruga.
     * Actualmente, solo imprime un mensaje indicando que la Oruga intenta comer.
     * La lógica específica de consumo de plantas debería delegarse a la superclase {@link Herbivoro}.
     *
     * @param ubicacionActual La {@link Ubicacion} actual de la Oruga.
     * @param isla La {@link Isla} en la que se encuentra la Oruga.
     */
    @Override
    public void comer(Ubicacion ubicacionActual, Isla isla) {
        System.out.println("La Oruga " + this.hashCode() + " está intentando comer en " + ubicacionActual);
        super.comer(ubicacionActual, isla); // Llama a la lógica de comer de Herbivoro (para comer plantas)
    }

    /**
     * Define el comportamiento de movimiento de una Oruga.
     * Dado que la {@link #VELOCIDAD_MAX_DEFECTO} es 0, las orugas no se moverán.
     * Actualmente, solo imprime un mensaje indicando que la Oruga intenta moverse.
     * La lógica real de movimiento debería delegarse a la superclase {@link Animal}.
     *
     * @param ubicacionActual La {@link Ubicacion} actual de la Oruga.
     * @param isla La {@link Isla} en la que se encuentra la Oruga.
     */
    @Override
    public void moverse(Ubicacion ubicacionActual, Isla isla) {
        System.out.println("La Oruga " + this.hashCode() + " está intentando moverse desde " + ubicacionActual);
        super.moverse(ubicacionActual, isla); // Llama a la lógica de movimiento de Animal
    }

    /**
     * Define el comportamiento de reproducción de una Oruga.
     * Una Oruga intenta reproducirse si hay al menos dos Orugas en la misma ubicación
     * y la ubicación tiene espacio para una nueva cría de Oruga.
     *
     * @param ubicacionActual La {@link Ubicacion} actual donde la Oruga intenta reproducirse.
     * @return Una nueva instancia de {@link Oruga} si la reproducción es exitosa, de lo contrario, {@code null}.
     */
    @Override
    public Animal reproducirse(Ubicacion ubicacionActual) {
        System.out.println("La Oruga " + this.hashCode() + " está intentando reproducirse en " + ubicacionActual);

        // Se verifica que la oruga no tenga demasiada hambre para reproducirse.
        if (this.getNivelHambre() >= this.getComidaNecesaria() * 0.5) {
            return null; // Una oruga hambrienta no se reproduce.
        }

        // Cuenta la cantidad de orugas en la ubicación actual.
        long orugasPresentes = ubicacionActual.contarAnimalesDeEspecie(this.getEspecie());

        // Si hay al menos dos orugas y la ubicación puede aceptar más de esta especie.
        if (orugasPresentes >= 2 && ubicacionActual.puedeAgregarAnimal(this.getEspecie(), this.maxPorUbicacion)) {
            return new Oruga(); // Retorna una nueva cría de Oruga.
        }
        return null; // No se reproduce.
    }

    /**
     * Obtiene el carácter Unicode que representa a una Oruga.
     *
     * @return El String Unicode para una Oruga.
     */
    @Override
    public String getUnicode() {
        return UNICODE;
    }
}
