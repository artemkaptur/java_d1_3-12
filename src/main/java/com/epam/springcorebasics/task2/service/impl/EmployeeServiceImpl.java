package com.epam.springcorebasics.task2.service.impl;


import com.epam.springcorebasics.task2.model.Employee;
import com.epam.springcorebasics.task2.model.Position;
import com.epam.springcorebasics.task2.service.EmployeeService;

import java.util.ArrayList;
import java.util.List;

public class EmployeeServiceImpl implements EmployeeService {

    private List<Employee> employees;

    public EmployeeServiceImpl() {
        employees = new ArrayList<>();
    }

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
        employees.add(employee);
        new PositionServiceImpl().deletePosition(position);
    }

    @Override
    public void fire(Employee employee) {
        employee.setPosition(null);
        employees.remove(employee);
    }

}
