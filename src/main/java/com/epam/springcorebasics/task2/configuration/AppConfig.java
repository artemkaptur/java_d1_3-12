package com.epam.springcorebasics.task2.configuration;

import com.epam.springcorebasics.task2.model.InitializationDestroyingLoggingBean;
import com.epam.springcorebasics.task2.model.SalaryBeanPostProcessor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.Lazy;

@Lazy
@Configuration
@Import({ServiceBeans.class, EmployeeBeans.class, PositionAndSalaryBeans.class})
public class AppConfig {

    // Subtask 4
    @Bean
    public InitializationDestroyingLoggingBean initializationDestroyingLoggingBean() {
        return new InitializationDestroyingLoggingBean();
    }

    // Subtask 10
    @Bean
    public SalaryBeanPostProcessor beanPostProcessor() {
        return new SalaryBeanPostProcessor();
    }

}
