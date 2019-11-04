package com.epam.workingwithfiles.task1.appliances.model;

import com.epam.workingwithfiles.task1.appliances.exception.CannotTurnOnDueToUnpluggedlException;

import java.io.Serializable;
import java.util.Objects;

public abstract class Appliance implements Serializable {

    protected String title;
    protected AppliancePurpose appliancePurpose;
    protected transient int power;
    protected transient int weight;
    protected Color color;
    protected boolean isPlugged;
    protected boolean isTurnedOn;

    public Appliance(String title, AppliancePurpose appliancePurpose, int power, int weight, Color color) {
        this.title = title;
        this.appliancePurpose = appliancePurpose;
        this.power = power;
        this.weight = weight;
        this.color = color;
        isPlugged = false;
        isTurnedOn = false;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public AppliancePurpose getAppliancePurpose() {
        return appliancePurpose;
    }

    public void setAppliancePurpose(AppliancePurpose appliancePurpose) {
        this.appliancePurpose = appliancePurpose;
    }

    public int getPower() {
        return power;
    }

    public void setPower(int power) {
        this.power = power;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public boolean isPlugged() {
        return isPlugged;
    }

    public void setPlugged(boolean plugged) {
        isPlugged = plugged;
    }

    public boolean isTurnedOn() {
        return isTurnedOn;
    }

    public void setTurnedOn(boolean turnedOn) {
        isTurnedOn = turnedOn;
    }

    public void plug() {
        isPlugged = true;
    }

    public void turnOn() throws CannotTurnOnDueToUnpluggedlException {
        if (!isPlugged)
            throw new CannotTurnOnDueToUnpluggedlException("Cannot to turn on the appliance due to it is unplugged");
        else isTurnedOn = true;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Appliance appliance = (Appliance) o;
        return getPower() == appliance.getPower() &&
                getWeight() == appliance.getWeight() &&
                isPlugged() == appliance.isPlugged() &&
                isTurnedOn() == appliance.isTurnedOn() &&
                getTitle().equals(appliance.getTitle()) &&
                getAppliancePurpose() == appliance.getAppliancePurpose() &&
                getColor() == appliance.getColor();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getTitle(), getAppliancePurpose(), getPower(), getWeight(), getColor(), isPlugged(), isTurnedOn());
    }

    @Override
    public String toString() {
        return "Appliance{" +
                "title='" + title + '\'' +
                ", appliancePurpose=" + appliancePurpose +
                ", power=" + power +
                ", weight=" + weight +
                ", color=" + color +
                ", isPlugged=" + isPlugged +
                ", isTurnedOn=" + isTurnedOn +
                '}';
    }

}
