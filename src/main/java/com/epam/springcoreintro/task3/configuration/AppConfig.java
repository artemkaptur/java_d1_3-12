package com.epam.springcoreintro.task3.configuration;

import com.epam.springcoreintro.task3.model.Employee;
import com.epam.springcoreintro.task3.model.Salary;
import com.epam.springcoreintro.task3.model.Position;
import com.epam.springcoreintro.task3.service.impl.EmployeeServiceImpl;
import com.epam.springcoreintro.task3.service.impl.PositionServiceImpl;
import com.epam.springcoreintro.task3.service.impl.SalaryServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;

@Lazy
@Configuration
public class AppConfig {

    @Bean
    public static PropertySourcesPlaceholderConfigurer placeholderConfigurer() {
        return new PropertySourcesPlaceholderConfigurer();
    }

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
        return new SalaryServiceImpl(2.04, 4.3, 1.4);
    }

    @Bean
    public Salary junSalary() {
        return new Salary(600);
    }

    @Bean
    public Salary midSalary() {
        return new Salary(1500);
    }

    @Bean
    public Salary seniorSalary() {
        return new Salary(3000);
    }

    @Bean
    public Position junDev() {
        return new Position(0, "Developer", "JUNIOR", junSalary());
    }

    @Bean
    public Position midQa() {
        return new Position(1, "Qa", "MIDDLE", midSalary());
    }

    @Bean
    public Position pm() {
        return new Position(2, "PM", "SENIOR", seniorSalary());
    }

    @Bean
    public Position midDev() {
        return new Position(3, "Developer", "MIDDLE", midSalary());
    }

    @Bean
    public Position junDevOps() {
        return new Position(4, "DevOps", "JUNIOR", junSalary());
    }

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
