package com.javarush.task.task22.task2209;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/*
Составить цепочку слов
*/
public class Solution {
    public static void main(String[] args) throws IOException {
        //...
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader file = new BufferedReader(new FileReader(bufferedReader.readLine()));
        ArrayList<String[]> list = new ArrayList<>();
        char ch;
        while (file.ready()){
            list.add(file.readLine().split(" "));
        }
       // /*
        for (String[] l:list) {
            for (int i = 0; i < l.length; i++) {
                System.out.println(l[i]);
            }
        }
      //  */
        /*
        System.out.println("----------------------------------------------");
        for (String[] l:list) {F:\forTests\for2209\test2209_0.txt
﻿
            ch = l[0].charAt(l[0].length()-1);
            for (int i = 0; i < l.length ; i++) {
                System.out.print(l[i] + " ");
                for (int j = 0; j < l.length ; j++) {
                  if(l[j].startsWith(String.valueOf(ch))){
                      System.out.print(l[j] + " " );
                      ch = l[j].charAt(l[j].length()-1);
                  } else  ch = l[i].charAt(l[i].length()-1);
                }

            }
        }
        System.out.println();
        System.out.println("----------------------------------------------");
        */
        for (int i = 0; i < list.size(); i++) {
            StringBuilder result = getLine(list.get(i));
            System.out.println(result.toString());
        }

    }

    public static StringBuilder getLine(String... words) {
        StringBuilder sb = new StringBuilder();
        ArrayList<String> arrayList = new ArrayList<>();
         for (int i = 0; i < words.length; i++) {
            sb.append(words[i]).append(" ");
            for (int j = 0; j < words.length; j++) {
                if(i == j) continue;

                if(sb.charAt(sb.length() - 2) == words[j].charAt(0)){
                    sb.append(words[j]).append(" ");
                }
            }
         //   System.out.println(sb.toString());
            arrayList.add(sb.toString());
            sb.delete(0,sb.length());
        }

        int maxOfLength = arrayList.get(0).length();
        int indexOfMaxElem = 0;
        for (int i = 0; i < arrayList.size(); i++) {
            if(maxOfLength < arrayList.get(i).length()){
                maxOfLength = arrayList.get(i).length();
                indexOfMaxElem = i;
            }
        }

         sb.delete(0,sb.length());
         sb.append(arrayList.get(indexOfMaxElem).trim());
         return sb;
    }
}
//F:\forTests\for2209\test2209.txt