package com.javarush.task.task21.task2103;

/* 
Все гениальное - просто!
*/
public class Solution {
    public static boolean calculate(boolean a, boolean b, boolean c, boolean d) {
        return  c && (!a || !b || d ||a && b && !d );
    }

    public static void main(String[] args) {
        
    }
}