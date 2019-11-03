package com.epam.springcorebasics.task2.service;

import com.epam.springcorebasics.task2.model.Employee;
import com.epam.springcorebasics.task2.model.Position;

public interface EmployeeService {

    void hire(Employee employee, Position position);

    void fire(Employee employee);

}
