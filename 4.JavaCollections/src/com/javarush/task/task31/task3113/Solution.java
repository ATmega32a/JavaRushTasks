package com.javarush.task.task31.task3113;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;


/* 
Что внутри папки?
*/
public class Solution {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Path path = Paths.get(reader.readLine());
        MyFileVisitor fileVisitor = new MyFileVisitor();
        Files.walkFileTree(path,fileVisitor);

        if(Files.isRegularFile(path)) {
            String answer = path.toAbsolutePath() +  " - не папка";
                System.out.println(answer);
        } else {

            System.out.println("Всего папок - " + (fileVisitor.quantityOfDir - 1));
            System.out.println("Всего файлов - " + fileVisitor.quantityOfFiles);
            System.out.println("Общий размер - " + fileVisitor.totalSize);
        }
    }

static class MyFileVisitor extends SimpleFileVisitor<Path>{
        long quantityOfDir = 0;
        long quantityOfFiles = 0;
        long totalSize = 0;
        @Override
        public FileVisitResult visitFile(Path path, BasicFileAttributes attr){
           totalSize+=attr.size();
           quantityOfFiles++;
           return FileVisitResult.CONTINUE;
        }
        @Override
        public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attr){

            quantityOfDir++;
            return FileVisitResult.CONTINUE;
        }
}
}
