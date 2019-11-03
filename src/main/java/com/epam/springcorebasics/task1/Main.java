package com.epam.springcorebasics.task1;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

    private static final Logger logger = LogManager.getLogger(Main.class);

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring-basics.xml");
        A a = context.getBean("a", A.class);
        logger.info("Bean A:\n" + a);
        B b = context.getBean("b", B.class);
        logger.info("Bean B\n" + b);
        C c = context.getBean("c", C.class);
        logger.info("Bean C\n" + c);
        D d = c.createD();
        logger.info("Bean D\n" + d);
        E e = context.getBean("e", E.class);
        e.printSomething();
        F f = context.getBean("f", F.class);
        logger.info("Bean F\n" + f);
    }

}
