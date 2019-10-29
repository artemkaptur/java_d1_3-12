package com.epam.springcorebasics.task1;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class E {

    private static final Logger logger = LogManager.getLogger(E.class);

    public void printSomething() {
        logger.info("Old message from E class");
    }

}
