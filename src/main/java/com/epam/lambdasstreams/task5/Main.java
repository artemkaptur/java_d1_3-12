package com.epam.lambdasstreams.task5;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.lang.System.currentTimeMillis;
import static java.nio.charset.StandardCharsets.UTF_8;
import static java.util.stream.Collectors.toList;

public class Main {

    public static void main(String[] args) {
        List<Employee> employees = Arrays.asList(
                new Employee("John", "Junior", "Dev"),
                new Employee("Tom", "Lead", "Dev"),
                new Employee("Kate", "Junior", "QA"),
                new Employee("Jim", "Senior", "QA"));

        EmployeeStatistics employeeStats = employees.stream().collect(new EmployeeStatisticsCollector());

        System.out.println("juniorEmployeeCount = " + employeeStats.getJuniorEmployeeCount());
        System.out.println("qaDepartmentEmployeeCount = " + employeeStats.getQaDepartmentEmployeeCount());

        System.out.println("Parallel stream testing:\n");
        List<Employee> employees2 = IntStream.rangeClosed(1, 10_000_000)
                .mapToObj(i -> new Employee(getRandomString(), getRandomString(), getRandomString()))
                .collect(toList());

        Runnable runnable = () -> getSpentTime(employees2.stream(), "Not parallel stream time - ");
        Runnable runnable2 = () -> getSpentTime(employees2.parallelStream(), "Parallel stream time - ");
        Thread thread = new Thread(runnable);
        thread.start();
        Thread thread2 = new Thread(runnable2);
        thread2.start();
    }

    private static String getRandomString() {
        byte[] array = new byte[7];
        new Random().nextBytes(array);
        return new String(array, UTF_8);
    }

    private static void getSpentTime(Stream<Employee> stream, String message) {
        long startTime = currentTimeMillis();
        EmployeeStatistics employeeStats = stream.collect(new EmployeeStatisticsCollector());
        System.out.println("Count of Junior employee - " + employeeStats.getJuniorEmployeeCount());
        long endTime = currentTimeMillis();
        System.out.println(message + (endTime - startTime));
    }

}
