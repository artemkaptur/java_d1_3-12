package com.epam.workingwithfiles.task1.appliances.exception;

@SuppressWarnings("serial") // Task 1
public class CannotTurnOnDueToParentalControlException extends CannotTurnOnDueToUnpluggedlException {

    public CannotTurnOnDueToParentalControlException(String message) {
        super(message);
    }

}
