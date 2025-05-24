package org.educatiom.lesson20_ProyectoFinalModulo2.modelo;

import org.educatiom.lesson20_ProyectoFinalModulo2.seresvivos.Animal;
import org.educatiom.lesson20_ProyectoFinalModulo2.seresvivos.Planta;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ThreadLocalRandom;

/**
 * Representa la isla donde se desarrolla la simulación del ecosistema.
 * La isla está compuesta por una cuadrícula de {@link Ubicacion}es, donde
 * cada ubicación puede contener plantas y animales.
 */
public class Isla {

    private Ubicacion[][] cuadricula;
    private int filas;
    private int columnas;

    /**
     * Constructor de la clase Isla.
     * Inicializa la cuadrícula de la isla con las dimensiones especificadas y crea una nueva {@link Ubicacion}
     * para cada celda de la cuadrícula.
     *
     * @param filas El número de filas de la isla.
     * @param columnas El número de columnas de la isla.
     */
    public Isla(int filas, int columnas) {
        this.filas = filas;
        this.columnas = columnas;
        this.cuadricula = new Ubicacion[filas][columnas];
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                cuadricula[i][j] = new Ubicacion(i, j);
            }
        }
    }


    /**
     * Obtiene la ubicación en las coordenadas (x, y) especificadas.
     *
     * @param x La coordenada X (fila) de la ubicación.
     * @param y La coordenada Y (columna) de la ubicación.
     * @return La {@link Ubicacion} en las coordenadas dadas, o {@code null} si las coordenadas están fuera de los límites de la isla.
     */
    public Ubicacion getUbicacion(int x, int y) {
        if (x >= 0 && x < filas && y >= 0 && y < columnas) {
            return cuadricula[x][y];
        }
        return null;
    }

    /**
     * Busca y devuelve la {@link Ubicacion} actual de un animal específico en la isla.
     *
     * @param animal El {@link Animal} cuya ubicación se desea encontrar.
     * @return La {@link Ubicacion} donde se encuentra el animal, o {@code null} si el animal no se encuentra en ninguna ubicación de la isla.
     */
    public Ubicacion getUbicacionDeAnimal(Animal animal) {
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                if (cuadricula[i][j].getAnimalesEnUbicacion().contains(animal)) {
                    return cuadricula[i][j];
                }
            }
        }
        return null;
    }

    /**
     * Genera nuevas plantas en ubicaciones aleatorias de la isla.
     * Cada ubicación tiene una probabilidad del 50% de generar una nueva planta en cada turno,
     * siempre que no se supere un límite de 10 plantas por ubicación y un máximo de 20 nuevas plantas por turno en toda la isla.
     */
    public void generarNuevasPlantas() {
        int plantasNacidas = 0;
        int maxNuevasPlantasPorTurno = 20; // Límite de nuevas plantas que pueden nacer en un turno en toda la isla.
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                Ubicacion u = cuadricula[i][j];
                // 50% de probabilidad de generar una planta en esta ubicación.
                if (ThreadLocalRandom.current().nextDouble(0, 100) < 50 && plantasNacidas < maxNuevasPlantasPorTurno) {
                    // Límite de 10 plantas por ubicación para evitar sobrepoblación en una celda.
                    if (u.getPlantasEnUbicacion().size() < 10) {
                        u.agregarPlanta(new Planta(1.0)); // Se añade una nueva planta con peso 1.0.
                        plantasNacidas++;
                    }
                }
            }
        }
    }

    /**
     * Imprime en la consola las estadísticas actuales de la isla,
     * incluyendo el total de animales, el total de plantas y la distribución
     * de animales por especie.
     */
    public void imprimirEstadisticas() {
        System.out.println("--- Estadísticas de la Isla ---");
        int totalAnimales = 0;
        int totalPlantas = 0;
        // Mapa para almacenar el conteo de cada especie de animal.
        Map<String, Integer> animalesPorEspecie = new HashMap<>();

        // Itera sobre todas las ubicaciones para recolectar datos.
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                Ubicacion ubicacion = cuadricula[i][j];
                totalPlantas += ubicacion.getPlantasEnUbicacion().size();
                for (Animal animal : ubicacion.getAnimalesEnUbicacion()) {
                    totalAnimales++;
                    // Incrementa el contador para la especie del animal o lo inicializa en 1 si es la primera vez que se encuentra.
                    animalesPorEspecie.put(animal.getEspecie(), animalesPorEspecie.getOrDefault(animal.getEspecie(), 0) + 1);
                }
            }
        }

        System.out.println("Total de Animales: " + totalAnimales);
        System.out.println("Total de Plantas: " + totalPlantas);
        System.out.println("Animales por especie:");
        if (animalesPorEspecie.isEmpty()) {
            System.out.println("  No hay animales vivos.");
        } else {
            // Imprime el conteo para cada especie.
            animalesPorEspecie.forEach((especie, cantidad) -> System.out.println("  " + especie + ": " + cantidad));
        }
    }

    /**
     * Obtiene un mapa que asocia cada {@link Ubicacion} con la lista de {@link Animal}es que contiene.
     * Solo se incluyen las ubicaciones que tienen animales.
     *
     * @return Un {@link Map} donde la clave es una {@link Ubicacion} y el valor es una {@link List} de {@link Animal}es en esa ubicación.
     */
    public Map<Ubicacion, List<Animal>> getAnimalesEnUbicacion() {
        Map<Ubicacion, List<Animal>> animalesEnUbicacion = new HashMap<>();
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                Ubicacion ubicacion = cuadricula[i][j];
                if (!ubicacion.getAnimalesEnUbicacion().isEmpty()) {
                    animalesEnUbicacion.put(ubicacion, ubicacion.getAnimalesEnUbicacion());
                }
            }
        }
        return animalesEnUbicacion;
    }

}
