package com.epam.workingwithfiles.task2;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.File;
import java.util.*;

import static java.util.Comparator.comparing;
import static java.util.stream.Collectors.toList;

public class DiskAnalyzer {

    private static final Logger logger = LogManager.getLogger(DiskAnalyzer.class);

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        logger.info("Please, write the Path:");
        String selectedPath = scanner.nextLine();

        logger.info("Path - " + selectedPath);
        File starterDir = new File(selectedPath);
        logger.info("Please, select the function:\n 1 - \'s\' task, 2 - top-5 biggest files, 3 - average size, 4 - count of files by alphabet");
        int function = scanner.nextInt();

        List<File> files = new ArrayList<>();
        findFiles(starterDir, files);
        logger.info("Count of files in " + selectedPath + " - " + files.size());
        switch (function) {
            case 1: {
                logger.info("\'s\' task selected");
                File file = files.stream().max(comparing(f -> f.getName().chars().filter(c -> c == 's').count())).orElseThrow();
                logger.info("File with max count of \'s\' in " + selectedPath + " - " + file.getName());
                break;
            }
            case 2: {
                logger.info("Top-5 biggest files task selected");
                List<File> fiveBiggestFiles = files.stream().sorted(comparing(File::length).reversed()).limit(5).collect(toList());
                fiveBiggestFiles.forEach(file -> logger.info(file.getName()));
                break;
            }
            case 3: {
                logger.info("Average size task selected");
                double average = files.stream().mapToLong(File::length).average().getAsDouble();
                logger.info("Average size of files in " + selectedPath + " - " + average + " bytes");
                break;
            }
            case 4: {
                logger.info("Count of files by alphabet task selected");
                Map<Character, List<File>> filesByAlphabet = getFilesByAlphabet(files);
                filesByAlphabet.forEach((character, list) -> {
                    logger.info("Character - " + character);
                    list.forEach(logger::info);
                });
                break;
            }
            default: {
                logger.info("You type wrong input");
            }
        }
    }

    private static void findFiles(File dir, List<File> results) {
        File[] files = dir.listFiles();
        if (files != null) {
            for (File file : files) {
                if (file.isDirectory()) {
                    findFiles(file, results);
                } else {
                    results.add(file);
                }
            }
        }
    }

    private static Map<Character, List<File>> getFilesByAlphabet(List<File> files) {
        Map<Character, List<File>> result = new HashMap<>();
        for (File file : files) {
            char fileFirstLetter = file.getName().charAt(0);
            if (!result.containsKey(fileFirstLetter)) {
                List<File> charFiles = new ArrayList<>();
                charFiles.add(file);
                result.put(fileFirstLetter, charFiles);
            } else {
                List<File> charFiles = result.get(fileFirstLetter);
                charFiles.add(file);
            }
        }
        return result;
    }

}
