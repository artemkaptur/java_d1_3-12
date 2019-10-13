package com.epam.jvmgc.task1;

import java.util.Objects;

public class Employee {

    private String name;
    private String role;
    private String department;

    public Employee(String name, String role, String department) {
        this.name = name;
        this.role = role;
        this.department = department;
    }

    public Employee() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        com.epam.lambdasstreams.task5.Employee employee = (com.epam.lambdasstreams.task5.Employee) o;
        return getName().equals(employee.getName()) &&
                getRole().equals(employee.getRole()) &&
                getDepartment().equals(employee.getDepartment());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), getRole(), getDepartment());
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", role='" + role + '\'' +
                ", department='" + department + '\'' +
                '}';
    }

}
