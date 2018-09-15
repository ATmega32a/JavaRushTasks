package com.javarush.task.task31.task3105;

import java.io.*;
import java.nio.file.*;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;

/* 
Добавление файла в архив
*/
public class Solution {
    public static void main(String[] args) throws IOException {
        FileInputStream fis = new FileInputStream(args[1]);
        ZipInputStream zis = new ZipInputStream(fis);

        FileOutputStream zfos = new FileOutputStream(args[1]);
        ZipOutputStream zos = new ZipOutputStream(zfos);

//      Path zipPathTemp = Files.createTempFile("tempZip", ".zip");
        Path zipPathTemp = Files.createTempDirectory("zipFilesDirTemporary");

        System.out.println(zipPathTemp);

        // пройтись по дереву архива
        // прочитать все файлы
        // записать их во временную директорию
        // создать во временной директории директорию new
        // записать в неё файл из args[0]
        // пройтись по временной директории и
        // записать entry для этих файлов













//        Path zipArchive = Paths.get(args[1]);
//        System.out.println(zipArchive);
//        System.out.println(zipPathTemp);
//        Files.createTempDirectory("zipFilesDirTemporary");

 //       copy(zipArchive, zipPathTemp);

    }

    public static void copy(Path source, Path target) {
        CopierFileTree copierFileTree = new CopierFileTree();
        copierFileTree.setSource(source);
        copierFileTree.setTarget(target);

        CopierFileVisitor visitor = new CopierFileVisitor();
        try {
            Files.walkFileTree(copierFileTree.getSource(), visitor);
            copierFileTree.createTreeOfFiles(copierFileTree.getSource(), copierFileTree.getTarget());
            System.out.println("Copied successfully");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}



























//    FileInputStream fis = new FileInputStream(args[1]);
//    ZipInputStream zis = new ZipInputStream(fis);
//
//    FileOutputStream zfos = new FileOutputStream(args[1]);
//    ZipOutputStream zos = new ZipOutputStream(zfos);
//
//    Path tempFile = Paths.get(String.valueOf(File.createTempFile("temp-", ".tmp")));
//        try (FileOutputStream fos = new FileOutputStream(tempFile.toFile())) {
//                while (zis.available() != 0) {
//                zis.getNextEntry();
//                write(zis, fos);
//                // fos.(zis.read());
//                }
//                }
//                // File dir = new File("new");
//                // zos.putNextEntry(new ZipEntry(dir.getPath()));
//                Path path = Paths.get("d:/testdata/new");
//                if (Files.notExists(path)) {
//                Path directory = Files.createDirectory(path);
//                Path pathToFile = Paths.get(directory.toAbsolutePath()+"/"+Paths.get(args[0]).getFileName());
//                Path newFile = Files.createFile(pathToFile);
//                zos.putNextEntry(new ZipEntry(directory.getFileName() + "/"));
//                zos.putNextEntry(new ZipEntry(newFile.toString()));
//                //   Files.delete(Paths.get(directory.toAbsolutePath() + "/file.txt"));
//                //   Files.delete(directory);
//                }
//                }
//public static void putToArchive(ZipOutputStream zip,Path path) throws IOException {
//        if(Files.notExists(path)){
//        //   if(Files.isDirectory(path.toAbsolutePath())){
//        Path file = Files.createDirectory(path);
//        Files.createFile(Paths.get(file.toAbsolutePath()+"/file.txt"));
//        zip.putNextEntry(new ZipEntry(file.getFileName()+"/"));
//        Files.delete(Paths.get(file.toAbsolutePath()+"/file.txt"));
//        Files.delete(file);
//        }
//        zip.close();
//        }
//private static void write(InputStream in, OutputStream out) throws IOException {
//        byte[] buffer = new byte[1024];
//        int len;
//        while ((len = in.read(buffer)) >= 0)
//        out.write(buffer, 0, len);
////   out.close();
////  in.close();
