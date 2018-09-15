package com.javarush.task.task18.task1804;

/*
Самые редкие байты
*/

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader readFile = new BufferedReader(new InputStreamReader(System.in));
        FileInputStream fileInput = new FileInputStream(readFile.readLine());
        Map<Integer, Integer> map = new HashMap();
        Integer val = 1;
        int data= fileInput.read();
        map.put(data,val);
        while (fileInput.available() > 0) {
            data = fileInput.read();
            if(map.containsKey(data)){
                val = map.get(data);
                map.put(data,++val);
            } else {
                map.put(data, 1);
            }
        }
        fileInput.close();
        Object minValue = new Object();
        minValue = Collections.min(map.values());
        Integer minFreqSimbol = 0;
        String minFreqSimbolString = "";
        for (Map.Entry<Integer, Integer> pair : map.entrySet()) {
            if(pair.getValue().equals(minValue)){
                minFreqSimbol = pair.getKey();
                minFreqSimbolString += minFreqSimbol + " ";
            }

        }
        minFreqSimbolString = minFreqSimbolString.trim();
        System.out.print(minFreqSimbolString);
    }
}
