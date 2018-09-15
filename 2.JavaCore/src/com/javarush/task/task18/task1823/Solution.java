package com.javarush.task.task18.task1823;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/*
Нити и байты
*/

public class Solution {
    public static Map<String, Integer> resultMap = new HashMap<String, Integer>();

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName;
        while(true){
            fileName = reader.readLine();
            if (fileName.equals("exit")) break;
            else new ReadThread(fileName).start();
        }
        reader.close();
    }

    public static class ReadThread extends Thread {
        String fileName;
        public ReadThread(String fileName) throws IOException {
            this.fileName = fileName;
            //implement constructor body

        }
        // implement file reading here - реализуйте чтение из файла тут
        @Override
        public void run(){
            try{
               // System.out.println("Thread is run!");
                FileInputStream file = new FileInputStream(fileName);
                Map<Integer, Integer> map = new TreeMap<Integer, Integer>();
                int data;
                while (file.available() > 0) {
                    data =  file.read();
                    if (!map.containsKey(data)) map.put(data, 1);
                    else {
                        Integer val = map.get(data);
                        val++;
                        map.put(data, val);
                    }

                }
                Integer maxVal = Collections.max(map.values());
                Iterator<Map.Entry<Integer, Integer>> iterator = map.entrySet().iterator();
                while (iterator.hasNext()){
                    Map.Entry<Integer,Integer> pair = iterator.next();
                    Integer key = pair.getKey();
                    Integer value = pair.getValue();
                    if(value.equals(maxVal)) resultMap.put(fileName,key);
                }
               // System.out.println(resultMap);
                file.close();
              // resultMap.clear();
            } catch (IOException e){}

        }

    }
}
