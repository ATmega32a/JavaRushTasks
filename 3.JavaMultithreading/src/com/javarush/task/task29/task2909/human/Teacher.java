package com.javarush.task.task29.task2909.human;


public class Teacher extends UniversityPerson implements Alive{

    private int numberOfStudents;

    public Teacher(String name, int age, int numberOfStudents) {
        super(name, age);
        this.name = name;
        this.age = age;
        this.numberOfStudents = numberOfStudents;
    }


    @Override
  public String getPosition() {
        return "Преподаватель";
    }

    @Override
    public void live() {
        teach();
    }

    public void teach() {
    }



}