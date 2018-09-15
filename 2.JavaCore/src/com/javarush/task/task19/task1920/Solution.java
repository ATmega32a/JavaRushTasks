package com.javarush.task.task19.task1920;

/* 
Самый богатый
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
        Double arr[] = new Double[sortedMap.size()];
        fileReader.close();
        int index = 0;
        for (Map.Entry e: sortedMap.entrySet()) {
            arr[index] = (Double)e.getValue();
            index++;
        }
        Double maxElemOfArray = arr[0];
        for (int i = 0; i < arr.length; i++) {
            if (maxElemOfArray < arr[i]) maxElemOfArray = arr[i];

        }
        for (Map.Entry e:sortedMap.entrySet()) {
            if (e.getValue().equals(maxElemOfArray)) System.out.println(e.getKey());

        }

    }

}
