package com.javarush.task.task18.task1817;

/* 
Пробелы
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        FileInputStream file = new FileInputStream(args[0]);
        int count = 0;
        int countSpace = 0;
        char[] simbols = new char[file.available()];
        int index = 0;
        while (file.available() > 0){
            simbols[index] = (char) file.read();
            index++;
        }
        for (int i = 0; i < simbols.length ; i++) {
            if(simbols[i] == 32) countSpace++;
            count++;
        }
        double relativeOfNumbersSimbols =   ((double)countSpace / (double)count) * 100;
        System.out.println(String.format("%(.2f", relativeOfNumbersSimbols));
        file.close();
    }
}
