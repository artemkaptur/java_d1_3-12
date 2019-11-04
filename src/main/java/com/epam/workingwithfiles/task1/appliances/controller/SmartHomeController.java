package com.epam.workingwithfiles.task1.appliances.controller;

import com.epam.workingwithfiles.task1.appliances.annotations.ThisCodeSmells;
import com.epam.workingwithfiles.task1.appliances.model.Appliance;

import java.util.ArrayList;
import java.util.List;

import static com.epam.workingwithfiles.task1.appliances.model.AppliancePurpose.COOKING;
import static java.util.Comparator.comparing;
import static java.util.stream.Collectors.toList;

public class SmartHomeController {

    private static SmartHomeController instance;
    private List<Appliance> appliances;

    private SmartHomeController() {
        appliances = new ArrayList<>();
    }

    public static SmartHomeController getInstance() {
        if (instance == null) {
            instance = new SmartHomeController();
        }
        return instance;
    }

    public SmartHomeController addAppliance(Appliance appliance) {
        appliances.add(appliance);
        return this;
    }

    /**
     * @deprecated use {@link #getCurrentTotalPowerConsumption()} instead
     */
    @Deprecated // Task 1
    public int getTotalPowerConsumption() {
        return appliances.stream().mapToInt(Appliance::getPower).sum();
    }

    public int getCurrentTotalPowerConsumption() {
        return appliances.stream().filter(Appliance::isPlugged).mapToInt(Appliance::getPower).sum();
    }

    @ThisCodeSmells(reviewer = "Vanya")
    public List<Appliance> getCookingAppliancesByPower(int min, int max) {
        return appliances.stream()
                .filter(a -> a.getAppliancePurpose() == COOKING)
                .filter(a -> (a.getPower() > min && a.getPower() < max))
                .collect(toList());
    }

    public void sortByApplianceType() {
        appliances.sort(comparing(Appliance::getAppliancePurpose));
    }

    public void showAllAppliances() {
        appliances.forEach(a -> System.out.println(a.toString()));
    }

}
