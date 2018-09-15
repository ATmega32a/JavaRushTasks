package com.javarush.task.task18.task1810;

/*
DownloadException
*/

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws IOException, DownloadException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = reader.readLine();
        FileInputStream file = new FileInputStream(fileName);
        int counter = 0;
        int[] data;
        while (true){
            data = new int[file.available()];
            while(file.available() > 0){
                data[counter] = file.read();
                counter++;
            }
            if(counter < 1000){
                reader.close();
                file.close();
                throw new DownloadException();
            } else {
                counter = 0;
                fileName = reader.readLine();
                file = new FileInputStream(fileName);
            }
        }

   }
    public static class DownloadException extends Exception {
    }
}
