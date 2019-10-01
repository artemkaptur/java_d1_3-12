package com.epam.lambdasstreams.task1;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import static java.util.Comparator.comparing;

public class Main {

    public static void main(String[] args) {

        List<Person> persons = new ArrayList<>(
                List.of(new Person("Ted", 29),
                        new Person("John", 88),
                        new Person("Kate", 17)));

        Comparator<Person> compareByName = comparing(Person::getName);
        Comparator<Person> compareByAge = comparing(Person::getAge);

        System.out.println("Before sorting:");
        persons.forEach(p -> System.out.println(p.toString()));
        System.out.println("\nAfter sorting by name:");
        persons.stream().sorted(compareByName).forEach(p -> System.out.println(p.toString()));
        System.out.println("\nAfter sorting by age:");
        persons.stream().sorted(compareByAge).forEach(p -> System.out.println(p.toString()));

    }

}
