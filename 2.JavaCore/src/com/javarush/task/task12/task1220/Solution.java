package com.javarush.task.task12.task1220;

/* 
Класс Human и интерфейсы Run, Swim
*/

public class Solution {
    public static void main(String[] args) {

    }
    public abstract class Human implements Run,Swim{

    }
    public interface Run{
        int getSpeed();
    }
    public interface Swim{
        int getDepth();
    }
    //add public interfaces and public class here - добавь public интерфейсы и public класс тут
}
