package com.epam.springcorebasics.task2.model;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.beans.factory.config.DestructionAwareBeanPostProcessor;

// Subtask 4
public class InitializationDestroyingLoggingBean implements BeanPostProcessor, DestructionAwareBeanPostProcessor {

    private static final Logger logger = LogManager.getLogger(InitializationDestroyingLoggingBean.class);

    @Override
    public void postProcessBeforeDestruction(Object bean, String beanName) throws BeansException {
        logger.info("Bean " + beanName + " is destroying");
    }

    @Override
    public boolean requiresDestruction(Object bean) {
        return true;
    }

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        logger.info("Bean " + beanName + " before initialization");
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        logger.info("Bean " + beanName + " after initialization");
        return bean;
    }

}
