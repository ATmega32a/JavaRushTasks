package com.javarush.task.task15.task1525;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/* 
Файл в статическом блоке
*/

public class Solution {
    public static List<String> lines = new ArrayList<String>();

    public static void main(String[] args) {
        System.out.println(lines);
    }
    static {
       try{
           Scanner file = new Scanner(new FileInputStream(Statics.FILE_NAME));
           while (file.hasNext()) {
              lines.add(file.nextLine());
           }

       }catch (FileNotFoundException e){
           e.getStackTrace();
       }
    }
}
