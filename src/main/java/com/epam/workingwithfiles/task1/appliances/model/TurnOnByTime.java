package com.epam.workingwithfiles.task1.appliances.model;

import com.epam.workingwithfiles.task1.appliances.exception.CannotTurnOnDueToParentalControlException;
import com.epam.workingwithfiles.task1.appliances.model.relax.RelaxAppliance;

@FunctionalInterface // Task 1
public interface TurnOnByTime {

    void setTheTimer(RelaxAppliance appliance, int hour) throws CannotTurnOnDueToParentalControlException;

}
