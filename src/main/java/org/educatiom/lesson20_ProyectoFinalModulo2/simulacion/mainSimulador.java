package org.educatiom.lesson20_ProyectoFinalModulo2.simulacion;

import org.educatiom.lesson20_ProyectoFinalModulo2.modelo.Isla;
import org.educatiom.lesson20_ProyectoFinalModulo2.modelo.Ubicacion;
import org.educatiom.lesson20_ProyectoFinalModulo2.seresvivos.Animal;
import org.educatiom.lesson20_ProyectoFinalModulo2.seresvivos.Conejo;
import org.educatiom.lesson20_ProyectoFinalModulo2.seresvivos.Planta;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ThreadLocalRandom;

/**
 * Clase principal que orquesta la simulación de la isla.
 * Se encarga de inicializar la isla, poblar animales y plantas,
 * y ejecutar los turnos de la simulación, gestionando el ciclo de vida de los seres vivos.
 */
public class mainSimulador {

    private static Isla isla;
    private static final int NUM_TURNOS = 10;
    private static final int FILAS = 5;
    private static final int COLUMNAS = 5;

    /**
     * Método principal que inicia y controla el flujo de la simulación.
     * <ol>
     * <li>Inicializa la isla con las dimensiones predefinidas.</li>
     * <li>Puebla la isla con una cantidad inicial de plantas y animales.</li>
     * <li>Ejecuta un número predefinido de turnos, realizando acciones de simulación en cada uno.</li>
     * <li>Imprime estadísticas de la isla al inicio y al final de cada turno.</li>
     * </ol>
     *
     * @param args Argumentos de la línea de comandos (no utilizados en esta simulación).
     */
    public static void main(String[] args) {
        System.out.println("Iniciando simulación de la Isla...");
        isla = new Isla(FILAS, COLUMNAS); // Crea una nueva instancia de Isla.

        poblarIslaInicialmente(); // Llama al method para poblar la isla al inicio.
        isla.imprimirEstadisticas(); // Imprime las estadísticas iniciales de la isla.

        // Bucle principal de la simulación, ejecuta un número fijo de turnos.
        for (int turno = 1; turno <= NUM_TURNOS; turno++) {
            System.out.println("\n--- Turno " + turno + " ---");
            realizarTurno(); // Ejecuta las acciones para el turno actual.
            isla.imprimirEstadisticas(); // Imprime las estadísticas después de cada turno.
        }

        System.out.println("\nSimulación finalizada después de " + NUM_TURNOS + " turnos.");
    }

    /**
     * Pueblab la {@link Isla} con una cantidad inicial de plantas y un tipo específico de animal.
     * <p>
     * Actualmente, cada ubicación de la isla se puebla con 5 {@link Planta}s,
     * y se añaden 10 {@link Conejo}s en ubicaciones aleatorias.
     * </p>
     */
    private static void poblarIslaInicialmente() {
        // Poblar la isla con plantas en cada ubicación.
        for (int i = 0; i < FILAS; i++) {
            for (int j = 0; j < COLUMNAS; j++) {
                for (int k = 0; k < 5; k++) { // Añade 5 plantas por celda al inicio.
                    isla.getUbicacion(i, j).agregarPlanta(new Planta(1.0)); // Planta con peso 1.0.
                }
            }
        }
        System.out.println("Isla poblada con plantas.");

        // Poblar la isla con una cantidad inicial de conejos en ubicaciones aleatorias.
        int numConejos = 10; // Cantidad inicial de conejos.
        for (int i = 0; i < numConejos; i++) {
            int randomX = ThreadLocalRandom.current().nextInt(FILAS);
            int randomY = ThreadLocalRandom.current().nextInt(COLUMNAS);
            Ubicacion ubicacionInicial = isla.getUbicacion(randomX, randomY);

            Conejo nuevoConejo = new Conejo(); // Crea una nueva instancia de Conejo.
            // Verifica si la ubicación puede agregar el nuevo animal antes de añadirlo.
            if (ubicacionInicial.puedeAgregarAnimal(nuevoConejo.getEspecie(), nuevoConejo.getMaxPorUbicacion())) {
                ubicacionInicial.agregarAnimal(nuevoConejo);
            }
        }
        System.out.println("Isla poblada con animales.");
    }

    /**
     * Realiza un único turno de la simulación. En cada turno, se llevan a cabo las siguientes acciones:
     * <ol>
     * <li>Itera sobre todos los animales vivos en la isla para que realicen sus acciones (comer, moverse, reproducirse).</li>
     * <li>Identifica y marca los animales que mueren de hambre durante sus acciones.</li>
     * <li>Remueve los animales muertos de sus respectivas ubicaciones en la isla.</li>
     * <li>Genera nuevas plantas en la isla para reponer el alimento.</li>
     * </ol>
     * Se utiliza una {@link CopyOnWriteArrayList} para iterar sobre los animales,
     * lo que permite modificaciones seguras a las listas subyacentes de animales por ubicación
     * (por ejemplo, remoción de animales por depredación o adición de crías).
     */
    private static void realizarTurno() {
        List<Animal> animalesParaRemover = new ArrayList<>(); // Lista para almacenar animales que morirán en este turno.

        // Obtiene una lista temporal de todos los animales presentes en la isla al inicio del turno.
        // Se usa CopyOnWriteArrayList para garantizar la seguridad en hilos y evitar
        // ConcurrentModificationException si los animales se mueven o son eliminados/añadidos durante la iteración.
        List<Animal> todosLosAnimalesEnEsteTurno = new CopyOnWriteArrayList<>();
        for (List<Animal> animalesList : isla.getAnimalesEnUbicacion().values()) {
            todosLosAnimalesEnEsteTurno.addAll(animalesList);
        }

        // 1. Proceso de los animales (comer, moverse, intentar reproducirse)
        for (Animal animal : todosLosAnimalesEnEsteTurno) {
            // Verifica que el animal aún exista en la isla y no haya sido marcado para remoción previamente en este turno.
            Ubicacion ubicacionActual = isla.getUbicacionDeAnimal(animal);

            if (ubicacionActual != null && !animalesParaRemover.contains(animal)) {
                animal.vivirTurno(ubicacionActual, isla); // El animal realiza sus acciones de vida.
                if (animal.estaMuertoDeHambre()) {
                    animalesParaRemover.add(animal); // Si el animal muere de hambre, se añade a la lista para remoción.
                }
            }
        }

        // 2. Aplicar las remociones (muertes) después de que todos los animales han actuado.
        for (Animal animalMuerto : animalesParaRemover) {
            Ubicacion ubicacion = isla.getUbicacionDeAnimal(animalMuerto);
            if (ubicacion != null) {
                ubicacion.removerAnimal(animalMuerto); // Remueve el animal muerto de su ubicación.
                System.out.println("  " + animalMuerto.getEspecie() + " " + animalMuerto.hashCode() + " ha muerto de hambre en " + ubicacion + ".");
            }
        }

        // 3. Generar nuevas plantas para reponer los recursos.
        isla.generarNuevasPlantas();
    }
}
