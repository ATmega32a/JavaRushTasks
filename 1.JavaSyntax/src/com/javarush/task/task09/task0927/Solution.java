package com.javarush.task.task09.task0927;

import java.util.*;

/* 
Десять котов
*/

public class Solution {
    public static void main(String[] args) {
        Map<String, Cat> map = createMap();
        Set<Cat> set = convertMapToSet(map);
        printCatSet(set);
    }

    public static Map<String, Cat> createMap() {
        //напишите тут ваш код
        HashMap<String ,Cat> map = new HashMap<String,Cat>();
        map.put("Вася",new Cat("Вася"));
        map.put("Мурка",new Cat("Мурка"));
        map.put("Робин",new Cat("Робин"));
        map.put("Мурзик",new Cat("Мурзик"));
        map.put("Виктор",new Cat("Виктор"));
        map.put("Ипполит",new Cat("Ипполит"));
        map.put("Сидор",new Cat("Сидор"));
        map.put("Михаил",new Cat("Михаил"));
        map.put("Алекс",new Cat("Алекс"));
        map.put("Егор",new Cat("Егор"));
        return map;
    }

    public static Set<Cat> convertMapToSet(Map<String, Cat> map) {
        //напишите тут ваш код
        Set<Cat> set = new HashSet<Cat>();
        Iterator<Map.Entry<String,Cat>> iterator = map.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<String, Cat> pair = iterator.next();
            Cat cat = pair.getValue();
            set.add(cat);
        }
        return set;
    }

    public static void printCatSet(Set<Cat> set) {
        for (Cat cat : set) {
            System.out.println(cat);
        }
    }

    public static class Cat {
        private String name;

        public Cat(String name) {
            this.name = name;
        }

        public String toString() {
            return "Cat " + this.name;
        }
    }


}
