package com.epam.jvmgc.task2;

public class Main {

    // SubtaskOne -XX:NewRatio=1 -XX:SurvivorRatio=3
    // SubtaskTwo -Xms512m -Xmx512m -XX:NewRatio=1 -XX:SurvivorRatio=2
    // SubtaskThree -Xms512m -Xmx512m -Xmn384m -XX:SurvivorRatio=3
    // SubtaskFour -Xms768m -Xmx768m -Xmn640m -XX:SurvivorRatio=3
    public static void main(String[] args) {
        long pid = ProcessHandle.current().pid();
        while (true) {
            System.out.println(pid);
        }
    }

}
