package com.epam.springcorebasics.task2.model;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

// Subtask 10
public class SalaryBeanPostProcessor implements BeanPostProcessor {

    private static final Logger logger = LogManager.getLogger(SalaryBeanPostProcessor.class);

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        logger.info("Salary bean post processor before " + beanName + " initialization");
        if (bean instanceof Salary) {
            Double oldSalary = ((Salary) bean).getSalarySize();
            logger.info("Salary size mutated");
            return new Salary(oldSalary * 1.01);
        }
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        logger.info("Salary bean post processor after " + beanName + " initialization");
        return bean;
    }
}
