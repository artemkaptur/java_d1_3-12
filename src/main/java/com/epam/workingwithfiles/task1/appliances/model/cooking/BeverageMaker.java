package com.epam.workingwithfiles.task1.appliances.model.cooking;

import com.epam.workingwithfiles.task1.appliances.exception.NotEnoughWaterException;
import com.epam.workingwithfiles.task1.appliances.exception.TheBeverageMakerIsFullException;
import com.epam.workingwithfiles.task1.appliances.model.Appliance;
import com.epam.workingwithfiles.task1.appliances.model.AppliancePurpose;
import com.epam.workingwithfiles.task1.appliances.model.Color;

public abstract class BeverageMaker extends Appliance {

    protected transient int maxCountOfBeverages = 3;
    protected transient int availableBeverages;

    public int getAvailableBeverages() {
        return availableBeverages;
    }

    public BeverageMaker(String title, AppliancePurpose appliancePurpose, int power, int weight, Color color) {
        super(title, appliancePurpose, power, weight, color);
        availableBeverages = maxCountOfBeverages;
    }

    public void makeBeverage() {
        if (availableBeverages == 0) {
            throw new NotEnoughWaterException("Not enough water for making beverage, add water please");
        } else availableBeverages--;
    }

    public void addWater() {
        if (availableBeverages == maxCountOfBeverages) {
            throw new TheBeverageMakerIsFullException("The Beverage Maker is full, it doesn't need any water");
        } else availableBeverages = maxCountOfBeverages;
    }


}
