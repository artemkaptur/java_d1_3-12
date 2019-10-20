package com.epam.springcoreintro.task3;

import com.epam.springcoreintro.task1.model.Employee;
import com.epam.springcoreintro.task1.model.Position;
import com.epam.springcoreintro.task1.service.impl.EmployeeServiceImpl;
import com.epam.springcoreintro.task1.service.impl.PositionServiceImpl;
import com.epam.springcoreintro.task1.service.impl.SalaryServiceImpl;
import com.epam.springcoreintro.task3.configuration.AppConfig;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;

@ContextConfiguration(classes = AppConfig.class)
public class Main {

    @Autowired
    private static PositionServiceImpl positionService;
    @Autowired
    private static EmployeeServiceImpl employeeService;
    @Autowired
    private static SalaryServiceImpl salaryService;
    @Autowired
    private static Employee john;
    @Autowired
    private static Employee bill;
    @Autowired
    private static Employee kate;
    @Autowired
    private static Employee tom;
    @Autowired
    private static Employee jane;
    @Autowired
    private static Position junDev;
    @Autowired
    private static Position midQa;
    @Autowired
    private static Position pm;
    @Autowired
    private static Position midDev;
    @Autowired
    private static Position junDevOps;

    public static void main(String[] args) {
        Logger logger = LogManager.getLogger(Main.class);

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
    }

}
