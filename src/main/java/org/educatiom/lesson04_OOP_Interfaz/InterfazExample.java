package org.educatiom.lesson04_OOP_Interfaz;

public class InterfazExample {

    public static void main(String[] args) {

        System.out.println("--------------------- Interfaz ---------------------------");
        //Interfaz
        /*Una interfaz es hija de Abstracción y Polimorfismo. La interfaz es muy parecida a una clase abstracta donde
        todos los métodos son abstractos. Se declara de la misma manera que una clase, pero con la palabra clave interface.
        - Una interfaz solo puede heredar otras interfaces.
        - Una clase puede heredar varias interfaces (y solo una clase). Para mostrar esta herencia, usamos la palabra
        clave implements
        Las interfaces tienen dos fuertes ventajas sobre las clases:
        1) Separación de "definiciones de métodos" de implementaciones de métodos.
        2) Herencia múltiple.

        Ejemplo, elementos como automóviles, bicicletas, motocicletas y ruedas se representan mejor como clases y objetos.
        Pero sus habilidades, como «Puedo moverme», «Puedo llevar personas» y «Puedo estacionar», están mejor
        representadas como interfaces.

        La mayoría de las veces una clase es un modelo de un objeto en particular. Por el contrario, las interfaces son
        más como las habilidades o habilidades de un objeto. roles, en lugar del objeto mismo".

        ¿Porque existen las interfaces?
        Los métodos son acciones realizadas sobre un objeto, sobre sus datos. Y si una clase implementa ciertos métodos,
        entonces “soporta la ejecución” de ciertos comandos. ¿Qué ganamos al combinar métodos en una interfaz?
        1) Cada interfaz , al igual que una clase , tiene un nombre único. Ambas partes pueden estar 100% seguras de que
        la otra parte admite la interfaz exacta que conocen y no una interfaz similar.
        2) Cada interfaz impone ciertas restricciones a una clase que la va a soportar. La clase (su desarrollador)
        decide qué hará cuando se llame a los métodos heredados de una interfaz, pero el resultado debe estar dentro de
        los límites de las expectativas razonables. Si le ordenamos a un perro que se "siente" y luego rueda en su lugar
        durante 5 minutos y luego se sienta, entonces es compatible con la interfaz. Pero si, en cambio, te agarra por
        la pierna, difícilmente podemos decir que es compatible con la interfaz. Ejecutar el comando no produjo el
        resultado esperado.
        */

        //Herencia Múltiple en Java
        /*Java no permite herencia múltiple de clases para mantener la simplicidad, evitar ambigüedades y fomentar un
        diseño claro y robusto utilizando interfaces y composición. */

        //Diferencias entre una clase abstracta y una interfaz
        /*Una clase abstracta puede heredar solo una clase pero puede heredar cualquier número de interfaces.
        Una interfaz no puede heredar clases , pero puede heredar cualquier número de interfaces.

        Una clase abstracta puede contener métodos abstractos. Pero puede que no tenga ninguno en absoluto.
        Todos los métodos no estáticos y no predeterminados de una interfaz son abstractos , es decir, no tienen
        implementación. Una interfaz no puede tener ningún método.

        Una clase abstracta puede contener métodos con una implementación.
        Una interfaz puede tener métodos predeterminados.

        Datos: Sin restricciones.
        Una interfaz contiene solo datos estáticos finales públicos.

        No puede crear una instancia de una clase abstracta.
        No puede crear una instancia de una interfaz.


        */

    }
}
