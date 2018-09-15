package com.javarush.task.task14.task1420;

/* 
НОД
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

            int a = Integer.parseInt(reader.readLine());
            if(a <= 0 )throw new NumberFormatException();

            int b = Integer.parseInt(reader.readLine());
            if(b <= 0) throw new NumberFormatException();

            int c = nod(a, b);
            System.out.println(c);
}
private static int nod(int a, int b){
        int nod = 0;
        int index;
        if (a < b) index = a;
             else index = b;
                for (int i = 1; i <= index; i++) {
                    if(a % i == 0 && b % i == 0){
                        nod = i;
                    }
                }
        return nod;
    }
}


