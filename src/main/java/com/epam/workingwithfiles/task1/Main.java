package com.epam.workingwithfiles.task1;

import com.epam.workingwithfiles.task1.appliances.model.cooking.CoffeeMachine;
import com.epam.workingwithfiles.task1.appliances.model.relax.TV;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import static com.epam.workingwithfiles.task1.appliances.model.Color.BLACK;
import static com.epam.workingwithfiles.task1.appliances.model.Color.WHITE;

public class Main {

    private static final Logger logger = LogManager.getLogger(Main.class);

    public static void main(String[] args) {
        CoffeeMachine coffeeMachine = new CoffeeMachine("Coffee machine", 1500, 1600, BLACK);
        logger.info("Available beverages - " + coffeeMachine.getAvailableBeverages());
        coffeeMachine.makeBeverage();
        coffeeMachine.makeBeverage();
        logger.info("Available beverages after making some - " + coffeeMachine.getAvailableBeverages());

        SerializationUtils serializationUtils = new SerializationUtils();
        String path = "justfile.out";
        serializationUtils.serialize(path, coffeeMachine);
        CoffeeMachine deserializedCoffeeMachine = serializationUtils.deserialize(path, CoffeeMachine.class);
        logger.info("Available beverages after deserialization - " + deserializedCoffeeMachine.getAvailableBeverages());

        TV tv = new TV("TV", 4000, 7000, WHITE);
        tv.setScreenSize(50);
        logger.info("Screen size is - " + tv.getScreenSize());

        serializationUtils.serialize(path, tv);
        TV deserializedTv = serializationUtils.deserialize(path, TV.class);
        logger.info("Screen size still is zero - " + deserializedTv.getScreenSize());
    }

}
