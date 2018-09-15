package com.javarush.task.task19.task1922;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/*
Ищем нужные строки
*/

public class Solution {
    public static List<String> words = new ArrayList<String>();

    static {
        words.add("файл");
        words.add("вид");
        words.add("В");
    }

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader file = new BufferedReader(new FileReader(reader.readLine()));
        reader.close();
        int count = 0;
        int i = 0;
        ArrayList<String[]> list = new ArrayList<>();
        String[] s;
        while (file.ready()) {
            s = file.readLine().split("\\s");
            for (String st:words) {
                for (String value : s) {
                    if (value.equals(st)) count++;
                }
            }
            if (count==2) {
                for (String str: s) {
                    System.out.print(str+" ");

                }
                System.out.println();
            }
                count=0;
       }
        file.close();
    }
}