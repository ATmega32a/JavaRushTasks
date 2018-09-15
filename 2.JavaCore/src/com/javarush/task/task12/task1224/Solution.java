package com.javarush.task.task12.task1224;

/* 
Что это? «Кот», «Тигр», «Лев», «Бык», «хз»
*/

public class Solution {
    public static void main(String[] args) {
        System.out.println(getObjectType(new Cat()));
        System.out.println(getObjectType(new Tiger()));
        System.out.println(getObjectType(new Lion()));
        System.out.println(getObjectType(new Bull()));
        System.out.println(getObjectType(new Pig()));
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
            default:animal="хз";
        }

        return animal;
    }

    public static class Cat {
    }

    public static class Tiger {
    }

    public static class Lion {
    }

    public static class Bull {
    }

    public static class Pig {
    }
}