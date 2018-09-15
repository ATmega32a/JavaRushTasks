package com.javarush.task.task10.task1019;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

/*
Функциональности маловато!
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        HashMap<String,Integer> map=new HashMap<String,Integer>();
       try {
           while(true){
               int value = Integer.parseInt(reader.readLine());
               String key = reader.readLine();
               map.put(key,value);
           }
       }catch (NumberFormatException  e)
       {
           for (Map.Entry<String,Integer> m: map.entrySet()) {
               System.out.println(m.getValue()+" "+m.getKey());
           }
       }
    }
}
