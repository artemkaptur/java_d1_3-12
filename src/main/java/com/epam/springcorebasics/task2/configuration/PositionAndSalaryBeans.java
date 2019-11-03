package com.epam.springcorebasics.task2.configuration;

import com.epam.springcorebasics.task2.model.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import java.util.List;

@Configuration
public class PositionAndSalaryBeans {

    // Subtask 6-7
    @Bean
    public Position junDev() {
        Position position = new Position(0, "Developer", "JUNIOR", junSalary());
        position.setRequiredSkills(List.of(TIOBERating.PYTHON));
        return position;
    }

    // Subtask 6-7
    @Bean
    public Position midQa() {
        Position position = new Position(1, "Qa", "MIDDLE", midSalary());
        position.setRequiredSkills(List.of(TIOBERating.JAVA));
        return position;
    }

    @Bean
    public Position pm() {
        return new Position(2, "PM", "SENIOR", seniorSalary());
    }

    // Subtask 6-7
    @Bean
    public Position midDev() {
        Position position = new Position(3, "Developer", "MIDDLE", midSalary());
        position.setRequiredSkills(List.of(TIOBERating.CSHARP, TIOBERating.PYTHON));
        return position;
    }

    // Subtask 6-7
    @Bean
    public Position junDevOps() {
        Position position = new Position(4, "DevOps", "JUNIOR", junSalary());
        position.setRequiredSkills(List.of(TIOBERating.PYTHON));
        return position;
    }

    // Subtask 2
    @Bean
    public SalaryFactoryBean salaryFactoryBean() {
        return new SalaryFactoryBean();
    }

    // Subtask 5
    @Bean
    @Scope("prototype")
    public Salary junSalary() {
        Salary salary = salaryFactoryBean().getObject();
        salary.setSalarySize(600.);
        return salary;
    }

    @Bean
    @Scope("prototype")
    public Salary midSalary() {
        Salary salary = salaryFactoryBean().getObject();
        salary.setSalarySize(1500.);
        return salary;
    }

    @Bean
    @Scope("prototype")
    public Salary seniorSalary() {
        Salary salary = salaryFactoryBean().getObject();
        salary.setSalarySize(3000.);
        return salary;
    }

}
