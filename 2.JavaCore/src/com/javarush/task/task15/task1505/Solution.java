package com.javarush.task.task15.task1505;

import java.util.ArrayList;
import java.util.List;

/* 
ООП - исправь ошибки в наследовании
*/

public class Solution {
    public static interface Alive {
        Object containsBones();
    }

    public static class BodyPart implements Alive {
        private String name;

        public BodyPart(String name) {
            this.name = name;
        }

        public Object containsBones() {
        /*  String string;
            if (true) string = "Yes";
            else
                if (false) string = "No";
        */
            return true ?"Yes":"No";
        }

        public String toString() {
            return (containsBones()=="Yes") ? name + " содержит кости" : name + " не содержит кости";
        }
    }

    public static class Finger extends BodyPart {
        private boolean isArtificial;

        public Finger(String name, boolean isArtificial) {
            super(name);
            this.isArtificial = isArtificial;
        }

        public Object containsBones() {
            String boolBoun;

            String contBones = super.containsBones().toString();
            /*if((contBones=="Yes") && (isArtificial==true)) boolBoun="Yes";
                else
                    if((contBones=="No") && (isArtificial==false)) boolBoun="No";*/
            return ((contBones=="Yes") && (isArtificial==false))?"Yes":"No";
        }
    }

    public static void main(String[] args) {
        printlnFingers();
        printlnBodyParts();
        printlnAlives();
    }

    private static void printlnAlives() {
        System.out.println(new BodyPart("Рука").containsBones());
    }

    private static void printlnBodyParts() {
        List<BodyPart> bodyParts = new ArrayList<BodyPart>(5);
        bodyParts.add(new BodyPart("Рука"));
        bodyParts.add(new BodyPart("Нога"));
        bodyParts.add(new BodyPart("Голова"));
        bodyParts.add(new BodyPart("Тело"));
        System.out.println(bodyParts.toString());
    }

    private static void printlnFingers() {
        List<Finger> fingers = new ArrayList<Finger>(5);
        fingers.add(new Finger("Большой", false));
        fingers.add(new Finger("Указательный", false));
        fingers.add(new Finger("Средний", false));
        fingers.add(new Finger("Безымянный", false));
        fingers.add(new Finger("Мизинец", false));
        System.out.println(fingers.toString());
    }
}

