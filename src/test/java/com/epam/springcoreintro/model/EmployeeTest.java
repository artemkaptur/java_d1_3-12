package com.epam.springcoreintro.model;

import com.epam.springcoreintro.task1.model.Employee;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.util.Set;

public class EmployeeTest {

    private Logger logger = LogManager.getLogger(EmployeeTest.class);

    @Test
    public void employeeWithNoValuesTest() {
        Employee employee = new Employee(null);

        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        Validator validator = factory.getValidator();
        Set<ConstraintViolation<Employee>> violations = validator.validate(employee);

        for (ConstraintViolation<Employee> violation : violations) {
            logger.error(violation.getMessage());
        }
        Assert.assertEquals(violations.size(), 2);
    }

}
