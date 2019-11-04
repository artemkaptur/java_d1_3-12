package com.epam.workingwithfiles.task1.appliances.annotations;

import java.lang.annotation.Retention;

import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Retention(RUNTIME)
public @interface ThisCodeSmellss {
    ThisCodeSmells[] value();
}
