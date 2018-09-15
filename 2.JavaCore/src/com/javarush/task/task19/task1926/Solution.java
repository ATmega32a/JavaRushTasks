package com.javarush.task.task19.task1926;

/* 
Перевертыши
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws IOException, InterruptedException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        FileReader fileReader = new FileReader(reader.readLine());
        reader.close();
        BufferedReader file = new BufferedReader(fileReader);
        StringBuilder sb = new StringBuilder();
        while (file.ready()) {
            sb.append(file.readLine());
            System.out.println(sb.reverse());
            sb.delete(0,sb.length());
        }
            fileReader.close();
    }
}
