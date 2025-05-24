package org.educatiom.lesson20_ProyectoFinalModulo2.modelo;

import org.educatiom.lesson20_ProyectoFinalModulo2.seresvivos.Animal;
import org.educatiom.lesson20_ProyectoFinalModulo2.seresvivos.Planta;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * Representa una ubicación individual (celda) dentro de la {@link Isla}.
 * Cada ubicación puede contener una colección de animales y plantas,
 * y tiene coordenadas X e Y fijas.
 */
public class Ubicacion {

    private final int x;
    private final int y;
    private List<Animal> animalesEnUbicacion;
    private List<Planta> plantasEnUbicacion;

    /**
     * Constructor para crear una nueva ubicación con coordenadas específicas.
     * Inicializa las listas de animales y plantas como {@link CopyOnWriteArrayList}s vacías.
     *
     * @param x La coordenada X (fila) de la ubicación.
     * @param y La coordenada Y (columna) de la ubicación.
     */
    public Ubicacion(int x, int y) {
        this.x = x;
        this.y = y;
        this.animalesEnUbicacion = new CopyOnWriteArrayList<>();
        this.plantasEnUbicacion = new CopyOnWriteArrayList<>();
    }

    /**
     * Obtiene la lista de {@link Animal}es actualmente en esta ubicación.
     *
     * @return Una {@link List} de animales en la ubicación.
     */
    public List<Animal> getAnimalesEnUbicacion() {
        return animalesEnUbicacion;
    }

    /**
     * Obtiene la lista de {@link Planta}s actualmente en esta ubicación.
     *
     * @return Una {@link List} de plantas en la ubicación.
     */
    public List<Planta> getPlantasEnUbicacion() {
        return plantasEnUbicacion;
    }

    /**
     * Obtiene la coordenada X (fila) de esta ubicación.
     *
     * @return La coordenada X.
     */
    public int getX() {
        return x;
    }

    /**
     * Obtiene la coordenada Y (columna) de esta ubicación.
     *
     * @return La coordenada Y.
     */
    public int getY() {
        return y;
    }

    /**
     * Agrega un {@link Animal} a esta ubicación.
     *
     * @param animal El animal a agregar.
     */
    public void agregarAnimal(Animal animal) {
        this.animalesEnUbicacion.add(animal);
    }

    /**
     * Remueve un {@link Animal} de esta ubicación.
     *
     * @param animal El animal a remover.
     */
    public void removerAnimal(Animal animal) {
        this.animalesEnUbicacion.remove(animal);
    }

    /**
     * Agrega una {@link Planta} a esta ubicación.
     *
     * @param planta La planta a agregar.
     */
    public void agregarPlanta(Planta planta) {
        this.plantasEnUbicacion.add(planta);
    }

    /**
     * Cuenta el número de animales de una especie específica en esta ubicación.
     *
     * @param especie El nombre de la especie a contar.
     * @return El número de animales de la especie especificada en esta ubicación.
     */
    public long contarAnimalesDeEspecie(String especie) {
        return animalesEnUbicacion.stream()
                .filter(animal -> animal.getEspecie().equals(especie))
                .count();
    }

    /**
     * Verifica si se puede agregar un nuevo animal de una especie dada a esta ubicación,
     * basándose en un límite máximo de animales por especie.
     *
     * @param especie El nombre de la especie del animal que se intenta agregar.
     * @param maxPorUbicacion El número máximo de animales de esa especie permitidos en esta ubicación.
     * @return {@code true} si se puede agregar el animal (es decir, el conteo actual es menor que el máximo permitido),
     * {@code false} en caso contrario.
     */
    public boolean puedeAgregarAnimal(String especie, int maxPorUbicacion) {
        return contarAnimalesDeEspecie(especie) < maxPorUbicacion;
    }

    /**
     * Devuelve una representación en cadena de esta ubicación, mostrando sus coordenadas.
     *
     * @return Una cadena en el formato "Ubicacion(X,Y)".
     */
    @Override
    public String toString() {
        return "Ubicacion(" + x + "," + y + ")";
    }

}
