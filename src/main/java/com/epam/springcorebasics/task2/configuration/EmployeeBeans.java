package com.epam.springcorebasics.task2.configuration;

import com.epam.springcorebasics.task2.model.Employee;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class EmployeeBeans {

    @Bean
    public Employee john() {
        return new Employee("John", 5);
    }

    @Bean
    public Employee bill() {
        return new Employee("Bill", 2);
    }

    @Bean
    public Employee kate() {
        return new Employee("Kate", 1);
    }

    @Bean
    public Employee tom() {
        return new Employee("Tom", 15);
    }

    @Bean
    public Employee jane() {
        return new Employee("Jane", 8);
    }

}
