package com.javarush.task.task18.task1822;

/*
Поиск данных внутри файла
*/

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = reader.readLine();
        BufferedReader lineFromFile = new BufferedReader(new InputStreamReader(new FileInputStream(fileName)));
        String strFromFile = "";
        while (lineFromFile.ready()) {
            strFromFile = lineFromFile.readLine();
            if (strFromFile.startsWith(args[0])) System.out.print(strFromFile);
        }
        reader.close();
        lineFromFile.close();
    }
}
