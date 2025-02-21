package org.educatiom.lesson07_ConversionDeTiposInstanceofExpressionSwitch;


public class InstanceofExample {

    public static void main(String[] args) {

        System.out.println("--------------------- Instanceof ---------------------------");
        //Instanceof
        /*Comprueba si un objeto es una instancia de una clase en particular.
        * Se usa asi: «objeto» instancia de «clase». */

        //El operador instanceof se ve así: una instancia de B.
        /*
        * En otras palabras, el operador instanceof devolverá verdadero si:
        * 1) la variable a almacena una referencia a un objeto de tipo B
        * 2)  la variable a almacena una referencia a un objeto cuya clase hereda  B
        * 3)  la variable a almacena una referencia a un objeto que implementa la interfaz  B
        * De lo contrario, el operador instanceof devolverá false
        * */

        Object o = 3;
        boolean isInt = o instanceof Integer; //true

        Object o1 = "Hola mundo";
        boolean isInt2 = o1 instanceof Integer; //false


        //Este operador tambien da cuenta de la herencia.

        class Animal{

        }

        class Cat extends Animal{

        }

        class Tiger extends Cat{

        }

        Object object = new Tiger();
        boolean isCat = object instanceof Cat; //true
        boolean isTiger = object instanceof Tiger; //true
        boolean isAnimal = object instanceof Animal; //true

        Object object1 = new Animal();
        boolean isCat2 = object1 instanceof Cat; //false
        boolean isTiger2 = object1 instanceof Tiger; //false
        boolean isAnimnal = object1 instanceof Animal; //true


        //Este operador tambien da cuenta de la interface.
        interface Moveable{

        }

        class Cat2{

        }

        class TomCat extends Cat2 implements Moveable{

        }

        Cat2 object2 = new TomCat();
        boolean isCat3 = o instanceof Cat2; //false
        boolean isMoveable = o instanceof Moveable; //false
        boolean isTom = o instanceof TomCat; //false

        Cat2 object3 = new Cat2();
        boolean isCat4 = object3 instanceof Cat2; //true
        boolean isMoveable2 = object3 instanceof Moveable; //false
        boolean isTom2 = object3 instanceof TomCat; //false

    }
}
