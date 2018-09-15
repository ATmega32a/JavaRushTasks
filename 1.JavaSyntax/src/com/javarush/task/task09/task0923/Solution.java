package com.javarush.task.task09.task0923;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/*
Гласные и согласные
*/


public class Solution {

  //  static int index2=0;
    public static char[] vowels = new char[]{'а', 'я', 'у', 'ю', 'и', 'ы', 'э', 'е', 'о', 'ё'};

    public static void main(String[] args) throws Exception {

        int index0=0;
        int index1=0;

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String str;
        str = reader.readLine();
        char[] vowel = new char[str.length()];
        char[] consonant = new char[str.length()];
            for (int j = 0, k = 0, l = 0; j < str.length(); j++) {
                    if (isVowel(str.charAt(j))) {
                        vowel[k] = str.charAt(j);
                        k++;
                    } else {
                        consonant[l] = str.charAt(j);
                        l++;
                    }
                index0=str.length()-l;
                index1=str.length()-k;
            }
            for (int j = 0; j < index0; j++) {
                System.out.print(vowel[j]+" ");
            }
            System.out.println();
            for (int j = 0; j < index1; j++) {

               if (consonant[j]==' ') System.out.print("");
                else
                System.out.print(consonant[j]+" ");
            }
       }
    // метод проверяет, гласная ли буква
    public static boolean isVowel(char c) {
        c = Character.toLowerCase(c);  // приводим символ в нижний регистр - от заглавных к строчным буквам
        for (char d : vowels)   // ищем среди массива гласных
        {
            if (c == d)
                return true;
        }
        return false;
    }
}