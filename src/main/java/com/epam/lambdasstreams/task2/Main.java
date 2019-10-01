package com.epam.lambdasstreams.task2;

import java.util.ArrayList;
import java.util.List;
import java.util.function.*;

import static com.epam.lambdasstreams.task2.CustomInterface.isEven;

public class Main {

    public static void main(String[] args) {

        Supplier<Double> randomValue = Math::random;
        System.out.println("Random double value by implemented supplier interface - " + randomValue.get());

        List<Person> persons = new ArrayList<>(
                List.of(new Person("Ted", 29),
                        new Person("John", 88),
                        new Person("Kate", 17)));
        Predicate<Person> isPersonRetiree = p -> p.getAge() > 65;
        persons.stream().filter(isPersonRetiree).forEach(p -> System.out.println("This person is retiree - " + p.toString()));

        Consumer<String> display = System.out::println;
        display.accept("Hello from consumer implemented interface!");

        BiFunction<Person, Person, Person> getOlderPerson = (p1, p2) -> p1.getAge() > p2.getAge() ? p1 : p2;
        System.out.println("Oldest person is - " + getOlderPerson.apply(persons.get(0), persons.get(1)));

        Function<Integer, Integer> pow = i -> i * i;
        System.out.println("2 * 2 = " + pow.apply(2));

        UnaryOperator<Person> getOlderInTenYears = p -> {
            p.setAge(p.getAge() + 10);
            return p;
        };
        System.out.println(persons.get(0).toString() + " get older in 10 years - " + getOlderInTenYears.apply(persons.get(0)).toString());

        CustomInterface<Integer> lambdaImplementation = (i) -> {
            System.out.println("Is " + i + " even - " + isEven(i));
        };
        lambdaImplementation.perform(2);

        CustomInterface<Person> anonymousClassImplementation = new CustomInterface<Person>() {
            @Override
            public void perform(Person person) {
                System.out.println("Hello from anonymous class from person " + person.toString());
            }
        };
        anonymousClassImplementation.perform(new Person("Jim", 19));

        System.out.println(anonymousClassImplementation.getRandomNumber());
        anonymousClassImplementation.displayReverseString((new Person("Jim", 19)));

    }

}
