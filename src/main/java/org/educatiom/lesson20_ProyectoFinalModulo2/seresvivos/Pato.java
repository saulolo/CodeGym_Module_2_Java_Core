package org.educatiom.lesson20_ProyectoFinalModulo2.seresvivos;

import org.educatiom.lesson20_ProyectoFinalModulo2.modelo.Isla;
import org.educatiom.lesson20_ProyectoFinalModulo2.modelo.Ubicacion;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ThreadLocalRandom;

/**
 * Representa una especie de Pato en la simulación. Los Patos son una subclase de {@link Herbivoro},
 * pero tienen un comportamiento de alimentación mixto, pudiendo comer también {@link Oruga}s antes que plantas.
 * Define las características específicas de los patos como su peso, límite por ubicación,
 * velocidad máxima, comida necesaria y su representación Unicode.
 */
public class Pato extends Herbivoro{

    private static final double PESO_DEFECTO = 1;
    private static final int MAX_POR_UBICACION_DEFECTO = 200;
    private static final int VELOCIDAD_MAX_DEFECTO = 4;
    private static final double COMIDA_NECESARIA_DEFECTO = 0.15;
    private static final String UNICODE = "🦆";

    /**
     * Constructor para crear una nueva instancia de Pato.
     * Inicializa el Pato con los valores por defecto de peso, máximo por ubicación,
     * velocidad máxima y comida necesaria, y establece su especie.
     */
    public Pato() {
        super(PESO_DEFECTO, MAX_POR_UBICACION_DEFECTO, VELOCIDAD_MAX_DEFECTO, COMIDA_NECESARIA_DEFECTO);
    }

    /**
     * Define el comportamiento de alimentación de un Pato.
     * Un Pato intentará comer {@link Oruga}s primero con una probabilidad del 90%.
     * Si no encuentra orugas o aún tiene hambre, recurrirá a la lógica de alimentación
     * de su superclase {@link Herbivoro} (comer plantas).
     *
     * @param ubicacionActual La {@link Ubicacion} actual del Pato.
     * @param isla La {@link Isla} en la que se encuentra el Pato (no se usa directamente en este método).
     */
    @Override
    public void comer(Ubicacion ubicacionActual, Isla isla) {
        // Si el pato no tiene hambre, no intenta comer.
        if (this.getNivelHambre() <= 0) {
            System.out.println(this.getEspecie() + " " + this.hashCode() + " ya está lleno en " + ubicacionActual);
            return;
        }

        boolean comioOruga = false;
        // Intenta comer orugas si aún tiene hambre.
        if (this.getNivelHambre() > 0) {
            // Se crea una copia para evitar ConcurrentModificationException.
            List<Animal> animalesEnUbicacion = ubicacionActual.getAnimalesEnUbicacion();
            for (Animal presaPotencial : new CopyOnWriteArrayList<>(animalesEnUbicacion)) {
                // Si la presa potencial es una Oruga.
                if (presaPotencial.getEspecie().equals("Oruga")) {
                    int probabilidad = 90; // 90% de probabilidad de comer una Oruga.
                    // Si la probabilidad se cumple.
                    if (ThreadLocalRandom.current().nextDouble(0, 100) < probabilidad) {
                        double comidaConsumida = presaPotencial.getPeso();

                        this.disminuirHambre(comidaConsumida); // Disminuye el hambre del pato.

                        ubicacionActual.removerAnimal(presaPotencial); // Remueve la oruga de la ubicación.
                        System.out.println(this.getEspecie() + " " + this.hashCode() + " comió una Oruga " + presaPotencial.hashCode() + " en " + ubicacionActual + ". Hambre restante: " + String.format("%.2f", this.getNivelHambre()));
                        comioOruga = true;
                        // Si el pato ya está lleno, deja de buscar más orugas.
                        if (this.getNivelHambre() <= 0) {
                            break;
                        }
                    }
                }
            }
        }

        // Si el pato aún tiene hambre y no comió orugas, intenta comer plantas (comportamiento de Herbivoro).
        if (this.getNivelHambre() > 0 && !comioOruga) {
            super.comer(ubicacionActual, isla);
        }
    }

    /**
     * Define el comportamiento de movimiento de un Pato.
     * Delega la lógica de movimiento a la implementación de la superclase {@link Herbivoro},
     * lo que implica que priorizará moverse a ubicaciones con plantas.
     *
     * @param ubicacionActual La {@link Ubicacion} actual del Pato.
     * @param isla La {@link Isla} en la que se encuentra el Pato.
     */
    @Override
    public void moverse(Ubicacion ubicacionActual, Isla isla) {
        super.moverse(ubicacionActual, isla);
    }

    /**
     * Define el comportamiento de reproducción de un Pato.
     * Un Pato intenta reproducirse si no tiene demasiada hambre, hay al menos dos Patos en la misma ubicación
     * y la ubicación tiene espacio para una nueva cría de Pato. Hay una probabilidad fija del 80% de éxito.
     *
     * @param ubicacionActual La {@link Ubicacion} actual donde el Pato intenta reproducirse.
     * @return Una nueva instancia de {@link Pato} si la reproducción es exitosa, de lo contrario, {@code null}.
     */
    @Override
    public Animal reproducirse(Ubicacion ubicacionActual) {
        // Se verifica que el pato no tenga demasiada hambre para reproducirse.
        if (this.getNivelHambre() >= this.getComidaNecesaria() * 0.5) {
            System.out.println(this.getEspecie() + " " + this.hashCode() + " tiene demasiada hambre para reproducirse en " + ubicacionActual + ".");
            return null; // Un pato hambriento no se reproduce.
        }
        long patosPresentes = ubicacionActual.contarAnimalesDeEspecie(this.getEspecie());

        // Si hay al menos dos patos y la ubicación puede aceptar más de esta especie.
        if (patosPresentes >= 2 && ubicacionActual.puedeAgregarAnimal(this.getEspecie(), this.maxPorUbicacion)) {
            // Aplica una probabilidad de reproducción del 80%.
            if (ThreadLocalRandom.current().nextDouble(0, 100) < 80) {
                System.out.println("Pato " + this.hashCode() + " se reproduce con éxito en " + ubicacionActual + ".");
                return new Pato(); // Devuelve una nueva cría de Pato.
            } else {
                System.out.println("Pato " + this.hashCode() + " intentó reproducirse pero falló en " + ubicacionActual + ".");
            }
        }
        return null; // No se reproduce si las condiciones no se cumplen o la probabilidad falla.
    }

    /**
     * Obtiene el carácter Unicode que representa a un Pato.
     *
     * @return El String Unicode para un Pato.
     */
    @Override
    public String getUnicode() {
        return UNICODE;
    }
}
