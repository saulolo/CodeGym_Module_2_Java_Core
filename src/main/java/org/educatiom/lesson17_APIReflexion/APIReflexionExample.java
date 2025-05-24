package org.educatiom.lesson17_APIReflexion;

public class APIReflexionExample {

    public static void main(String[] args) {

        System.out.println("--------- API Reflexion ----------");
        //API Reflexion
        /*El mecanismo de reflexión de Java permite a un desarrollador realizar cambios y obtener información sobre
        clases, interfaces, campos y métodos en tiempo de ejecución sin conocer sus nombres.

        La API de Reflection también le permite crear nuevos objetos, llamar a métodos y obtener o establecer valores de
        campo.

        Hagamos una lista de lo que puedes hacer usando la reflexión:
        - Identificar/determinar la clase de un objeto
        - Obtenga información sobre modificadores de clase, campos, métodos, constantes, constructores y superclases
        - Averigüe qué métodos pertenecen a la(s) interfaz(es) implementada(s)
        - Cree una instancia de una clase cuyo nombre de clase no se conozca hasta que se ejecute el programa
        - Obtener y establecer el valor de un campo de instancia por nombre
        - Llamar a un method de instancia por su nombre.

        Si nunca antes se ha encontrado con estos mecanismos, probablemente se esté preguntando por qué es necesario
        de esto. La respuesta es bastante simple pero también muy vaga: la reflexión aumenta drásticamente la flexibilidad
        y la capacidad de personalizar nuestra aplicación y código.

        Pero siempre hay pros y contras. Así que vamos a mencionar algunos contras:
        - Violaciones de la seguridad de la aplicación. Reflection nos permite acceder a código que no deberíamos
        (violación de encapsulación).
        - Restricciones de seguridad. Reflection requiere permisos de tiempo de ejecución que no están disponibles para
        los sistemas que ejecutan un administrador de seguridad.
        - Bajo rendimiento. Reflection en Java determina los tipos dinámicamente escaneando el classpath para encontrar
        la clase a cargar. Esto reduce el rendimiento del programa.
        - Difícil de mantener. El código que utiliza la reflexión es difícil de leer y depurar. Es menos flexible y más
        difícil de mantener

        También existen métodos que le permiten obtener o establecer valores de campo y acceder a campos privados .
        Los veremos un poco más tarde.

        Principales métodos de la clase java.lang.reflect.Field :
        - getType(): Retorna un objeto de clase que identifica el tipo declarado para el campo representado por este
        objeto Field.
        - getAnnotatedType(): Retorna un objeto de tipo annotatedType que representa el uso del tipo para especificar el
        tipo declarado del campo.
        - getGenericType(): Retorna un objeto Type que representa el tipo declarado para el campo representado por este
        objeto Field.
        - getName(): Retorna el nombre del campo representado por el objeto Field.
        - getModifiers(): Retorna los modificadores del campo representado por este objeto Field en forma de un entero.
        La clase Modifier debe utilizarse para descodificar los modificadores.
        - getAnnotation (Class<T> annotationClass): Retorna la anotación del elemento para el tipo especificado, si
        dicha anotación está presente; de lo contrario, retorna null.
        - getAnnotationsByType (Class<T> annotationClass): Retorna las anotaciones asociadas con elelemento. Si no hay
        anotaciones asociadas con este elemento, el valor de retorno es un arreglo de longitud cero.
         */

    }
}
