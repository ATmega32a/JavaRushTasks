package com.javarush.task.task09.task0906;

/* 
Логирование стек трейса
*/


public class Solution {
    public static void main(String[] args) {
        log("In main method");
    }

    public static void log(String s) {
        //напишите тут ваш код
        Throwable t = new Throwable();
        StackTraceElement[] stack = t.getStackTrace();
        s = stack[1].getClassName() +": "+stack[1].getMethodName()+": "+s;
        System.out.println(s);
    }
}
