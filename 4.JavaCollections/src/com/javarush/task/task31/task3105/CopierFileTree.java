package com.javarush.task.task31.task3105;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;

public class CopierFileTree {
    private Path source;
    private Path target;
    static ArrayList<Path> listOfFiles = new ArrayList<>();
    static ArrayList<Path> listOfDirs = new ArrayList<>();

    public Path getSource() {
        return source;
    }

    public void setSource(Path source) {
        this.source = source;
    }

    public Path getTarget() {
        return target;
    }

    public void setTarget(Path target) {
        this.target = target;
    }

    public void createTreeOfFiles(Path source, Path target) throws IOException {
        for (Path path: listOfDirs)
            Files.createDirectories(target.resolve(source.relativize(path)));

        for (Path file : listOfFiles) {
            Files.createFile(target.resolve(source.relativize(file)));
            Files.copy(file,target.resolve(source.relativize(file)),StandardCopyOption.REPLACE_EXISTING);
        }
    }
}
