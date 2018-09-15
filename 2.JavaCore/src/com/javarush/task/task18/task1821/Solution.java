package com.javarush.task.task18.task1821;

/* 
Встречаемость символов
*/

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;

public class Solution {
    public static void main(String[] args) throws IOException {
        FileInputStream file = new FileInputStream(args[0]);
        Map<Character, Integer> map = new TreeMap<Character, Integer>();
        char data;
        while(file.available() > 0){
            data = (char) file.read();
            if(!map.containsKey(data)) map.put(data,1);
            else {
                Integer val = map.get(data);
                val++;
                map.put(data,val);
            }
        }
        file.close();
       Iterator<Map.Entry<Character, Integer>> iterator = map.entrySet().iterator();
       while (iterator.hasNext()){
       Map.Entry<Character,Integer> pair = iterator.next();
           Integer value = pair.getValue();
           Character key = pair.getKey();
           System.out.println(key + " " + value);
       }
   }
}
