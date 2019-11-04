package com.epam.workingwithfiles.task1.appliances.model.relax;

import com.epam.workingwithfiles.task1.appliances.exception.CannotTurnOnDueToParentalControlException;
import com.epam.workingwithfiles.task1.appliances.model.Color;
import com.epam.workingwithfiles.task1.appliances.model.TurnOnByTime;

import java.util.Objects;

import static com.epam.workingwithfiles.task1.appliances.model.AppliancePurpose.RELAX;

public class TV extends RelaxAppliance {

    private transient int screenSize;
    private boolean isFourK;

    public TV(String title, int power, int weight, Color color) {
        super(title, RELAX, power, weight, color);
    }

    public int getScreenSize() {
        return screenSize;
    }

    public TV setScreenSize(int screenSize) {
        this.screenSize = screenSize;
        return this;
    }

    public boolean isFourK() {
        return isFourK;
    }

    public TV setFourK(boolean fourK) {
        isFourK = fourK;
        return this;
    }

    public void setTheTimer(int hour, TurnOnByTime turnOnByTime) throws CannotTurnOnDueToParentalControlException {
        turnOnByTime.setTheTimer(this, hour);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        TV tv = (TV) o;
        return getScreenSize() == tv.getScreenSize() &&
                isFourK() == tv.isFourK();
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), getScreenSize(), isFourK());
    }

    @Override
    public String toString() {
        return "TV{" +
                "screenSize=" + screenSize +
                ", isFourK=" + isFourK +
                ", isParentalControlOn=" + isParentalControlOn +
                ", title='" + title + '\'' +
                ", appliancePurpose=" + appliancePurpose +
                ", power=" + power +
                ", weight=" + weight +
                ", color=" + color +
                ", isPlugged=" + isPlugged +
                '}';
    }

}
