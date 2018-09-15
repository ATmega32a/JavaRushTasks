package com.javarush.task.task13.task1326;

/* 
Сортировка четных чисел из файла
*/

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) throws IOException {
        // напишите тут ваш код
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = reader.readLine();
        Scanner file = new Scanner(new FileInputStream(fileName));
        ArrayList<String> arrList = new ArrayList<>();

        while (file.hasNext()) {
            String fromFile = file.next();
            if (!(fromFile == "10"))
                arrList.add(fromFile);
        }
        file.close();
        reader.close();
        int indexOf = 0;
        for (int i = 0; i < arrList.size(); i++) {
            if (Integer.parseInt(arrList.get(i)) % 2 == 0) {
                arrList.set(indexOf, arrList.get(i));
                indexOf++;
            }
        }
        Integer buff;
        for (int j = 0; j < indexOf; j++) {
            for (int k = 1; k < indexOf - j; k++) {
                if (Integer.parseInt(arrList.get(k - 1)) > Integer.parseInt(arrList.get(k))) {
                    buff = Integer.parseInt(arrList.get(k - 1));
                    arrList.set(k - 1, arrList.get(k));
                    arrList.set(k, buff.toString());
                }
            }
        }
        for (int k = 0; k < indexOf; k++) {
            System.out.println(arrList.get(k));
        }
    }
}
