package com.epam.springcoreintro.task3.service.impl;

import com.epam.springcoreintro.task1.model.Employee;
import com.epam.springcoreintro.task1.model.Position;
import com.epam.springcoreintro.task1.model.Salary;
import com.epam.springcoreintro.task1.service.SalaryService;

public class SalaryServiceImpl implements SalaryService {

    private Double course;
    private Double inflation;
    private Double yearlySalaryCoefficient;

    public SalaryServiceImpl(Double course, Double inflation, Double yearlySalaryCoefficient) {
        this.course = course;
        this.inflation = inflation;
        this.yearlySalaryCoefficient = yearlySalaryCoefficient;
    }

    public Double getCourse() {
        return course;
    }

    public void setCourse(Double course) {
        this.course = course;
    }

    public Double getInflation() {
        return inflation;
    }

    public void setInflation(Double inflation) {
        this.inflation = inflation;
    }

    public Double getYearlySalaryCoefficient() {
        return yearlySalaryCoefficient;
    }

    public void setYearlySalaryCoefficient(Double yearlySalaryCoefficient) {
        this.yearlySalaryCoefficient = yearlySalaryCoefficient;
    }

    @Override
    public void calculateSalaryForEmployee(Position position, Employee employee) {
        employee.setSalary(new Salary(position.getStarterSalary().getSalarySize() * yearlySalaryCoefficient
                * (1 + inflation / 100) * course));
    }

}
