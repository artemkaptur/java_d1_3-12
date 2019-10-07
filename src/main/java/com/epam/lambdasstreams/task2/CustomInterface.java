package com.epam.lambdasstreams.task2;

@FunctionalInterface
public interface CustomInterface<T> {

    void perform(T t);

    default double getRandomNumber() {
        return Math.random();
    }

    default void displayReverseString(T t) {
        StringBuilder sb = new StringBuilder(t.toString());
        System.out.println("Reverse string:\n" + sb.reverse().toString());
    }

    static boolean isEven(int a) {
        return a % 2 == 0;
    }

}
