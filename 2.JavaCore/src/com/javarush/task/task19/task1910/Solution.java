package com.javarush.task.task19.task1910;

/* 
Пунктуация
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName1 = reader.readLine();
        String fileName2 = reader.readLine();
        reader.close();
        BufferedReader file1 = new BufferedReader(new FileReader(fileName1));
        BufferedWriter file2 = new BufferedWriter(new FileWriter(fileName2));
        String data ="";
        while (file1.ready()){
            data += (char)file1.read();

        }
        for (String st: data.split("")) {
            file2.write(st.replaceAll("(\\W)",""));
        }
        file1.close();
        file2.close();
    }
}