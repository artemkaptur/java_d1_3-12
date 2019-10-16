package com.epam.springcoreintro.model;

import com.epam.springcoreintro.task1.model.Position;
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

public class PositionTest {

    private Logger logger = LogManager.getLogger(SalaryTest.class);


    @Test
    public void positionWithInvalidDataTest() {
        Position position = new Position(null, "Too long title for our constraint", "Junior", new Salary(700));

        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        Validator validator = factory.getValidator();
        Set<ConstraintViolation<Position>> violations = validator.validate(position);

        for (ConstraintViolation<Position> violation : violations) {
            logger.error(violation.getMessage());
        }
        Assert.assertEquals(violations.size(), 2);
    }

}
