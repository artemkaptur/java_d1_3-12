package com.epam.springcorebasics.task2.model;

// Subtask 6
public enum TIOBERating {

    JAVA(1.),
    C(1.1),
    CPLUSPLUS(1.2),
    PYTHON(1.3),
    CSHARP(1.4),
    JS(1.5);

    private Double multiplier;

    TIOBERating(Double multiplier) {
        this.multiplier = multiplier;
    }

    public Double getMultiplier() {
        return multiplier;
    }

    @Override
    public String toString() {
        return "TIOBERating{" +
                "multiplier=" + multiplier +
                '}';
    }

}
