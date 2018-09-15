package com.javarush.task.task18.task1825;

/*
Собираем файл
*/

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Solution {
    public static void main(String[] args) throws IOException{

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String writingFilePath ="";
        BufferedInputStream fileInputStream = null;
        Pattern fileNamesPattern = Pattern.compile(".+\\.part\\d+");
        Pattern outputPathPattern = Pattern.compile("\\.part\\d+");
        ArrayList<String> pathes = new ArrayList<>();

        char bufferData;
        while (true){
            String readingFilePath = reader.readLine();
            if(readingFilePath.equals("end"))break;
            else {
                Matcher fileNamesMatcher = fileNamesPattern.matcher(readingFilePath);
                while (fileNamesMatcher.find()) {
                    pathes.add(fileNamesMatcher.group());
                    Matcher outputPathMatcher = outputPathPattern.matcher(fileNamesMatcher.group());
                    if (outputPathMatcher.find()) {
                        writingFilePath = fileNamesMatcher.group().substring(fileNamesMatcher.start(), outputPathMatcher.start());
                    }
                }
            }
        }
        reader.close();
        Collections.sort(pathes);
        for (String path : pathes) {
            fileInputStream = new BufferedInputStream( new FileInputStream(path));
            while (fileInputStream.available() >0){
                bufferData = (char)fileInputStream.read();
                appendUsingOutputStream(writingFilePath, String.valueOf(bufferData));
            }
            fileInputStream.close();
        }
    }
    private static void appendUsingOutputStream(String fileName, String data) {
        BufferedOutputStream outputStream = null;

        try {
            //в конструкторе FileOutputStream используем флаг true, который обозначает обновление содержимого файла

            outputStream = new BufferedOutputStream(new FileOutputStream(new File(fileName), true));
            outputStream.write(data.getBytes(), 0, data.length());
        } catch (IOException e) {
            e.printStackTrace();
        }finally{
            try {
                assert outputStream != null;
                outputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
