package com.epam.workingwithfiles.task1;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.*;

public class SerializationUtils {

    private static final Logger logger = LogManager.getLogger(SerializationUtils.class);

    public <T> void serialize(String path, T t) {
        logger.info("Serializing " + t.getClass().getSimpleName());
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(path))) {
            oos.writeObject(t);
        } catch (IOException e) {
            logger.error("Cannot perform serialization:\n" + e.getMessage());
        }
        logger.info("Serialization completed, path - " + path);
    }

    public <T> T deserialize(String path, Class<T> clazz) {
        logger.info("Deserializing from " + path);
        T instance = null;
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(path))) {
            instance = clazz.cast(ois.readObject());
        } catch (IOException | ClassNotFoundException e) {
            logger.error("Cannot perform deserialization:\n" + e.getMessage());
        }
        logger.info("Deserialization completed, class - " + clazz.getSimpleName());
        return instance;
    }

}
