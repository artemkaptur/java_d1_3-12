package com.epam.springcorebasics.task1;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.*;
import org.springframework.context.*;
import org.springframework.core.io.ResourceLoader;

public class F implements InitializingBean, DisposableBean, BeanFactoryAware, BeanNameAware, BeanClassLoaderAware,
        ApplicationContextAware, ResourceLoaderAware, MessageSourceAware, ApplicationEventPublisherAware {

    private static final Logger logger = LogManager.getLogger(F.class);

    @Override
    public void setBeanClassLoader(ClassLoader classLoader) {
        logger.info("Set F bean classloader");
    }

    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        logger.info("Set F bean factory");
    }

    @Override
    public void setBeanName(String name) {
        logger.info("Set F bean name");
    }

    @Override
    public void destroy() {
        logger.info("Destroy F bean");
    }

    @Override
    public void afterPropertiesSet() {
        logger.info("Set after properties");
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        logger.info("Set application context");
    }

    @Override
    public void setApplicationEventPublisher(ApplicationEventPublisher applicationEventPublisher) {
        logger.info("Set application event");
    }

    @Override
    public void setMessageSource(MessageSource messageSource) {
        logger.info("Set message source");
    }

    @Override
    public void setResourceLoader(ResourceLoader resourceLoader) {
        logger.info("Set resource loader");
    }

}
