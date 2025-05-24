package org.educatiom.lesson18_AnotacionesJava;

public class LombokExample {

    public static void main(String[] args) {

        System.out.println("--------- Lombok ----------");
        //Lombok
        /*Lombok es un complemento del compilador que utiliza anotaciones para ocultar una gran cantidad de código y
        ampliar el lenguaje, lo que simplifica el desarrollo y agrega algunas funciones.*/

        /*
 * ┌──────────────────────┬────────────────────────────────────────────────────────────────────────────────────────────┐
 * │      Anotación       │                                       Descripción                                           │
 * ├──────────────────────┼────────────────────────────────────────────────────────────────────────────────────────────┤
 * │ @ToString            │ Genera una implementación del méthodo toString() que muestra el nombre de la clase,        │
 * │                      │ todos los campos y sus valores.                                                            │
 * │                      │                                                                                           │
 * │ Ejemplo:             │                                                                                           │
 * │ @ToString            │                                                                                           │
 * │ public class Example │                                                                                           │
 * ├──────────────────────┼────────────────────────────────────────────────────────────────────────────────────────────┤
 * │ @EqualsAndHashCode   │ Genera implementaciones de equals() y hashCode() usando campos no estáticos,              │
 * │                      │ configurable según necesidad. Más info: https://projectlombok.org/features/EqualsAndHashCode│
 * ├──────────────────────┼────────────────────────────────────────────────────────────────────────────────────────────┤
 * │ @Getter / @Setter    │ Genera automáticamente los métodos getter y setter para campos privados.                   │
 * │                      │                                                                                           │
 * │ Ejemplo:             │                                                                                           │
 * │ @Getter              │                                                                                           │
 * │ @Setter              │                                                                                           │
 * │ private String name; │                                                                                           │
 * ├──────────────────────┼────────────────────────────────────────────────────────────────────────────────────────────┤
 * │ @NonNull             │ Valida que un parámetro o campo no sea null. Si lo es, lanza NullPointerException.         │
 * │                      │                                                                                           │
 * │ Ejemplo:             │                                                                                           │
 * │ public Example(@NonNull P p) {                                                                                    │
 * │     super("Hello");                                                                                              │
 * │     this.name = p.getName();                                                                                      │
 * │ }                                                                                                                 │
 * └──────────────────────┴────────────────────────────────────────────────────────────────────────────────────────────┘*

    */

    }
}
