package com.epam.springcorebasics.task2.model;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Objects;

public class Employee {

    @NotNull(message = "Name should be assigned")
    @NotBlank(message = "Cannot be empty")
    private String name;
    private int workExperienceInYears;
    private Position position;
    private Salary salary;

    public Employee(String name, int workExperienceInYears) {
        this.name = name;
        this.workExperienceInYears = workExperienceInYears;
    }

    public Employee(String name) {
        this.name = name;
    }

    public Employee() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getWorkExperienceInYears() {
        return workExperienceInYears;
    }

    public void setWorkExperienceInYears(int workExperienceInYears) {
        this.workExperienceInYears = workExperienceInYears;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public Salary getSalary() {
        return salary;
    }

    public void setSalary(Salary salary) {
        this.salary = salary;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return getWorkExperienceInYears() == employee.getWorkExperienceInYears() &&
                getName().equals(employee.getName()) &&
                getPosition().equals(employee.getPosition()) &&
                getSalary().equals(employee.getSalary());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), getWorkExperienceInYears(), getPosition(), getSalary());
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", workExperienceInYears=" + workExperienceInYears +
                ", position=" + position +
                ", salary=" + salary +
                '}';
    }

}
