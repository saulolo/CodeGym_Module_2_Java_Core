package org.educatiom.lesson20_ProyectoFinalModulo2.seresvivos;

import org.educatiom.lesson20_ProyectoFinalModulo2.modelo.Isla;
import org.educatiom.lesson20_ProyectoFinalModulo2.modelo.Ubicacion;

/**
 * Representa una especie de Oveja en la simulación, extendiendo las capacidades de un {@link Herbivoro}.
 * Define las características específicas de las ovejas como su peso, límite por ubicación,
 * velocidad máxima, comida necesaria y su representación Unicode.
 */
public class Oveja extends Herbivoro{

    private static final double PESO_DEFECTO = 70;
    private static final int MAX_POR_UBICACION_DEFECTO = 140;
    private static final int VELOCIDAD_MAX_DEFECTO = 3;
    private static final double COMIDA_NECESARIA_DEFECTO = 15;
    private static final String UNICODE = "🐑";

    /**
     * Constructor para crear una nueva instancia de Oveja.
     * Inicializa la Oveja con los valores por defecto de peso, máximo por ubicación,
     * velocidad máxima y comida necesaria, y establece su especie.
     */
    public Oveja() {
        super(PESO_DEFECTO, MAX_POR_UBICACION_DEFECTO, VELOCIDAD_MAX_DEFECTO, COMIDA_NECESARIA_DEFECTO);
    }


    /**
     * Define el comportamiento de alimentación de una Oveja.
     * Actualmente, solo imprime un mensaje indicando que la Oveja está intentando comer.
     * La lógica específica de consumo de plantas debería delegarse a la superclase {@link Herbivoro}.
     *
     * @param ubicacionActual La {@link Ubicacion} actual de la Oveja.
     * @param isla La {@link Isla} en la que se encuentra la Oveja.
     */
    @Override
    public void comer(Ubicacion ubicacionActual, Isla isla) {
        // NOTA: El mensaje de impresión decía "La Cabra". Se ha corregido a "La Oveja".
        System.out.println("La Oveja " + this.hashCode() + " está intentando comer en " + ubicacionActual);
        super.comer(ubicacionActual, isla); // Llama a la lógica de comer de Herbivoro (para comer plantas)
    }

    /**
     * Define el comportamiento de movimiento de una Oveja.
     * Actualmente, solo imprime un mensaje indicando que la Oveja está intentando moverse.
     * La lógica real de movimiento debería delegarse a la superclase {@link Animal}.
     *
     * @param ubicacionActual La {@link Ubicacion} actual de la Oveja.
     * @param isla La {@link Isla} en la que se encuentra la Oveja.
     */
    @Override
    public void moverse(Ubicacion ubicacionActual, Isla isla) {
        // NOTA: El mensaje de impresión decía "La Cabra". Se ha corregido a "La Oveja".
        System.out.println("La Oveja " + this.hashCode() + " está intentando moverse desde " + ubicacionActual);
        super.moverse(ubicacionActual, isla); // Llama a la lógica de movimiento de Animal
    }

    /**
     * Define el comportamiento de reproducción de una Oveja.
     * Una Oveja intenta reproducirse si hay al menos dos Ovejas en la misma ubicación
     * y la ubicación tiene espacio para una nueva cría de Oveja.
     *
     * @param ubicacionActual La {@link Ubicacion} actual donde la Oveja intenta reproducirse.
     * @return Una nueva instancia de {@link Oveja} si la reproducción es exitosa, de lo contrario, {@code null}.
     */
    @Override
    public Animal reproducirse(Ubicacion ubicacionActual) {
        // NOTA: El mensaje de impresión decía "La Cabra". Se ha corregido a "La Oveja".
        System.out.println("La Oveja " + this.hashCode() + " está intentando reproducirse en " + ubicacionActual);

        // Se verifica que la oveja no tenga demasiada hambre para reproducirse.
        if (this.getNivelHambre() >= this.getComidaNecesaria() * 0.5) {
            return null; // Una oveja hambrienta no se reproduce.
        }

        // Cuenta la cantidad de ovejas en la ubicación actual.
        long ovejasPresentes = ubicacionActual.contarAnimalesDeEspecie(this.getEspecie());

        // Si hay al menos dos ovejas y la ubicación puede aceptar más de esta especie.
        if (ovejasPresentes >= 2 && ubicacionActual.puedeAgregarAnimal(this.getEspecie(), this.maxPorUbicacion)) {
            return new Oveja(); // Retorna una nueva cría de Oveja.
        }
        return null; // No se reproduce.
    }

    /**
     * Obtiene el carácter Unicode que representa a una Oveja.
     *
     * @return El String Unicode para una Oveja.
     */
    @Override
    public String getUnicode() {
        return UNICODE;
    }
}
