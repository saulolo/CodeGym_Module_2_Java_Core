package org.educatiom.lesson20_ProyectoFinalModulo2.seresvivos;

/**
 * Representa una Planta en la simulación. Las plantas sirven como fuente de alimento
 * para los animales herbívoros. Tienen un peso que indica su valor nutricional.
 */
public class Planta {

    private double peso;

    /**
     * Constructor para crear una nueva instancia de Planta.
     *
     * @param peso El peso inicial de la planta, que representa su valor nutricional.
     */
    public Planta(double peso) {
        this.peso = peso;
    }

    /**
     * Obtiene el peso (valor nutricional) de la planta.
     *
     * @return El peso actual de la planta.
     */
    public double getPeso() {
        return peso;
    }

    /**
     * Establece el peso (valor nutricional) de la planta.
     *
     * @param peso El nuevo peso para la planta.
     */
    public void setPeso(double peso) {
        this.peso = peso;
    }

    /**
     * Obtiene el tipo de ser vivo, que para esta clase siempre es "Planta".
     *
     * @return Un String que representa el tipo de la entidad ("Planta").
     */
    public String getTipo() {
        return "Planta";
    }

    /**
     * Proporciona una representación en String de la Planta, utilizando un carácter Unicode.
     *
     * @return El carácter Unicode que representa una planta (🌱).
     */
    @Override
    public String toString() {
        return "🌱";
    }
}
