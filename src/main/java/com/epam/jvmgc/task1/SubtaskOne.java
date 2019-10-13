package com.epam.jvmgc.task1;

import java.util.LinkedList;
import java.util.List;
import java.util.Random;

import static java.nio.charset.StandardCharsets.UTF_8;

public class SubtaskOne {

    public static void main(String[] args) {
        List<Employee> listForTriggeringError = new LinkedList<>();
        while (true) {
            listForTriggeringError.add(new Employee(getRandomString(), getRandomString(), getRandomString()));
        }
    }

    private static String getRandomString() {
        byte[] array = new byte[88];
        new Random().nextBytes(array);
        return new String(array, UTF_8);
    }

}
