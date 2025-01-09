package org.educatiom.lesson02_OOP_SobrecargaAnulacionClasesAbstractas;

public class ModificadoresAccesoExample {

    public static void main(String[] args) {

        System.out.println("--------------------- Modificadores de Acceso ---------------------------");
        //Modificadores de Acceso
        /*Puedes controlar el acceso (visibilidad) que tienen otras clases a los métodos y variables de tu clase.
        Un modificador de acceso responde a la pregunta «¿Quién puede acceder a este method/variable?». Puede
        especificar solo un modificador para cada method o variable*/

        /*
       +--------------------+------------------+----------------+-----------------+------------------+
| Tipo de visibilidad | Palabra clave    | Tu clase       | Tu paquete     | Descendiente     | Todas las clases |
+--------------------+------------------+----------------+-----------------+------------------+
| Privado            | privado          | Sí             | No              | No               | No               |
| Paquete            | (sin modificador)| Sí             | Sí              | No               | No               |
| Protegido          | protegido        | Sí             | Sí              | Sí               | No               |
| Público            | público          | Sí             | Sí              | Sí               | Sí               |
+--------------------+------------------+----------------+-----------------+------------------+

        * */



    }
}
