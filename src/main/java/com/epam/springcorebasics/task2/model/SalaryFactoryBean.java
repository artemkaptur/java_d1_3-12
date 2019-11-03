package com.epam.springcorebasics.task2.model;

import org.springframework.beans.factory.FactoryBean;

// Subtask 2
public class SalaryFactoryBean implements FactoryBean<Salary> {

    private static final Double MIN_SALARY = 300.;

    @Override
    public Salary getObject() {
        return new Salary(MIN_SALARY);
    }

    @Override
    public Class<?> getObjectType() {
        return Salary.class;
    }

    @Override
    public boolean isSingleton() {
        return false;
    }

}
