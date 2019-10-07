package com.epam.jvmgc.task4;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

public class CustomClassLoader extends ClassLoader {

    @Override
    public Class<?> findClass(String name) {
        byte[] classBytes = loadClassData(name);
        return defineClass(name, classBytes, 0, classBytes.length);
    }

    private byte[] loadClassData(String className) {
        InputStream inputStream = getClass().getClassLoader().getResourceAsStream(className.replace(".", "/") + ".class");
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        int length;
        try {
            if (inputStream != null) {
                while ((length = inputStream.read()) != -1) {
                    byteArrayOutputStream.write(length);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return byteArrayOutputStream.toByteArray();
    }

}
