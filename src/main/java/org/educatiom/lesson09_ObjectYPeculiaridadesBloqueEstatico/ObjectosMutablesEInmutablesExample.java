package org.educatiom.lesson09_ObjectYPeculiaridadesBloqueEstatico;

public class ObjectosMutablesEInmutablesExample {

    public static void main(String[] args) {

        System.out.println("--------------------- Objetos Mutables e Inmutables ---------------------");
        //Objetos Mutables e Inmutable
        /*"Los objetos que puede cambiar después de crearlos se denominan mutables".
        * "Los objetos que no se pueden cambiar después de su creación se denominan inmutables ".*/

        /*"El autor de una nueva clase puede hacer que los objetos de esa clase sean inmutables. Por ejemplo, si hace
        que todos los establecedores sean privados, entonces un objeto solo tendrá un constructor y captadores; eso
        significa que será imposible cambiarlo después de que se haya creado."*/

        /*"Los objetos inmutables tienen muchas propiedades útiles, pero destacaré dos que son comunes a casi todos los
        objetos inmutables:"
        1) Los objetos inmutables son mucho más fáciles de implementar que los objetos mutables.
        2) Los objetos inmutables se pueden usar libremente en múltiples subprocesos simultáneamente.*/
        /*"Por lo general, las clases inmutables contienen varios métodos que actúan como si cambiaran el objeto, pero
        estos métodos simplemente crean un nuevo objeto y lo devuelven, en lugar de cambiar el objeto en sí".*/

        String s = "london";
        String s1 = s.toUpperCase();
        System.out.println("s1 = " + s1); //LONDON

        /*"La clase String es una clase inmutable. Todos los objetos String son inmutables, pero eso no nos impide
        trabajar con ellos. Por ejemplo, el method toUpperCase () de la clase String convierte una cadena a mayúsculas
        (es decir, reemplaza todas las letras minúsculas con letras mayúsculas). Sin embargo, este method no cambia la
        Cadena en sí, sino que devuelve una nueva Cadena. Esta nueva Cadena es idéntica a la primera, excepto que todos
        los caracteres están en mayúsculas (letras mayúsculas)"*/


    }
}
