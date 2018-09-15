package com.javarush.task.task19.task1924;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/*
Замена чисел
*/

public class Solution {
    public static Map<Integer, String> map = new HashMap<Integer, String>();
    static {
        map.put(0,"ноль");
        map.put(1,"один");
        map.put(2,"два");
        map.put(3,"три");
        map.put(4,"четыре");
        map.put(5,"пять");
        map.put(6,"шесть");
        map.put(7,"семь");
        map.put(8,"восемь");
        map.put(9,"девять");
        map.put(10,"десять");
        map.put(11,"одиннадцать");
        map.put(12,"двенадцать");
    }
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        try {
            BufferedReader file = new BufferedReader(new FileReader(reader.readLine()));
            reader.close();
            String text;
            while (file.ready()) {
                text = file.readLine();
                for (Map.Entry m: map.entrySet()) {
                    Pattern pattern = Pattern.compile("\\s?\\b"+m.getKey().toString()+"\\b\\s?");
                    Matcher matcher = pattern.matcher(text);
                    while (matcher.find()) {
                        if(text.contains(matcher.group()))
                            text = text.replaceAll(matcher.group()," "+m.getValue().toString()+" ");
                    }
                }
                System.out.println(text);
            }
            file.close();
        }catch (FileNotFoundException e){
            System.out.println("Файл не найден!");
        }
    }
}
