package com.javarush.task.task12.task1226;

/*
Fly, Run, Climb для классов Cat, Dog, Tiger, Duck
*/

public class Solution {
    public interface Fly{
        void fly();
    }
    public interface Run{
        void run();
    }
    public interface  Climb{
        void climb();
    }

    public class Cat implements Run, Climb
    {
        public void run(){}
        public void climb(){}
    }
    public class Dog implements Run
    {
        public void run(){}

    }


    public class Tiger extends Cat {
    }

    public class Duck implements Fly,Run{
        public void fly(){}
        public void run(){}
    }
}
