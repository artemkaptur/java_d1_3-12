package com.epam.springcorebasics.task1;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.support.MethodReplacer;

import java.lang.reflect.Method;

public class MethodReplacerForE implements MethodReplacer {

    Logger logger = LogManager.getLogger(MethodReplacerForE.class);

    @Override
    public Object reimplement(Object obj, Method method, Object[] args) {
        logger.info("New message from MethodReplacerForE class");
        return null;
    }

}
