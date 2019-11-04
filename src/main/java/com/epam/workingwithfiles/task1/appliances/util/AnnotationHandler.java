package com.epam.workingwithfiles.task1.appliances.util;

import com.epam.workingwithfiles.task1.appliances.annotations.ProdCode;
import com.epam.workingwithfiles.task1.appliances.annotations.ThisCodeSmells;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Enumeration;
import java.util.List;

import static java.util.Objects.requireNonNull;

public final class AnnotationHandler {

    private AnnotationHandler() {
    }

    // Task 2.4
    @ProdCode // Task 2.5
    public static void printAllSmellingCode() throws IOException, ClassNotFoundException {
        List<Class> classes = getClasses("com.epam.workingwithfiles.task1.appliances");

        classes.stream()
                .filter(c -> c.isAnnotationPresent(ThisCodeSmells.class))
                .forEach(c -> System.out.println("Code in this class smells - " + c.getName()));

        classes.stream()
                .flatMap(c -> Arrays.stream(c.getMethods()))
                .filter(m -> m.isAnnotationPresent(ThisCodeSmells.class))
                .forEach(m -> System.out.println("This method smells - " + m.getName() + " by "
                        + m.getAnnotation(ThisCodeSmells.class).reviewer()));

        classes.stream()
                .flatMap(c -> Arrays.stream(c.getFields()))
                .filter(f -> f.isAnnotationPresent(ThisCodeSmells.class))
                .forEach(f -> System.out.println("This field smells - " + f.getName() + " by "
                        + f.getAnnotation(ThisCodeSmells.class).reviewer()));
    }

    // Task 2.5
    public static void runAllProdMethods() throws IOException, ClassNotFoundException {
        getClasses("com.epam.workingwithfiles.task1.appliances").stream()
                .flatMap(c -> Arrays.stream(c.getMethods()))
                .filter(m -> m.isAnnotationPresent(ProdCode.class))
                .forEach(m -> {
                    System.out.println("Invoking method - " + m.getName());
                    try {
                        m.invoke(null);
                    } catch (IllegalAccessException | InvocationTargetException e) {
                        e.printStackTrace();
                    }
                });
    }

    public static void printClassMetadata(Class<?> clazz) {
        System.out.println("============= " + clazz + " metadata ================");
        System.out.println("Superclass name - " + clazz.getSuperclass().getName());
        System.out.println("Class name - " + clazz.getName());
        System.out.println("Class modifiers: " + Modifier.toString(clazz.getModifiers()));
        System.out.print("Implemented interfaces:");
        Class[] interfaces = clazz.getInterfaces();
        if (interfaces.length > 0) {
            for (Class interf : interfaces) {
                System.out.println(interf.getName() + " ");
            }
        } else System.out.println("There are no implemented interfaces");

        printFieldsMetadata(clazz);
        printMethodsMetadata(clazz);
    }

    private static void printFieldsMetadata(Class<?> clazz) {
        System.out.println("============= Fields metadata ==================");
        Field[] fields = clazz.getDeclaredFields();
        for (Field field : fields) {
            System.out.println("Field modifiers: " + Modifier.toString(field.getModifiers()));
            System.out.println("Field type: " + field.getType());
            System.out.println("Field name: " + field.getName());
        }
    }

    private static void printMethodsMetadata(Class<?> clazz) {
        System.out.println("============= Methods metadata ==================");
        Method[] methods = clazz.getDeclaredMethods();
        for (Method method : methods) {
            System.out.println("Method modifiers: " + Modifier.toString(method.getModifiers()));
            System.out.println("Return type: " + method.getReturnType());
            System.out.println("Method name: " + method.getName());
            System.out.print("Method parameter types: ");
            Class<?>[] parameterTypes = method.getParameterTypes();
            if (parameterTypes.length > 0) {
                for (Class parameterType : parameterTypes) {
                    System.out.print(parameterType.getName() + " ");
                }
            } else System.out.print("There are no parameters");
        }
    }

    public static List<Class> getClasses(String packageName)
            throws ClassNotFoundException, IOException {
        ClassLoader classLoader = requireNonNull(Thread.currentThread().getContextClassLoader());
        String path = packageName.replace('.', '/');
        Enumeration<URL> resources = classLoader.getResources(path);
        List<File> dirs = new ArrayList<>();
        while (resources.hasMoreElements()) {
            URL resource = resources.nextElement();
            dirs.add(new File(resource.getFile()));
        }
        ArrayList<Class> classes = new ArrayList<>();
        for (File directory : dirs) {
            classes.addAll(findClasses(directory, packageName));
        }
        return classes;
    }

    private static List<Class> findClasses(File directory, String packageName) throws ClassNotFoundException {
        List<Class> classes = new ArrayList<>();
        if (!directory.exists()) {
            return classes;
        }
        File[] files = requireNonNull(directory.listFiles());
        for (File file : files) {
            if (file.isDirectory()) {
                assert !file.getName().contains(".");
                classes.addAll(findClasses(file, packageName + "." + file.getName()));
            } else if (file.getName().endsWith(".class")) {
                classes.add(Class.forName(packageName + '.' + file.getName().substring(0, file.getName().length() - 6)));
            }
        }
        return classes;
    }

}
