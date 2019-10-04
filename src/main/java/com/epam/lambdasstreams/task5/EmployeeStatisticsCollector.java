package com.epam.lambdasstreams.task5;

import java.util.EnumSet;
import java.util.Set;
import java.util.function.BiConsumer;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collector;

import static java.util.Collections.unmodifiableSet;
import static java.util.stream.Collector.Characteristics.IDENTITY_FINISH;

public class EmployeeStatisticsCollector implements Collector<Employee, EmployeeStatistics, EmployeeStatistics> {

    @Override
    public Supplier<EmployeeStatistics> supplier() {
        return EmployeeStatistics::new;
    }

    @Override
    public BiConsumer<EmployeeStatistics, Employee> accumulator() {
        return (s, e) -> {
            if (e.getRole().contains("Junior"))
                s.setJuniorEmployeeCount(s.getJuniorEmployeeCount() + 1);
            if (e.getDepartment().contains("QA"))
                s.setQaDepartmentEmployeeCount(s.getQaDepartmentEmployeeCount() + 1);
        };
    }

    @Override
    public BinaryOperator<EmployeeStatistics> combiner() {
        return (current, other) -> {
            current.setJuniorEmployeeCount(current.getJuniorEmployeeCount() + other.getJuniorEmployeeCount());
            current.setQaDepartmentEmployeeCount(current.getQaDepartmentEmployeeCount() + other.getQaDepartmentEmployeeCount());
            return current;
        };
    }

    @Override
    public Function<EmployeeStatistics, EmployeeStatistics> finisher() {
        return (e -> e);
    }

    @Override
    public Set<Characteristics> characteristics() {
        return unmodifiableSet(EnumSet.of(IDENTITY_FINISH));
    }

}
