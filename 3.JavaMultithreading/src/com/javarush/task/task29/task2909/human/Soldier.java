package com.javarush.task.task29.task2909.human;

/**
 * Created by USER on 21.02.2018.
 */
public class Soldier extends Human implements Alive{
    static boolean isSoldier;

    public Soldier(String name, int age) {
        super(name,age);
    }

    public void fight() {
    }
    @Override
    public void live() {
           //  if (isSoldier)
             this.fight();
    }
}
