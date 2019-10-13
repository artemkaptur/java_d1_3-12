package com.epam.jvmgc.task1;

public class SubtaskFour {

    public static void main(String[] args) {
        getZero(-1);
    }

    private static int getZero(int number) {
        if (number == 0)
            return 0;
        number--;
        return getZero(number);
    }

}
