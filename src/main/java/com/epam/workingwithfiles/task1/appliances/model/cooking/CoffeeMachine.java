package com.epam.workingwithfiles.task1.appliances.model.cooking;

import com.epam.workingwithfiles.task1.appliances.model.Color;

import java.util.Objects;

import static com.epam.workingwithfiles.task1.appliances.model.AppliancePurpose.COOKING;

public class CoffeeMachine extends BeverageMaker  {

    private boolean withMilk;
    private boolean withCinnamon;

    public CoffeeMachine(String title, int power, int weight, Color color) {
        super(title, COOKING, power, weight, color);
        withMilk = false;
        withCinnamon = false;
    }

    public boolean isWithMilk() {
        return withMilk;
    }

    public CoffeeMachine addMilk() {
        this.withMilk = true;
        return this;
    }

    public boolean isWithCinnamon() {
        return withCinnamon;
    }

    public CoffeeMachine addCinnamon() {
        this.withCinnamon = true;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        CoffeeMachine that = (CoffeeMachine) o;
        return isWithMilk() == that.isWithMilk() &&
                isWithCinnamon() == that.isWithCinnamon();
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), isWithMilk(), isWithCinnamon());
    }

    @Override
    public String toString() {
        return "CoffeeMachine{" +
                "withMilk=" + withMilk +
                ", withCinnamon=" + withCinnamon +
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
