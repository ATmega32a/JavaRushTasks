package com.javarush.task.task13.task1318;
import java.io.*;


/*
Чтение файла
*/
public class Solution {
    public static void main(String[] args) throws IOException {
        // напишите тут ваш код
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = reader.readLine();
        InputStream readingFile = new FileInputStream(fileName);
        while(readingFile.available() > 0){
            int buffer = readingFile.read();
            char simbols = (char) buffer;
            System.out.print(simbols);
        }
        readingFile.close();
        reader.close();
        System.out.println();
    }
}