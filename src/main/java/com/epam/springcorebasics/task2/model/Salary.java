package com.epam.springcorebasics.task2.model;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.util.Objects;

public class Salary {

    @Min(300)
    @Max(6000)
    @NotNull(message = "Salary size should be assigned")
    private Double salarySize;

    public Salary(double salarySize) {
        this.salarySize = salarySize;
    }

    public Salary() {
    }

    public double getSalarySize() {
        return salarySize;
    }

    public void setSalarySize(Double salarySize) {
        this.salarySize = salarySize;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Salary salary = (Salary) o;
        return getSalarySize() == salary.getSalarySize();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getSalarySize());
    }

    @Override
    public String toString() {
        return "Salary{" +
                "salarySize=" + salarySize +
                '}';
    }

}
