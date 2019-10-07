package com.epam.lambdasstreams.task3;

@FunctionalInterface
public interface ThreeFunction<T, E, U, R> {

    R perform(T t, E e, U u);
}
