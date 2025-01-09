package org.educatiom.lesson02_OOP_SobrecargaAnulacionClasesAbstractas;

import org.educatiom.lesson02_OOP_SobrecargaAnulacionClasesAbstractas.ClaseAbstractaExample.Car;
import org.educatiom.lesson02_OOP_SobrecargaAnulacionClasesAbstractas.ClaseAbstractaExample.Sedan;

public class ClasesAbstractarsExample {

    public static void main(String[] args) {

        System.out.println("--------------------- Clases Abstractas ---------------------------");
        //Clases Abstractas
        /*¿Qué es una clase base ? Tiene que ver con el hecho de que en Java varias clases diferentes pueden tener un origen común. */
        /*1. Una clase abstracta puede declarar métodos sin implementarlos. Tal method se llama method abstracto.
          2. Un method abstracto está marcado con la palabra clave abstract. Si una clase tiene incluso un method
          abstracto, entonces la clase también se marca con abstract .
          3. No puedes crear objetos de una clase abstracta. El código que intenta hacerlo simplemente no se compilará.
          4. Si su clase hereda una clase abstracta, debe anular todos los métodos abstractos heredados, es decir, debe
          implementarlos. De lo contrario, su clase también deberá declararse abstracta.
        */

        Car car = new Sedan();
        car.setModel("Toyota");
        car.setColor("Red");
        car.setMaxSpeed(200);

        System.out.println("Model:" + car.getModel());
        System.out.println("Color:" + car.getColor());
        System.out.println("MaxSpeed:" + car.getMaxSpeed());
        car.gas();
        car.brake();

    }
}
