package com.epam.lambdasstreams.task3;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

import static java.util.stream.Collectors.toList;

public class Main {

    public static void main(String[] args) {
        List<Person> persons = new ArrayList<>(
                List.of(new Person("Ted", 29),
                        new Person("John", 88),
                        new Person("Kate", 17)));

        Predicate<Person> canBuyAlcohol = p -> p.getAge() > 20;
        Predicate<Person> isPersonYoungerThanRetiree = p -> p.getAge() < 65;

        ThreeFunction<List<Person>, Predicate<Person>, Predicate<Person>, List<Person>> amountOfWorkForce =
                (people, personPredicateMature, personPredicateRetiree) -> people.stream()
                        .filter(personPredicateMature)
                        .filter(personPredicateRetiree)
                        .collect(toList());
        System.out.println("These people can pay taxes:\n" + amountOfWorkForce.perform(persons, canBuyAlcohol, isPersonYoungerThanRetiree));

        ThreeFunction<List<Person>, String, String, List<String>> selectNames =
                ((people, startsWith, endWith) -> people.stream()
                        .filter(person -> person.getName().startsWith(startsWith))
                        .filter(person -> person.getName().endsWith(endWith))
                        .map(Person::getName)
                        .collect(toList()));
        System.out.println(selectNames.perform(persons, "J", "n"));
    }

}
