package com.epam.springcoreintro.task1.service;

import com.epam.springcoreintro.task1.model.Employee;
import com.epam.springcoreintro.task1.model.Position;

public interface SalaryService {

    void calculateSalaryForEmployee(Position position, Employee employee);

}
