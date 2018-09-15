package com.javarush.task.task12.task1217;

/* 
Интерфейсы Fly, Run, Swim
*/

public class Solution {
    public static void main(String[] args) {

    }

//add interfaces here - добавь интерфейсы тут
    public interface Fly{
        int getHieght();
    }
    public interface Run{
        int getSpeed();
    }
    public interface Swim{
        int getdepth();
    }
    class Robot implements Fly, Run, Swim{
     public int getHieght(){
            return 10000;
        }
    public  int getSpeed(){
          return 100;
        }

    public int getdepth(){
            return 500;
        }
    }

}
