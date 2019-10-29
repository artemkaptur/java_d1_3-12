package com.epam.springcorebasics.task1;

import java.util.Objects;

public class C {

    private D d;

    public D getD() {
        return d;
    }

    public void setD(D d) {
        this.d = d;
    }

    public D createD() {
        return null;
    }

    public void initIt() {
        d = createD();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        C c = (C) o;
        return getD().equals(c.getD());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getD());
    }

    @Override
    public String toString() {
        return "C{" +
                "d=" + d +
                '}';
    }

}
