package org.educatiom.lesson07_ConversionDeTiposInstanceofExpressionSwitch;

public class AmpliacionYReduccionDeConversionDeTipos {

    public static void main(String[] args) {

        System.out.println("----------- Ampliacion Y Reduccion De Conversion De Tipos -----------------");
        //Ampliacion Y Reduccion De Conversion De Tipos
        /* Debido a que una clase contiene todos los métodos miembros de la clase que hereda , una instancia de la clase
        se puede guardar en una variable cuyo tipo sea el de cualquiera de sus padres.*/

        class Animal {

            public void doAnimalActions() {

            }

            class Cat extends Animal {

                public void doCatActions() {

                }
            }

            class Tiger extends Cat {

                public void doTigerActions() {

                }
            }

            Tiger tiger = new Tiger();
            Cat cat = new Tiger();
            Animal animal = new Tiger();
            Object object = new Tiger();
            /*Un objeto Tiger siempre se puede asignar a una variable cuyo tipo sea el de uno de sus ancestros.
            Para la clase Tigre, estos son Gato, Animal y Objeto.*/


            /* CONVERSION DE AMPLIACIÓN Y REDUCCIÓN */
        /*Si una operación de asignación hace que avancemos en la cadena de herencia (hacia la clase Object), estamos
        tratando con una conversión ampliada (también conocida como upcasting). Si nos movemos hacia abajo en la cadena
        hacia el tipo de objeto, entonces es una conversión de reducción (también conocida como reducción).

        Avanzar en la cadena de herencia se denomina ampliación, porque conduce a un tipo más general. Sin embargo,
        al hacerlo, perdemos la capacidad de invocar los métodos agregados a la clase a través de la herencia.*/

            Object obj = new Tiger();
            Animal animal2 = (Animal) obj;
            Cat cat2 = (Cat) obj;
            Tiger tiger2 = (Tiger) animal2;
            Tiger tiger3 = (Tiger) cat2;

            /*Al restringir el tipo, debe usar un operador de conversión de tipo, es decir, realizamos una conversión
            explícita. Esto hace que la máquina Java compruebe si el objeto realmente hereda el tipo al que queremos
            convertirlo.
            Esta pequeña innovación produjo una reducción múltiple en la cantidad de errores de conversión de tipos y
            aumentó significativamente la estabilidad de los programas Java.*/
        }




    }


}
