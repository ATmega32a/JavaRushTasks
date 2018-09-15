package com.javarush.task.task19.task1907;

/* 
Считаем слово
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = reader.readLine();
        int counter = 0;
        reader.close();
        FileReader fileReader = new FileReader(fileName);
        String data = "";
        while (fileReader.ready()){
            data += (char)fileReader.read();
        }
        fileReader.close();
        for (String st: data.split("(\\s|\\.|,|!|\\?|\\(|\\)|\"|-|:|;)")) {
                if(st.equals("world")) counter++;
            }
        System.out.print(counter);
   }
}
