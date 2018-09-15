package com.javarush.task.task09.task0930;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* 
Задача по алгоритмам
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<String> list = new ArrayList<String>();

        while (true) {
            String s = reader.readLine();
            if (s.isEmpty()) break;
            list.add(s);
        }

        String[] array = list.toArray(new String[list.size()]);
        sort(array);

        for (String x : array) {
            System.out.println(x);
        }
    }

    public static void sort(String[] array) {
        //напишите тут ваш код

        String[] strArr = new String[array.length];
        String[] intArr = new String[array.length];
        int j = 0;
        int k = 0;
        for (int i = 0; i < array.length; i++) {
            if (isNumber(array[i])) {
                intArr[i] = array[i];
                j++;
            } else {
                strArr[i] = array[i];
                k++;
            }

        }
        int[] indxInt = new int[array.length - k];
        int indexInt = 0;
        for (int i = 0; i < intArr.length; i++) {
            if (intArr[i] != null) {
                indxInt[indexInt] = i;
                indexInt++;
            }
        }
        int[] indxStr = new int[array.length - j];
        int indexStr = 0;
        for (int i = 0; i < intArr.length; i++) {
            if (strArr[i] != null) {
                indxStr[indexStr] = i;
                indexStr++;
            }
        }
        String bufferInt;
        for (int i = 1; i < indxInt.length; i++) {
           for (int indexWhile = 0; indexWhile < indxInt.length-i; indexWhile++)
                {
                    if (Integer.parseInt(array[indxInt[indexWhile]]) < Integer.parseInt(array[indxInt[indexWhile + 1]]))
                    {
                        bufferInt = array[indxInt[indexWhile]];
                        array[indxInt[indexWhile]] = array[indxInt[indexWhile + 1]];
                        array[indxInt[indexWhile + 1]] = bufferInt;
                    }
                }
            }
        String bufferStr;
        for (int i = 1; i < indxStr.length; i++) {
            for (int indexWhile = 0; indexWhile < indxStr.length-i; indexWhile++)
            {
                if (isGreaterThan(array[indxStr[indexWhile]],array[indxStr[indexWhile+1]]))
                {
                    bufferStr = array[indxStr[indexWhile]];
                    array[indxStr[indexWhile]] = array[indxStr[indexWhile + 1]];
                    array[indxStr[indexWhile + 1]] = bufferStr;
                }

            }
        }
    }
    // Метод для сравнения строк: 'а' больше чем 'b'
    public static boolean isGreaterThan(String a, String b) {
        return a.compareTo(b) > 0;
    }

    // Переданная строка - это число?
    public static boolean isNumber(String s) {
        if (s.length() == 0) return false;

        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            char c = chars[i];
            if ((i != 0 && c == '-') // есть '-' внутри строки
                    || (!Character.isDigit(c) && c != '-')) // не цифра и не начинается с '-'
            {
                return false;
            }
        }
        return true;
    }
}
