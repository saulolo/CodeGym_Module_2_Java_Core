package org.educatiom.lesson02_OOP_SobrecargaAnulacionClasesAbstractas.ClaseAbstractaExample;

public class Sedan extends Car {

    @Override
    public void gas() {
        System.out.println("The Sedan is accelerating");

    }

    @Override
    public void brake() {
        System.out.println("The Sedan is braking");
    }
}
