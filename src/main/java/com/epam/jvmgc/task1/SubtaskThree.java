package com.epam.jvmgc.task1;

import java.util.ArrayList;
import java.util.List;

// Use -XX:MaxMetaspaceSize=10M
public class SubtaskThree {

    public static void main(String[] args) {
        List<Class> listOfClasses = new ArrayList<>();
        while (true) {
            CustomClassLoader classLoader = new CustomClassLoader();
            Class classEmployee = classLoader.findClass("com.epam.jvmgc.task1.Employee");
            listOfClasses.add(classEmployee);
        }
    }

}
