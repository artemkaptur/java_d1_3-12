package com.epam.workingwithfiles.task1.appliances.model.relax;

import com.epam.workingwithfiles.task1.appliances.exception.CannotTurnOnDueToParentalControlException;
import com.epam.workingwithfiles.task1.appliances.model.Color;
import com.epam.workingwithfiles.task1.appliances.model.TurnOnByTime;

import java.util.Objects;

import static com.epam.workingwithfiles.task1.appliances.model.AppliancePurpose.RELAX;

public class Computer extends RelaxAppliance {

    private transient int screenSize;
    private transient int ram;
    private double cpu;

    public Computer(String title, int power, int weight, Color color) {
        super(title, RELAX, power, weight, color);
    }

    public int getScreenSize() {
        return screenSize;
    }

    public Computer setScreenSize(int screenSize) {
        this.screenSize = screenSize;
        return this;
    }

    public int getRam() {
        return ram;
    }

    public Computer setRam(int ram) {
        this.ram = ram;
        return this;
    }

    public double getCpu() {
        return cpu;
    }

    public Computer setCpu(double cpu) {
        this.cpu = cpu;
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
        Computer computer = (Computer) o;
        return getScreenSize() == computer.getScreenSize() &&
                getRam() == computer.getRam() &&
                getCpu() == computer.getCpu();
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), getScreenSize(), getRam(), getCpu());
    }

    @Override
    public String toString() {
        return "Computer{" +
                "screenSize=" + screenSize +
                ", ram=" + ram +
                ", cpu=" + cpu +
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
