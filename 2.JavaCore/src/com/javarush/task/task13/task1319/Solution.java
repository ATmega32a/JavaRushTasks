package com.javarush.task.task13.task1319;


import java.io.*;
import java.util.ArrayList;

/* 
Запись в файл с консоли
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        // напишите тут ваш код
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = reader.readLine();
        FileOutputStream fileOutputStream = new FileOutputStream(fileName);
        BufferedWriter writeStringsInFile = new BufferedWriter(new OutputStreamWriter(fileOutputStream , "UTF-8"));
        ArrayList<String> list = new ArrayList<String>();
        //list.add(fileName+"\r\n");
        String text;
        while (true) {
            text = reader.readLine();
            if (text.equals("exit"))
            {
                list.add(text);
                break;
            }
            else
                list.add(text+"\n");
        }
        for (int i = 0; i < list.size(); i++) {
            for (int j = 0; j < list.get(i).length(); j++) {
                writeStringsInFile.write(list.get(i).charAt(j));
            }

        }
        reader.close();
        writeStringsInFile.close();
    }
}
