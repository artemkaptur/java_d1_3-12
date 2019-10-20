package com.epam.springcoreintro.task3.service.impl;

import com.epam.springcoreintro.task1.model.Employee;
import com.epam.springcoreintro.task1.model.Position;
import com.epam.springcoreintro.task1.service.EmployeeService;

import java.util.List;

public class EmployeeServiceImpl implements EmployeeService {

    private List<Employee> employees;

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    @Override
    public void hire(Employee employee, Position position) {
        employee.setPosition(position);
        employee.setSalary(position.getStarterSalary());
    }

    @Override
    public void fire(Employee employee) {
        employee.setPosition(null);
        employees.remove(employee);
    }

}
