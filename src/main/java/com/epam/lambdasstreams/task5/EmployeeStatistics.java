package com.epam.lambdasstreams.task5;

import java.util.Objects;

public class EmployeeStatistics {

    private int juniorEmployeeCount;
    private int qaDepartmentEmployeeCount;

    public EmployeeStatistics() {
    }

    public EmployeeStatistics(int juniorEmployeeCount, int qaDepartmentEmployeeCount) {
        this.juniorEmployeeCount = juniorEmployeeCount;
        this.qaDepartmentEmployeeCount = qaDepartmentEmployeeCount;
    }

    public int getJuniorEmployeeCount() {
        return juniorEmployeeCount;
    }

    public void setJuniorEmployeeCount(int juniorEmployeeCount) {
        this.juniorEmployeeCount = juniorEmployeeCount;
    }

    public int getQaDepartmentEmployeeCount() {
        return qaDepartmentEmployeeCount;
    }

    public void setQaDepartmentEmployeeCount(int qaDepartmentEmployeeCount) {
        this.qaDepartmentEmployeeCount = qaDepartmentEmployeeCount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EmployeeStatistics that = (EmployeeStatistics) o;
        return getJuniorEmployeeCount() == that.getJuniorEmployeeCount() &&
                getQaDepartmentEmployeeCount() == that.getQaDepartmentEmployeeCount();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getJuniorEmployeeCount(), getQaDepartmentEmployeeCount());
    }

    @Override
    public String toString() {
        return "EmployeeStatistics{" +
                "juniorEmployeeCount=" + juniorEmployeeCount +
                ", qaDepartmentEmployeeCount=" + qaDepartmentEmployeeCount +
                '}';
    }

}
