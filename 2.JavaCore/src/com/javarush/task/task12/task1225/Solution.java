package com.javarush.task.task12.task1225;

/* 
Что это? «Кот», «Тигр», «Лев», «Бык», «Корова», «Животное»
*/

public class Solution {
    public static void main(String[] args) {
        System.out.println(getObjectType(new Cat()));
        System.out.println(getObjectType(new Tiger()));
        System.out.println(getObjectType(new Lion()));
        System.out.println(getObjectType(new Bull()));
        System.out.println(getObjectType(new Cow()));
        System.out.println(getObjectType(new Animal()));
    }

    public static String getObjectType(Object o) {
        //напишите тут ваш код
        String animal;
        switch (o.getClass().getSimpleName()){
            case "Cat": animal = "Кот";
                break;
            case "Tiger": animal = "Тигр";
                break;
            case "Lion": animal = "Лев";
                break;
            case "Bull": animal = "Бык";
                break;
            case "Cow": animal = "Корова";
                break;
            default:animal="Животное";
        }

        return animal;

    }

    public static class Cat extends Animal   //<--Классы наследуются!!
    {
    }

    public static class Tiger extends Cat {
    }

    public static class Lion extends Cat {
    }

    public static class Bull extends Animal {
    }

    public static class Cow extends Animal {
    }

    public static class Animal {
    }
}
