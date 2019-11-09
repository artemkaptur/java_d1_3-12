package com.epam.workingwithfiles.task1.appliances.model.cooking;

import com.epam.workingwithfiles.task1.appliances.model.Color;

import java.util.Objects;

import static com.epam.workingwithfiles.task1.appliances.model.AppliancePurpose.COOKING;

public class Kettle extends BeverageMaker {

    private boolean withLemon;
    private boolean withHoney;

    public Kettle(String title, int power, int weight, Color color) {
        super(title, COOKING, power, weight, color);
        withLemon = false;
        withHoney = false;
    }

    public boolean isWithLemon() {
        return withLemon;
    }

    public Kettle addLemon() {
        this.withLemon = true;
        return this;
    }

    public boolean isWithHoney() {
        return withHoney;
    }

    public Kettle addHoney() {
        this.withHoney = true;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Kettle kettle = (Kettle) o;
        return isWithLemon() == kettle.isWithLemon() &&
                isWithHoney() == kettle.isWithHoney();
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), isWithLemon(), isWithHoney());
    }

    @Override
    public String toString() {
        return "Kettle{" +
                "withLemon=" + withLemon +
                ", withHoney=" + withHoney +
                ", maxCountOfBeverages=" + maxCountOfBeverages +
                ", availableBeverages=" + availableBeverages +
                ", title='" + title + '\'' +
                ", appliancePurpose=" + appliancePurpose +
                ", power=" + power +
                ", weight=" + weight +
                ", color=" + color +
                ", isPlugged=" + isPlugged +
                '}';
    }

}
