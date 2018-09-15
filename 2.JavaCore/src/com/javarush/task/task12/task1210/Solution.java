package com.javarush.task.task12.task1210;

/* 
Три метода возвращают максимальное из двух переданных в него чисел
*/

public class Solution {
    public static void main(String[] args) {

    }

    //Напишите тут ваши методы
    public static int max(int a, int b) {
        int max;
        if (a < b) max = b;
        else max = a;
        return max;
    }

    public static long max(long a, long b) {
        long max;
        if (a < b) max = b;
        else max = a;
        return max;
    }

    public static double max(double a, double b) {
        double max;
        if (a < b) max = b;
        else max = a;
        return max;
    }
}
