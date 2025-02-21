package org.educatiom.lesson06_FuncionesLambdaYStreams.Streams.StreamExercise;

/**
 * Ejercicio: Supongamos que tenemos un club para amantes de los animales. Mañana el club celebra el Día del Gato
 * Pelirrojo. El club tiene dueños de mascotas, cada uno de los cuales tiene una lista de mascotas. No se limitan a los
 * gatos.
 * Tarea: debe identificar todos los nombres de todos los gatos pelirrojos para crear tarjetas de felicitación
 * personalizadas para ellos para las "vacaciones profesionales" de mañana. Las tarjetas de felicitación deben ordenarse
 * por la edad del gato, de mayor a menor.
 * @author CodeGym
 */
public class Animal {

    private String name;
    private Color color;
    private int age;

    public Animal(String name, Color color, int age) {
        this.name = name;
        this.color = color;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public Color getColor() {
        return color;
    }

    public int getAge() {
        return age;
    }

}

