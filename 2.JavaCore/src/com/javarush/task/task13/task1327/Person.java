package com.javarush.task.task13.task1327;


public class Person implements RepkaItem {
    private String name;
    private String namePadezh;

    public Person(String name, String namePadezh) {
        this.name = name;
        this.namePadezh = namePadezh;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNamePadezh() {
        return namePadezh;
    }

    public void setNamePadezh(String namePadezh) {
        this.namePadezh = namePadezh;
    }

    public  void pull(Person person) {
        if (name == "Внучка")
        {
            person.setNamePadezh("Бабку");
        } else if (name =="Бабка")
        {
            person.setNamePadezh("Дедку");
        }else if (name =="Дедка")
        {
            person.setNamePadezh("Репку");
        }
        System.out.println(name + " за " + person.getNamePadezh());

    }
}
