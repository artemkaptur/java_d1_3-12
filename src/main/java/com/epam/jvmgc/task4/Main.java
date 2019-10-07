package com.epam.jvmgc.task4;

import com.epam.jvmgc.task4.model.Animal;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

import static java.util.Arrays.asList;

public class Main {

    private static final Logger logger = LogManager.getLogger(Main.class);

    public static void main(String[] args) {
        CustomClassLoader classLoader = new CustomClassLoader();

        Class<?> classCat = classLoader.findClass("com.epam.jvmgc.task4.model.Cat");
        Class<?> classDog = classLoader.findClass("com.epam.jvmgc.task4.model.Dog");

        Animal cat = null;
        Animal dog = null;
        try {
            cat = (Animal) classCat.getConstructor().newInstance();
            dog = (Animal) classDog.getConstructor().newInstance();
        } catch (InstantiationException | IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {
            e.printStackTrace();
        }

        List<Animal> animals = asList(cat, dog);

        for (Animal animal : animals) {
            animal.play();
            animal.voice();
        }
    }

}
