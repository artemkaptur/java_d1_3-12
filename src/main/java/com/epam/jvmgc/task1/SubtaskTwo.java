package com.epam.jvmgc.task1;

import java.util.Random;

import static java.nio.charset.StandardCharsets.UTF_8;

public class SubtaskTwo {

    public static void main(String[] args) {
        while (true) {
            String str = getRandomString();
            str.intern();
        }
    }

    private static String getRandomString() {
        byte[] array = new byte[900_000_000];
        new Random().nextBytes(array);
        return new String(array, UTF_8);
    }

}
