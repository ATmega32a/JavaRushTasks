package com.javarush.task.task22.task2211;

import java.io.*;
import java.nio.charset.Charset;

/* 
Смена кодировки
*/
public class Solution {
    public static void main(String[] args) throws IOException {
        InputStreamReader inputStreamReader = new InputStreamReader(new FileInputStream("F:\\JavaRushTasks\\3.JavaMultithreading\\src\\com\\javarush\\task\\task22\\task2211\\example.txt"));
     //   OutputStreamWriter outputStreamWriter = new OutputStreamWriter(new FileOutputStream(args[1]));
        InputStream inputStream = null;
        OutputStream outputStream = null;
        Charset unicode = Charset.forName("UTF-8");
        Charset win1251 = Charset.forName("Windows-1251");
        String s = "";
        char ch = 0;
        while(inputStreamReader.ready()){
            ch+=inputStreamReader.read();
            s +=String.valueOf(ch);
        }
        Charset koi8 = Charset.forName("KOI8-R");
        Charset windows1251 = Charset.forName("Windows-1251");

        byte[] buffer = new byte[1000];
        inputStream.read(buffer);
        s = new String(buffer, koi8);
        buffer = s.getBytes(windows1251);
        outputStream.write(buffer);
           for (int i = 0; i < buffer.length; i++) {
               System.out.print((char) buffer[i]);
           }
//        inputStream.close();
        inputStreamReader.close();
    //    outputStreamWriter.close();
    }
}