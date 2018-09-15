package com.javarush.task.task18.task1809;

/* 
Реверс файла
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName1 = reader.readLine();
        String fileName2 = reader.readLine();
        FileInputStream file1 = new FileInputStream(fileName1);
        FileOutputStream file2 = new FileOutputStream(fileName2);
        int data[] = new int[file1.available()];
        int i = 0;
        while (file1.available() > 0){
            data[i] = file1.read();
            i++;
        }
        file1.close();

        for (int j = data.length-1; j >= 0; j--) {
           file2.write(data[j]);
        }
        file2.close();

    }
}
