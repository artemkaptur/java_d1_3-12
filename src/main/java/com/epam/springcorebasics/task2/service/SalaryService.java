package com.epam.springcorebasics.task2.service;

import com.epam.springcorebasics.task2.model.Employee;
import com.epam.springcorebasics.task2.model.Position;

public interface SalaryService {

    void calculateSalaryForEmployee(Position position, Employee employee);

}
