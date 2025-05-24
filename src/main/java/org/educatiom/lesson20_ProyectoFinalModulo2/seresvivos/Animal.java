package org.educatiom.lesson20_ProyectoFinalModulo2.seresvivos;

import org.educatiom.lesson20_ProyectoFinalModulo2.modelo.Isla;
import org.educatiom.lesson20_ProyectoFinalModulo2.modelo.Ubicacion;

import java.util.ArrayList;
import java.util.List;
/**
 * Clase abstracta base para todos los animales en la simulación de la isla.
 * Define las propiedades y comportamientos comunes a todos los animales,
 * como peso, límites por ubicación, velocidad, necesidades alimentarias,
 * nivel de hambre y su ciclo de vida en cada turno.
 */
public abstract class Animal {

    protected double peso;
    protected int maxPorUbicacion;
    protected int velocidadMax;
    protected double comidaNecesaria;
    protected double nivelHambre;
    protected String especie;

    /**
     * Constructor para la clase Animal.
     *
     * @param peso El peso del animal.
     * @param maxPorUbicacion El número máximo de individuos de esta especie permitidos por ubicación.
     * @param velocidadMax La velocidad máxima de movimiento del animal.
     * @param comidaNecesaria La cantidad de comida que el animal necesita por turno.
     */
    public Animal(double peso, int maxPorUbicacion, int velocidadMax, double comidaNecesaria) {
        this.peso = peso;
        this.maxPorUbicacion = maxPorUbicacion;
        this.velocidadMax = velocidadMax;
        this.comidaNecesaria = comidaNecesaria;
        this.nivelHambre = comidaNecesaria * 0.5;
        this.especie = this.getClass().getSimpleName();
    }

    /**
     * Obtiene el peso del animal.
     * @return El peso del animal.
     */
    public double getPeso() { return peso; }

    /**
     * Obtiene el número máximo de animales de esta especie permitidos por ubicación.
     * @return El máximo por ubicación.
     */
    public int getMaxPorUbicacion() { return maxPorUbicacion; }

    /**
     * Obtiene la velocidad máxima de movimiento del animal.
     * @return La velocidad máxima.
     */
    public int getVelocidadMax() { return velocidadMax; }

    /**
     * Obtiene la cantidad de comida necesaria para el animal por turno.
     * @return La comida necesaria.
     */
    public double getComidaNecesaria() { return comidaNecesaria; }

    /**
     * Obtiene el nivel actual de hambre del animal.
     * @return El nivel de hambre.
     */
    public double getNivelHambre() { return nivelHambre; }

    /**
     * Obtiene el nombre de la especie del animal.
     * @return El nombre de la especie.
     */
    public String getEspecie() { return especie; }


    /**
     * Establece el nombre de la especie del animal.
     * @param especie El nombre de la especie.
     */
    protected void setEspecie(String especie) { this.especie = especie; }


    // --- Métodos Abstractos ---
    /**
     * Define el comportamiento de alimentación específico de cada animal.
     * Las subclases deben implementar cómo el animal busca y consume alimento.
     * @param ubicacionActual La {@link Ubicacion} actual del animal.
     * @param isla La {@link Isla} en la que se encuentra el animal.
     */
    public abstract void comer(Ubicacion ubicacionActual, Isla isla);

    /**
     * Define el comportamiento de movimiento específico de cada animal.
     * Las subclases deben implementar cómo el animal se desplaza por la isla.
     * @param ubicacionActual La {@link Ubicacion} actual del animal.
     * @param isla La {@link Isla} en la que se encuentra el animal.
     */
    public abstract void moverse(Ubicacion ubicacionActual, Isla isla);

    /**
     * Define el comportamiento de reproducción específico de cada animal.
     * Las subclases deben implementar las condiciones y el resultado de la reproducción.
     * @param ubicacionActual La {@link Ubicacion} actual donde el animal intenta reproducirse.
     * @return Una nueva instancia de {@link Animal} (la cría) si la reproducción es exitosa, de lo contrario, {@code null}.
     */
    public abstract Animal reproducirse(Ubicacion ubicacionActual);

    /**
     * Obtiene el carácter Unicode que representa visualmente a la especie del animal.
     * @return Un {@link String} que contiene el carácter Unicode.
     */
    public abstract String getUnicode();

    /**
     * Simula un turno de vida para el animal.
     * En cada turno, el animal aumenta su hambre, intenta comer, intenta moverse,
     * e intenta reproducirse. También se verifica si el animal muere por hambre.
     *
     * @param ubicacionActual La {@link Ubicacion} actual del animal.
     * @param isla La {@link Isla} en la que se encuentra el animal.
     */
    public void vivirTurno(Ubicacion ubicacionActual, Isla isla) {
        aumentarHambre(); // El animal siente más hambre al inicio del turno.
        comer(ubicacionActual, isla); // Intenta comer.
        moverse(ubicacionActual, isla); // Intenta moverse a otra ubicación.

        // Intenta reproducirse
        Animal cria = reproducirse(ubicacionActual);
        if (cria != null) { // Si una cría nace
            // Verifica si la ubicación tiene espacio para la nueva cría
            if (ubicacionActual.puedeAgregarAnimal(cria.getEspecie(), cria.getMaxPorUbicacion())) {
                ubicacionActual.agregarAnimal(cria); // Agrega la cría a la ubicación.
                System.out.println("Nació una cría de " + cria.getEspecie() + " en " + ubicacionActual);
            }
        }
    }

    /**
     * Disminuye el nivel de hambre del animal en la cantidad especificada.
     * El nivel de hambre no puede ser menor a cero.
     *
     * @param cantidad La cantidad de alimento consumida que disminuye el hambre.
     */
    protected void disminuirHambre(double cantidad) {
        this.nivelHambre = Math.max(0, this.nivelHambre - cantidad);
    }

    /**
     * Aumenta el nivel de hambre del animal.
     * El hambre aumenta un 20% de la {@link #comidaNecesaria} por turno.
     */
    protected void aumentarHambre() {
        this.nivelHambre += comidaNecesaria * 0.2;
    }

    /**
     * Verifica si el animal ha muerto de hambre.
     * Un animal muere de hambre si su {@link #nivelHambre} es el doble o más de su {@link #comidaNecesaria}.
     *
     * @return {@code true} si el animal está muerto de hambre, {@code false} en caso contrario.
     */
    public boolean estaMuertoDeHambre() {
        return this.nivelHambre >= this.comidaNecesaria * 2;
    }

    /**
     * Calcula una lista de todas las {@link Ubicacion}es posibles a las que el animal puede moverse
     * desde su ubicacionActual dentro de su velocidadMax.
     *
     * @param ubicacionActual La {@link Ubicacion} actual del animal.
     * @param isla La {@link Isla} en la que se encuentra el animal.
     * @param velocidad La velocidad máxima de movimiento del animal (radio de búsqueda).
     * @return Una {@link List} de {@link Ubicacion}es a las que el animal puede moverse.
     */
    protected List<Ubicacion> getPosiblesDestinos(Ubicacion ubicacionActual, Isla isla, int velocidad) {
        List<Ubicacion> destinos = new ArrayList<>();
        int currentX = ubicacionActual.getX();
        int currentY = ubicacionActual.getY();

        // Itera a través de un rango de celdas basado en la velocidad del animal.
        for (int dx = -velocidad; dx <= velocidad; dx++) {
            for (int dy = -velocidad; dy <= velocidad; dy++) {
                // Evita incluir la ubicación actual como un destino válido para el movimiento.
                if (dx == 0 && dy == 0) {
                    continue;
                }

                int newX = currentX + dx;
                int newY = currentY + dy;

                // Obtiene la ubicación candidata de la isla.
                Ubicacion posibleUbicacion = isla.getUbicacion(newX, newY);
                // Si la ubicación existe (está dentro de los límites de la isla), la añade a la lista.
                if (posibleUbicacion != null) {
                    destinos.add(posibleUbicacion);
                }
            }
        }
        return destinos;
    }
}
