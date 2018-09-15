package com.javarush.task.task18.task1816;

/*
Английские буквы
*/

import java.io.FileInputStream;
import java.io.IOException;

public class Solution {
    public static void main(String[] args) throws IOException {
       FileInputStream file = new FileInputStream(args[0]);
       int counter = 0;
        char data;
        while (file.available() > 0) {
            data = (char) file.read();
            for (int i = 0; i <= 25; i++) {
                if (data==(char)(i + 65) || data==(char)(i + 97)) counter++;
            }
        }
        file.close();
        System.out.print(counter);

    }
}
