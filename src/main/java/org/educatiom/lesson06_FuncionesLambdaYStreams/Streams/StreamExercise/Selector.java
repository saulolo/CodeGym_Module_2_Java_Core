package org.educatiom.lesson06_FuncionesLambdaYStreams.Streams.StreamExercise;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

//Clase la Selector, donde la selección se realizará de acuerdo con los criterios especificados:
public class Selector {

    private static List<Owner> owners;


    private static void initDate() {
        final Owner owner1 = new Owner("Saul");
        owner1.getPets().addAll(List.of(
                new Dog("Teo", Color.BLACK, 14),
                new Dog("Bruno", Color.DARK_GREY, 1),
                new Cat("Sultan", Color.BLUE, 3)
        ));

        final Owner owner2 = new Owner("Vanessa");
        owner2.getPets().addAll(List.of(
                new Cat("Ginger", Color.FOXY, 5),
                new Cat("Oscar", Color.FOXY, 7),
                new Parrot("Cacao", Color.GREEN, 6)
        ));

        final Owner owner3 = new Owner("Eliany");
        owner3.getPets().addAll(List.of(
                new Dog("Rocko", Color.BLUE, 10),
                new Pig("Toci", Color.MAGENTA, 3)
        ));

        final Owner owner4 = new Owner("Nando");
        owner4.getPets().addAll(List.of(
                new Snake("Mr Boa", Color.GREEN, 7)
        ));

        final Owner owner5 = new Owner("Jonathan Snyder");
        owner5.getPets().addAll(List.of(
                new Cat("Fisher", Color.BLACK, 16),
                new Cat("Zorro", Color.FOXY, 14),
                new Cat("Margo", Color.WHITE, 3),
                new Cat("Brawler", Color.DARK_GREY, 1)
        ));

        owners = List.of(owner1, owner2, owner3, owner4, owner5);
    }

    public static void main(String[] args) {

        //Código donde no se usa flujos
        initDate();

        List<String> findNames = new ArrayList<>();

        List<Cat> findCats = new ArrayList<>();
        for (Owner owner : owners) {
            for (Animal pet : owner.getPets()) {
                if (Cat.class.equals(pet.getClass()) && Color.FOXY == pet.getColor()) {
                    findCats.add((Cat) pet);
                }
            }
        }

        Collections.sort(findCats, new Comparator<Cat>() {
            @Override
            public int compare(Cat o1, Cat o2) {
                return o2.getAge() - o1.getAge();
            }
        });

        for (Cat cat : findCats) {
            findNames.add(cat.getName());
        }

        findNames.forEach(System.out::println);

        System.out.println("------------- Código que usa Stream -----------------");
        //Codigo que usa Stream

        initDate();
        final List<String> findNames2 = owners.stream()
                .flatMap(owner -> owner.getPets().stream()) //Pasar de un Stream<Owner>a unStream<Pet>
                .filter(pet -> Cat.class.equals(pet.getClass())) //Retener solo gatos en el flujo de datos
                .filter(cat -> Color.FOXY == cat.getColor()) // Conservar solo gatos de color jengibre en el flujo de datos
                .sorted((o1, o2) -> o2.getAge() - o1.getAge())//Ordenar por edad en orden descendente
                .map(Animal::getName)//Obtener los nombres
                .collect(Collectors.toList()); //Poner el resultado en una lista

        findNames2.forEach(System.out::println);

        /*Como puede ver, el código es mucho más compacto. Además, cada línea de la tubería de flujo es una sola acción
        , por lo que se pueden leer como oraciones en inglés:*/
    }

}
