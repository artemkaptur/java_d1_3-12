package com.epam.workingwithfiles.task3;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.*;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

import static java.nio.charset.StandardCharsets.UTF_8;
import static java.nio.file.StandardCopyOption.REPLACE_EXISTING;

public class FastFileMover {

    private static final Logger logger = LogManager.getLogger(FastFileMover.class);

    public void moveFileWithFileStream(String sourceFilePath, String destDir) {
        createDirectory(destDir);
        File sourceFile = new File(sourceFilePath);
        try (FileInputStream fis = new FileInputStream(sourceFilePath);
             FileOutputStream fos = new FileOutputStream(destDir + File.separator + sourceFile.getName())) {
            int data = fis.read();
            while (data != -1) {
                fos.write(data);
                data = fis.read();
            }
        } catch (IOException e) {
            logger.error(e.getStackTrace());
        }
    }

    public void moveFileWithBufferedStream100(String sourceFilePath, String destDir) {
        createDirectory(destDir);
        File sourceFile = new File(sourceFilePath);
        try (BufferedInputStream bis = new BufferedInputStream(new FileInputStream(sourceFilePath), 102400);
             BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(destDir + File.separator + sourceFile.getName()),
                     102400)) {
            int data = bis.read();
            while (data != -1) {
                bos.write(data);
                data = bis.read();
            }
            bos.flush();
        } catch (IOException e) {
            logger.error(e.getStackTrace());
        }
    }

    public void moveFileWithFileChannel(String sourceFilePath, String destDir) {
        createDirectory(destDir);
        File sourceFile = new File(sourceFilePath);
        try (FileChannel inChannel = new FileInputStream(sourceFilePath).getChannel();
             FileChannel outChannel = new FileOutputStream(destDir + File.separator + sourceFile.getName()).getChannel()) {
            ByteBuffer buffer = ByteBuffer.allocate(100);
            int data = inChannel.read(buffer);
            while (data != -1) {
                data = inChannel.read(buffer);
            }
            buffer.flip();
            while (buffer.hasRemaining()) {
                outChannel.write(buffer);
            }
        } catch (IOException e) {
            logger.error(e.getStackTrace());
        }
    }

    public void moveFileWithNIO2(String sourceFilePath, String targetDir) {
        createDirectory(targetDir);
        File sourceFile = new File(sourceFilePath);
        Path source = Paths.get(sourceFilePath);
        Path destination = Paths.get(targetDir + File.separator + sourceFile.getName());
        try {
            Files.move(source, destination, REPLACE_EXISTING);
        } catch (IOException e) {
            logger.error(e.getStackTrace());
        }
    }

    public void createFile(String dir, String fileName) throws IOException {
        List<String> lines = Arrays.asList("Hello world", "What's up?");
        Path file = Paths.get(dir + File.separator + fileName);
        Files.write(file, lines, UTF_8);
    }

    private static void createDirectory(String path) {
        File targetDirectory = new File(path);
        if (!targetDirectory.exists()) {
            targetDirectory.mkdir();
        }
    }

}
