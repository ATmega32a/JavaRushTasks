package com.javarush.task.task10.task1013;

/* 
Конструкторы класса Human
*/

public class Solution {
    public static void main(String[] args) {
    }

    public static class Human {
        // напишите тут ваши переменные и конструкторы
        private String name;
        private int age;
        private Boolean sex;
        private String adress;
        private String profession;
        private int lengthWork;
       public Human(String name,int age,Boolean sex, String adress,String profession, int lengthWork) //1
        {
            this.name = name;
            this.age = age;
            this.sex = sex;
            this.adress = adress;
            this.profession = profession;
            this.lengthWork = lengthWork;
        }
        public Human(String name,int age,Boolean sex, String adress,String profession) //2
        {
            this.name=name;
            this.age=age;
            this.sex=sex;
            this.adress=adress;
            this.profession=profession;
            this.lengthWork=0;
        }

        public  Human(String name,int age,Boolean sex, String adress) //3
        {
            this.name=name;
            this.age=age;
            this.sex=sex;
            this.adress=adress;
            this.profession=null;
            this.lengthWork=0;
        }
        public Human(String name,int age,Boolean sex) //4
        {
            this.name=name;
            this.age=age;
            this.sex=sex;
            this.adress=null;
            this.profession=null;
            this.lengthWork=0;
        }
        public  Human(String profession,String name,int age,Boolean sex) //5
        {
            this.name=name;
            this.age=age;
            this.sex=sex;
            this.adress=null;
            this.profession=profession;
            this.lengthWork=0;

        }
        public Human(String profession,String name,Boolean sex) //6
        {
            this.name=name;
            this.age=0;
            this.sex=sex;
            this.profession=profession;
            this.adress=null;
            this.lengthWork=0;

        }
        public Human(String profession,String name) //7
        {
            this.name=name;
            this.age=0;
            this.profession=profession;

            this.adress=null;
            this.lengthWork=0;
        }
        public  Human(String profession,Boolean sex,String adress) //8
        {
            this.name=null;
            this.age=0;
            this.sex=sex;
            this.profession=profession;
            this.adress=adress;
            this.lengthWork=0;
        }
        public Human(String name,Boolean sex) //9
        {
            this.name=name;
            this.sex=sex;
            this.age=0;
            this.profession=null;
            this.adress=null;
            this.lengthWork=0;
        }
        public Human(String name) //10
        {
            this.name=name;
            this.age=0;
            this.profession=null;
            this.adress=null;
            this.lengthWork=0;

        }

        }


}
