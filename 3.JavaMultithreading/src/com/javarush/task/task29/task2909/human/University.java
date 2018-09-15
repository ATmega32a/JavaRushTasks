package com.javarush.task.task29.task2909.human;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class University {
    private List<Student> students;
    private String name;
    private int age;


    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    public University(String name, int age) {
        this.name = name;
        this.age = age;
        students = new ArrayList<>();
    }

    public Student getStudentWithAverageGrade(double avarageGrade) {
        //TODO:
        Student student = null;
        for (Student st: students) {
           if (st.getAverageGrade()==avarageGrade)
              student = st;
        }
       //   return new Student(name,age,avarageGrade);
        return student;
    }

    public Student getStudentWithMaxAverageGrade() {
        //TODO:
        Student student = null;
        double MaxAvarageGrade;
        List<Double> listOfMaxAvGr = new ArrayList<>();
        for (Student st: students) {
            listOfMaxAvGr.add(st.getAverageGrade());
        }
        Collections.sort(listOfMaxAvGr);
        MaxAvarageGrade = listOfMaxAvGr.get(listOfMaxAvGr.size()-1);
        for (Student st: students) {
            if(st.getAverageGrade()==MaxAvarageGrade) student = st;
        }

        return student;
    }
    public Student getStudentWithMinAverageGrade(){
        Student student = null;
        double MinAvarageGrade;
        List<Double> listOfMaxAvGr = new ArrayList<>();
        for (Student st: students) {
            listOfMaxAvGr.add(st.getAverageGrade());
        }
        Collections.sort(listOfMaxAvGr);
        MinAvarageGrade = listOfMaxAvGr.get(0);
        for (Student st: students) {
            if(st.getAverageGrade()==MinAvarageGrade) student = st;
        }

        return student;
    }

    public void expel(Student student) {
        students.remove(student);
    }
}