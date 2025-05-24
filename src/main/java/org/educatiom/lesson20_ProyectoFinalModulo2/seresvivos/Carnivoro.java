package org.educatiom.lesson20_ProyectoFinalModulo2.seresvivos;

import org.educatiom.lesson20_ProyectoFinalModulo2.modelo.Isla;
import org.educatiom.lesson20_ProyectoFinalModulo2.modelo.Ubicacion;
import org.educatiom.lesson20_ProyectoFinalModulo2.utilidades.TablaProbabilidades;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ThreadLocalRandom;

/**
 * Clase abstracta que representa a los animales carnívoros en la simulación.
 * Extiende la clase {@link Animal} e implementa el comportamiento de alimentación
 * específico para carnívoros (cazar y comer otros animales) y el movimiento.
 */
public abstract class Carnivoro extends Animal {

    /**
     * Constructor para la clase Carnivoro.
     *
     * @param peso El peso del carnívoro.
     * @param maxPorUbicacion El número máximo de individuos de esta especie carnívora permitidos por ubicación.
     * @param velocidadMax La velocidad máxima de movimiento del carnívoro.
     * @param comidaNecesaria La cantidad de comida que el carnívoro necesita por turno.
     */
    public Carnivoro(double peso, int maxPorUbicacion, int velocidadMax, double comidaNecesaria) {
        super(peso, maxPorUbicacion, velocidadMax, comidaNecesaria);
    }

    /**
     * Implementa el comportamiento de alimentación para un carnívoro.
     * El carnívoro intenta comer a otros animales presentes en su ubicación.
     * La probabilidad de cazar una presa específica se obtiene de la {@link TablaProbabilidades}.
     * El carnívoro deja de comer una vez que su nivel de hambre es cero o menos.
     *
     * @param ubicacionActual La {@link Ubicacion} actual del carnívoro.
     * @param isla La {@link Isla} en la que se encuentra el carnívoro (aunque no se usa directamente en esta implementación del método).
     */
    @Override
    public void comer(Ubicacion ubicacionActual, Isla isla) {
        // Si el carnívoro no tiene hambre, no intenta comer.
        if (this.getNivelHambre() <= 0) {
            System.out.println(this.getEspecie() + " " + this.hashCode() + " ya está lleno en " + ubicacionActual);
            return;
        }

        List<Animal> animalesEnUbicacion = ubicacionActual.getAnimalesEnUbicacion();
        for (Animal presaPotencial : new CopyOnWriteArrayList<>(animalesEnUbicacion)) {
            // Un carnívoro no se come a sí mismo ni a otro de su misma especie.
            if (presaPotencial == this || presaPotencial.getEspecie().equals(this.getEspecie())) {
                continue;
            }

            // Obtiene la probabilidad de que este carnívoro coma a esta presa potencial.
            int probabilidad = TablaProbabilidades.getProbabilidad(this.getEspecie(), presaPotencial.getEspecie());

            // Si hay una probabilidad de éxito y el número aleatorio es menor que esa probabilidad.
            if (probabilidad > 0 && ThreadLocalRandom.current().nextDouble(0, 100) < probabilidad) {
                // La comida consumida es igual al peso de la presa.
                double comidaConsumida = presaPotencial.getPeso();

                // Disminuye el hambre del carnívoro.
                this.disminuirHambre(comidaConsumida);

                // La presa es removida de la ubicación.
                ubicacionActual.removerAnimal(presaPotencial);
                System.out.println(this.getEspecie() + " " + this.hashCode() + " comió a " + presaPotencial.getEspecie() + " " + presaPotencial.hashCode() + " en " + ubicacionActual + ". Hambre restante: " + String.format("%.2f", this.getNivelHambre()));

                // Si el carnívoro ya está lleno, deja de buscar más presas.
                if (this.getNivelHambre() <= 0) {
                    break;
                }
            }
        }
    }

    /**
     * Implementa el comportamiento de movimiento para un carnívoro.
     * El carnívoro se mueve a una de las ubicaciones posibles dentro de su rango de velocidad máxima,
     * eligiendo una ubicación aleatoriamente.
     *
     * @param ubicacionActual La {@link Ubicacion} actual del carnívoro.
     * @param isla La {@link Isla} en la que se encuentra el carnívoro.
     */
    @Override
    public void moverse(Ubicacion ubicacionActual, Isla isla) {
        // Obtiene todas las ubicaciones a las que el carnívoro puede moverse.
        List<Ubicacion> posiblesDestinos = getPosiblesDestinos(ubicacionActual, isla, this.velocidadMax);

        // Si hay destinos posibles, elige uno aleatoriamente.
        if (!posiblesDestinos.isEmpty()) {
            Ubicacion nuevaUbicacion = posiblesDestinos.get(ThreadLocalRandom.current().nextInt(posiblesDestinos.size()));

            // Mueve el carnívoro de la ubicación actual a la nueva.
            ubicacionActual.removerAnimal(this);
            nuevaUbicacion.agregarAnimal(this);
            System.out.println(this.getEspecie() + " " + this.hashCode() + " se movió de " + ubicacionActual + " a " + nuevaUbicacion);
        } else {
            // Si no hay destinos posibles, lo notifica.
            System.out.println(this.getEspecie() + " " + this.hashCode() + " no encontró a dónde moverse desde " + ubicacionActual);
        }
    }

}
