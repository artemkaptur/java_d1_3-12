package com.epam.springcorebasics.task1;

import java.util.Objects;

public class B {

    private A a;

    public B(A a) {
        this.a = a;
    }

    public A getA() {
        return a;
    }

    public void setA(A a) {
        this.a = a;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        B b = (B) o;
        return getA().equals(b.getA());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getA());
    }

    @Override
    public String toString() {
        return "B{" +
                "a=" + a +
                '}';
    }

}
