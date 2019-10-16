package com.epam.springcoreintro.model;

import com.epam.springcoreintro.task1.model.Salary;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
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
        Salary salary = new Salary(250);

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
        Salary salary = new Salary(7000);

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
        Salary salary = new Salary();

        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        Validator validator = factory.getValidator();
        Set<ConstraintViolation<Salary>> violations = validator.validate(salary);

        for (ConstraintViolation<Salary> violation : violations) {
            logger.error(violation.getMessage());
        }
        Assert.assertEquals(violations.size(), 1);
    }

}
