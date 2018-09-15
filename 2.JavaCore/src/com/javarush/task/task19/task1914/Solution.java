package com.javarush.task.task19.task1914;

/* 
Решаем пример
*/

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class Solution {
    public static TestString testString = new TestString();

    public static void main(String[] args) {
        PrintStream streamConsole = System.out;
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream stream = new PrintStream(outputStream);
        System.setOut(stream);
        testString.printSomething();
        String res = outputStream.toString();
        String a = res.split(" ")[0];
        String sign = res.split(" ")[1];
        String b = res.split(" ")[2];
        int value = 0;
                     switch (sign){
                       case "+": {
                           value = Integer.parseInt(a) + Integer.parseInt(b);
                       } break;
                       case "-": {
                           value = Integer.parseInt(a) - Integer.parseInt(b);
                       } break;
                       case "*": {
                           value = Integer.parseInt(a) * Integer.parseInt(b);
                       } break;
                   }
        System.setOut(streamConsole);
        System.out.print(res+String.valueOf(value));
    }

    public static class TestString {
        public void printSomething() {
            System.out.println("3 + 6 = ");
        }
    }
}

