package com.epam.workingwithfiles.task1.appliances.annotations;


import java.lang.annotation.Repeatable;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.RetentionPolicy.RUNTIME;


@Retention(RUNTIME)
@Target({METHOD, FIELD, TYPE, PARAMETER, CONSTRUCTOR, LOCAL_VARIABLE, ANNOTATION_TYPE, PACKAGE, TYPE_PARAMETER, TYPE_USE,})
@Repeatable(ThisCodeSmellss.class)
public @interface ThisCodeSmells {
    String reviewer() default "Petya";
}
