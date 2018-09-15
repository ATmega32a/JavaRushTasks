package com.javarush.task.task19.task1919;

/*
Считаем зарплаты
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Map;
import java.util.TreeMap;

public class Solution {
    public static void main(String[] args) throws IOException {
        FileReader fileReader = new FileReader(args[0]);
        BufferedReader reader = new BufferedReader(fileReader);
        Map<String, Double> sortedMap = new TreeMap<>();
        String[] s;
        while (reader.ready()){
            s = reader.readLine().split(" ");
            String str = s[0];
            double d = Double.parseDouble(s[1]);

           for (Map.Entry e: sortedMap.entrySet()) {
                if(str.equals(e.getKey())){
                    d += Double.parseDouble(e.getValue().toString());
                }
            }
            sortedMap.put(s[0], d);
        }
        fileReader.close();
        for (Map.Entry e: sortedMap.entrySet()) {
            System.out.println(e.getKey()+" "+e.getValue());
        }
    }
}
