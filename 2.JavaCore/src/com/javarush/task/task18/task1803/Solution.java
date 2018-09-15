package com.javarush.task.task18.task1803;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;

/*
Самые частые байты
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader readFile = new BufferedReader(new InputStreamReader(System.in));
        FileInputStream fileInput = new FileInputStream(readFile.readLine());

        ArrayList<Integer> symbols = new ArrayList<>();
        ArrayList<Integer> count = new ArrayList<>();
        ArrayList<Integer> duplicatedSymbols = new ArrayList<>();
        ArrayList<Integer> fromSetSymbols = new ArrayList<>();
        HashSet<Integer> withoutDuplicateArray = new HashSet<>();
        int counter;

       int data = fileInput.read();
       symbols.add(data);
        while (fileInput.available() > 0) {
            data = fileInput.read();
            symbols.add(data);
         }
        withoutDuplicateArray.addAll(symbols);
        fromSetSymbols.addAll(withoutDuplicateArray);

        for(int i = 0; i < fromSetSymbols.size(); i++){
            counter = 0;
            for(int j = 0 ;j < symbols.size() ;j++){
                if (fromSetSymbols.get(i).equals(symbols.get(j))) {
                    duplicatedSymbols.add(i,symbols.get(j));
                    counter++;
                    count.add(i,counter);
                }
            }
        }
        int maxValueOfCounter = Collections.max(count);
        String frequentlyElements="";
        for (int i = 0; i < count.size(); i++) {
            if(count.get(i).equals(maxValueOfCounter)){
                frequentlyElements += duplicatedSymbols.get(i)+" ";
            }
        }
        frequentlyElements = frequentlyElements.trim();
        System.out.print(frequentlyElements);
        readFile.close();
        fileInput.close();
    }
}