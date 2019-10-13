package com.epam.jvmgc.task4.model;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Dog extends Animal {

    private final Logger logger = LogManager.getLogger(Dog.class);

    public void voice() {
        logger.info("dog voice");
    }

    public void play() {
        logger.info("dog play");
    }
}
