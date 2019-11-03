package com.epam.springcorebasics.task2.service.impl;


import com.epam.springcorebasics.task2.model.*;
import com.epam.springcorebasics.task2.service.SalaryService;
import org.springframework.beans.factory.annotation.Value;

import java.util.ArrayList;
import java.util.List;

import static java.util.Comparator.comparing;

public class SalaryServiceImpl implements SalaryService {

    private Double course;
    // Subtask 9
    @Value(value = "#{T(java.lang.Math).PI}")
    private Double inflation;
    private Double yearlySalaryCoefficient;

    public SalaryServiceImpl(Double course, Double yearlySalaryCoefficient) {
        this.course = course;
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
        Double multiplier = 1.;
        // Subtask 6
        if (position.getRequiredSkills() != null) {
            List<Double> multipliers = new ArrayList<>();
            for (TIOBERating rating : position.getRequiredSkills()) {
                multipliers.add(rating.getMultiplier());
            }
            multiplier = multipliers.stream().min(comparing(Double::valueOf)).get();
        }
        employee.setSalary(new Salary(position.getStarterSalary().getSalarySize() * yearlySalaryCoefficient
                * (1 + inflation / 100) * course * multiplier));
    }

}
