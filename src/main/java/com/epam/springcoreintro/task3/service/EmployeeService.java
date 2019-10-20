package com.epam.springcoreintro.task3.service;

import com.epam.springcoreintro.task1.model.Employee;
import com.epam.springcoreintro.task1.model.Position;

public interface EmployeeService {

    void hire(Employee employee, Position position);

    void fire(Employee employee);

}
