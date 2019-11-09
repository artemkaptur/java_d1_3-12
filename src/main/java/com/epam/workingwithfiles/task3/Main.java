package com.epam.workingwithfiles.task3;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.File;
import java.io.IOException;

public class Main {

    private static final Logger logger = LogManager.getLogger(Main.class);

    public static void main(String[] args) throws IOException {
        FastFileMover fastFileMover = new FastFileMover();
        String destDir = "c:\\temp\\foo";
        String srcDir = "c:\\temp";
        String fileName = "justfile.txt";
        String filePath = srcDir + File.separator + fileName;
        fastFileMover.createFile(srcDir, fileName);

        logger.info("Moving file by FileStream");
        fastFileMover.moveFileWithFileStream(filePath, destDir);

        logger.info("Moving file by BufferedStream");
        fastFileMover.moveFileWithBufferedStream100(filePath, destDir);

        logger.info("Moving file by FileChannel");
        fastFileMover.moveFileWithFileChannel(filePath, destDir);

        logger.info("Moving file by NIO 2");
        fastFileMover.moveFileWithNIO2(filePath, destDir);
    }

}
