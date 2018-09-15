package com.javarush.task.task19.task1923;

/* 
Слова с цифрами
*/

import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader file = new BufferedReader(new FileReader(args[0]));
        BufferedWriter fileWrite = new BufferedWriter(new FileWriter(args[1]));
        Pattern p = Pattern.compile("\\w+\\d+\\w+");
        StringBuilder sb = new StringBuilder();
        while(file.ready()){
            String s = file.readLine();
            Matcher m = p.matcher(s);
            while (m.find()){
                String strOut = m.group();
                fileWrite.write(strOut+" ");
            }
        }
        file.close();
        fileWrite.close();
    }
}
