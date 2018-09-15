package com.javarush.task.task31.task3101;

import java.io.*;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/*
Проход по дереву файлов
*/
public class Solution {
    public static void main(String[] args) throws IOException {
        Path path = Paths.get(args[0]);
        String resultFileAbsolutePath = args[1];

        Path file = Paths.get(path.toString()+"/"+resultFileAbsolutePath);
        File newFile = new File(path.toString().concat("/allFilesContent.txt"));
        FileUtils.renameFile(file.toFile(),newFile);
        MyFileVisitor visitor = new MyFileVisitor();
        Files.walkFileTree(path,visitor);
        Collections.sort(visitor.pathList);

        try (BufferedWriter fos = new BufferedWriter(new FileWriter(newFile.getAbsolutePath()))){
            for (Path f :visitor.pathList) {
                try (BufferedReader fis = new BufferedReader(new FileReader(String.valueOf(f)))) {
                    while (fis.ready()){
                        fos.write(fis.readLine());
                        fos.newLine();
                    }
                }catch (FileNotFoundException e){
                    e.printStackTrace();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
    static class MyFileVisitor extends SimpleFileVisitor<Path> {
        List<Path> pathList = new ArrayList<>();
        @Override
        public FileVisitResult visitFile(Path path, BasicFileAttributes attributes){
            if(Files.isRegularFile(path)) {
                if(attributes.size() <= 50){
                    pathList.add(path);
                }
            }
            return FileVisitResult.CONTINUE;
        }

    }

}
