package com.epam.springcorebasics.task2;

import com.epam.springcorebasics.task2.configuration.AppConfig;

import com.epam.springcorebasics.task2.model.Employee;
import com.epam.springcorebasics.task2.model.Position;
import com.epam.springcorebasics.task2.service.impl.EmployeeServiceImpl;
import com.epam.springcorebasics.task2.service.impl.PositionServiceImpl;
import com.epam.springcorebasics.task2.service.impl.SalaryServiceImpl;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {

    public static void main(String[] args) {
        Logger logger = LogManager.getLogger(Main.class);
        ConfigurableApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

        PositionServiceImpl positionService = (PositionServiceImpl) context.getBean("positionServiceImpl");
        EmployeeServiceImpl employeeService = (EmployeeServiceImpl) context.getBean("employeeServiceImpl");
        SalaryServiceImpl salaryService = (SalaryServiceImpl) context.getBean("salaryServiceImpl");

        Employee john = (Employee) context.getBean("john");
        Employee bill = (Employee) context.getBean("bill");
        Employee kate = (Employee) context.getBean("kate");
        Employee tom = (Employee) context.getBean("tom");
        Employee jane = (Employee) context.getBean("jane");

        Position junDev = (Position) context.getBean("junDev");
        Position midQa = (Position) context.getBean("midQa");
        Position pm = (Position) context.getBean("pm");
        Position midDev = (Position) context.getBean("midDev");
        Position junDevOps = (Position) context.getBean("junDevOps");
        positionService.createPosition(junDev);
        positionService.createPosition(midQa);
        positionService.createPosition(pm);
        positionService.createPosition(midDev);
        positionService.createPosition(junDevOps);

        logger.info("Start activities of company");
        logger.info("Company has next positions:");
        logger.info(positionService.getPositions());

        logger.info("Hire employees");
        employeeService.hire(john, junDev);
        employeeService.hire(bill, midQa);
        employeeService.hire(kate, pm);
        employeeService.hire(tom, midDev);
        employeeService.hire(jane, junDevOps);

        logger.info("One year has passed and the salaries were increased:");
        salaryService.calculateSalaryForEmployee(junDev, john);
        salaryService.calculateSalaryForEmployee(midQa, bill);
        salaryService.calculateSalaryForEmployee(pm, kate);
        salaryService.calculateSalaryForEmployee(midDev, tom);
        salaryService.calculateSalaryForEmployee(junDevOps, jane);

        logger.info("Salary are:");
        employeeService.getEmployees().forEach(e -> logger.info(e.getName() + " - " + e.getSalary()));

        logger.info("Fire employee: " + john.toString());
        employeeService.fire(john);
        logger.info("Employees after firing:");
        employeeService.getEmployees().forEach(e -> logger.info(e.toString()));

        context.close();
    }

}
