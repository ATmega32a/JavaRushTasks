package com.javarush.task.task31.task3105;

import java.nio.file.FileVisitResult;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;

public class CopierFileVisitor extends SimpleFileVisitor<Path> {
    @Override
    public FileVisitResult visitFile(Path path, BasicFileAttributes attrs){
        CopierFileTree.listOfFiles.add(path);
        return FileVisitResult.CONTINUE;
    }
    @Override
    public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs){
        CopierFileTree.listOfDirs.add(dir);
        return FileVisitResult.CONTINUE;
    }
}
