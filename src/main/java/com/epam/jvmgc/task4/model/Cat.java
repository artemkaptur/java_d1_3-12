package com.epam.jvmgc.task4.model;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Cat extends Animal {

    private final Logger logger = LogManager.getLogger(Cat.class);

    public void voice() {
        logger.info("cat voice");
    }

    public void play() {
        logger.info("cat play");
    }
}
