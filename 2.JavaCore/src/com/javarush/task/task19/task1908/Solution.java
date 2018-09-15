package com.javarush.task.task19.task1908;

/* 
Выделяем числа
*/

import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName1 = reader.readLine();
        String fileName2 = reader.readLine();
        reader.close();
        BufferedReader file1 = new BufferedReader(new FileReader(fileName1));
        BufferedWriter file2 = new BufferedWriter(new FileWriter(fileName2));
        String data = "";
        Pattern p = Pattern.compile("\\d+");
        Pattern p1 = Pattern.compile("\\s");

        while (file1.ready()){
            data += (char)file1.read();
        }
        for (String st: data.split(p1.pattern())) {
            Matcher m = p.matcher(st);
            if(m.matches()){
                String s = st + " ";
                file2.write(s);
            }
        }
        file1.close();
        file2.close();
    }
}
