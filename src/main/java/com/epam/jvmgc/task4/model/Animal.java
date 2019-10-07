package com.epam.jvmgc.task4.model;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public abstract class Animal {

    private final Logger logger = LogManager.getLogger(Animal.class);

    public void voice() {
        logger.info("voice");
    }

    public void play() {
        logger.info("play");
    }

}
