package org.educatiom.lesson20_ProyectoFinalModulo2.seresvivos;

import org.educatiom.lesson20_ProyectoFinalModulo2.modelo.Isla;
import org.educatiom.lesson20_ProyectoFinalModulo2.modelo.Ubicacion;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

/**
 * Clase abstracta que representa a los animales herbívoros en la simulación.
 * Extiende la clase {@link Animal} e implementa el comportamiento de alimentación
 * específico para herbívoros (consumir {@link Planta}s) y un movimiento mejorado
 * que prioriza ubicaciones con plantas.
 */
public abstract class Herbivoro extends Animal {

    /**
     * Constructor para la clase Herbivoro.
     *
     * @param peso El peso del herbívoro.
     * @param maxPorUbicacion El número máximo de individuos de esta especie herbívora permitidos por ubicación.
     * @param velocidadMax La velocidad máxima de movimiento del herbívoro.
     * @param comidaNecesaria La cantidad de comida que el herbívoro necesita por turno.
     */
    public Herbivoro(double peso, int maxPorUbicacion, int velocidadMax, double comidaNecesaria) {
        super(peso, maxPorUbicacion, velocidadMax, comidaNecesaria);
        this.setEspecie(this.getClass().getSimpleName());
    }

    /**
     * Implementa el comportamiento de alimentación para un herbívoro.
     * El herbívoro busca y consume plantas presentes en su ubicación actual.
     * Prioriza comer hasta que su nivel de hambre sea cero o se agoten las plantas.
     *
     * @param ubicacionActual La {@link Ubicacion} actual del herbívoro.
     * @param isla La {@link Isla} en la que se encuentra el herbívoro (aunque no se usa directamente en esta implementación del método).
     */
    @Override
    public void comer(Ubicacion ubicacionActual, Isla isla) {
        double comidaConsumida = 0;

        //Crea una nueva lista a partir de la existente para poder modificarla
        List<Planta> plantasDisponibles = new ArrayList<>(ubicacionActual.getPlantasEnUbicacion());
        Iterator<Planta> it = plantasDisponibles.iterator();

        while (it.hasNext() && this.getNivelHambre() > 0) {
            Planta planta = it.next();
            double nutricionDePlanta = planta.getPeso();

            double cantidadAComer = Math.min(nutricionDePlanta, this.getNivelHambre());

            this.disminuirHambre(cantidadAComer);
            comidaConsumida += cantidadAComer;

            it.remove(); // Esto ahora funciona sobre la copia local.

            // IMPORTANTE: Después de remover de la copia local, también debes remover de la lista original de la ubicación
            ubicacionActual.getPlantasEnUbicacion().remove(planta);

            if (this.getNivelHambre() <= 0) {
                break;
            }
        }

        if (comidaConsumida > 0) {
            System.out.println(this.getEspecie() + " " + this.hashCode() + " comió " + String.format("%.2f", comidaConsumida) + " unidades de alimento. Hambre actual: " + String.format("%.2f", this.getNivelHambre()));
        } else {
            System.out.println(this.getEspecie() + " " + this.hashCode() + " no encontró alimento en " + ubicacionActual);
        }
    }

    /**
     * Implementa el comportamiento de movimiento para un herbívoro.
     * El herbívoro prioriza moverse a una {@link Ubicacion} que contenga {@link Planta}s.
     * Si no encuentra ubicaciones con plantas, se mueve a cualquier ubicación posible
     * dentro de su rango de velocidad máxima.
     *
     * @param ubicacionActual La {@link Ubicacion} actual del herbívoro.
     * @param isla La {@link Isla} en la que se encuentra el herbívoro.
     */
    @Override
    public void moverse(Ubicacion ubicacionActual, Isla isla) {
        // Obtiene todas las ubicaciones a las que el herbívoro puede moverse.
        List<Ubicacion> posiblesDestinos = getPosiblesDestinos(ubicacionActual, isla, this.velocidadMax);
        List<Ubicacion> destinosConPlantas = new ArrayList<>();

        // Filtra los destinos para encontrar aquellos que tienen plantas.
        for (Ubicacion destino : posiblesDestinos) {
            if (!destino.getPlantasEnUbicacion().isEmpty()) {
                destinosConPlantas.add(destino);
            }
        }

        Ubicacion nuevaUbicacion = null;
        // Prioriza una ubicación con plantas si hay alguna disponible.
        if (!destinosConPlantas.isEmpty()) {
            nuevaUbicacion = destinosConPlantas.get(ThreadLocalRandom.current().nextInt(destinosConPlantas.size()));
        } else if (!posiblesDestinos.isEmpty()) {
            // Si no hay ubicaciones con plantas, elige una aleatoriamente de todas las posibles.
            nuevaUbicacion = posiblesDestinos.get(ThreadLocalRandom.current().nextInt(posiblesDestinos.size()));
        }

        // Si se encontró una nueva ubicación, mueve el animal.
        if (nuevaUbicacion != null) {
            ubicacionActual.removerAnimal(this);
            nuevaUbicacion.agregarAnimal(this);
            System.out.println(this.getEspecie() + " " + this.hashCode() + " se movió de " + ubicacionActual + " a " + nuevaUbicacion);
        } else {
            // Si no se encontró a dónde moverse.
            System.out.println(this.getEspecie() + " " + this.hashCode() + " no encontró a dónde moverse desde " + ubicacionActual);
        }
    }
}
