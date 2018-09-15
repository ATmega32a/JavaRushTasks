package com.javarush.task.task18.task1808;

/* 
Разделение файла
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName1 = reader.readLine();
        String fileName2 = reader.readLine();
        String fileName3 = reader.readLine();
        FileInputStream file1 = new FileInputStream(fileName1);
        FileOutputStream file2 = new FileOutputStream(fileName2);
        FileOutputStream file3 = new FileOutputStream(fileName3);
        int[] data = new int[file1.available()];

        int index;
        if(file1.available()%2!=0) {
              index = file1.available()/2+1;
        }else index = file1.available()/2;

        int i = 0;
        while(file1.available() > 0){
            data[i] = file1.read();
            i++;
        }
        for (int j = 0; j < index; j++) {
            file2.write(data[j]);
        }
       for (int k = index; k < data.length; k++) {
            file3.write(data[k]);
        }
        file1.close();
        file2.close();
        file3.close();
   }
}

