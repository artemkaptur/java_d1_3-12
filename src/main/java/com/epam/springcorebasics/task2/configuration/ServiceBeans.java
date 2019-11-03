package com.epam.springcorebasics.task2.configuration;

import com.epam.springcorebasics.task2.service.impl.EmployeeServiceImpl;
import com.epam.springcorebasics.task2.service.impl.PositionServiceImpl;
import com.epam.springcorebasics.task2.service.impl.SalaryServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ServiceBeans {

    @Bean
    public PositionServiceImpl positionServiceImpl() {
        return new PositionServiceImpl();
    }

    @Bean
    public EmployeeServiceImpl employeeServiceImpl() {
        return new EmployeeServiceImpl();
    }

    @Bean
    public SalaryServiceImpl salaryServiceImpl() {
        return new SalaryServiceImpl(2.04, 1.4);
    }

}
