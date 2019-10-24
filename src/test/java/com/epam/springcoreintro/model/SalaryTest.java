package com.epam.springcoreintro.model;

import com.epam.springcoreintro.task1.model.Salary;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.testng.Assert;
import org.testng.annotations.Test;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.util.Set;

public class SalaryTest {

    private Logger logger = LogManager.getLogger(SalaryTest.class);

    @Test
    public void salaryWithTooSmallValueTest() {
        ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
        Salary salary = (Salary) context.getBean("tooSmallSalary");

        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        Validator validator = factory.getValidator();
        Set<ConstraintViolation<Salary>> violations = validator.validate(salary);

        for (ConstraintViolation<Salary> violation : violations) {
            logger.error(violation.getMessage());
        }
        Assert.assertEquals(violations.size(), 1);
    }

    @Test
    public void salaryWithTooBigValueTest() {
        ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
        Salary salary = (Salary) context.getBean("tooBigSalary");

        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        Validator validator = factory.getValidator();
        Set<ConstraintViolation<Salary>> violations = validator.validate(salary);

        for (ConstraintViolation<Salary> violation : violations) {
            logger.error(violation.getMessage());
        }
        Assert.assertEquals(violations.size(), 1);
    }

    @Test
    public void salaryWithNoValueTest() {
        ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
        Salary salary = (Salary) context.getBean("salaryWithNull");

        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        Validator validator = factory.getValidator();
        Set<ConstraintViolation<Salary>> violations = validator.validate(salary);

        for (ConstraintViolation<Salary> violation : violations) {
            logger.error(violation.getMessage());
        }
        Assert.assertEquals(violations.size(), 1);
    }

}
