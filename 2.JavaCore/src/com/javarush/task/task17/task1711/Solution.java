package com.javarush.task.task17.task1711;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/*
CRUD
*/

public class Solution {
    public static volatile List<Person> allPeople = new ArrayList<Person>();

    static {
        allPeople.add(Person.createMale("Иванов Иван", new Date()));  //сегодня родился    id=0
        allPeople.add(Person.createMale("Петров Петр", new Date()));  //сегодня родился    id=1
    }
    public static void main(String[] args) {
        //start here - начни тут
        String sex = null;

            if (args.length > 0) {
                try {
                    switch (args[0]) {
                        case "-c": {
                            for (int i = 1; i < args.length; i += 3) {
                                int day = 0;
                                int mounth = 0;
                                int year = 0;

                                day = Integer.parseInt(args[i + 2].split("/")[0]);
                                mounth = Integer.parseInt(args[i + 2].split("/")[1]);
                                year = Integer.parseInt(args[i + 2].split("/")[2]);
                                synchronized (allPeople){

                                    if (args[i + 1].equals("м")) {
                                        allPeople.add(Person.createMale(null, null));
                                        allPeople.get(allPeople.size() - 1).setName(args[i]);
                                        Date dateBirth = new Date(year - 1900, mounth - 1, day);
                                        allPeople.get(allPeople.size() - 1).setBirthDay(dateBirth);
                                        int index = allPeople.size() - 1;
                                        System.out.println(index);
                                        allPeople.get(allPeople.size() - 1).setSex(Sex.MALE);

                                    } else if (args[i + 1].equals("ж")) {
                                        allPeople.add(Person.createFemale(null, null));
                                        allPeople.get(allPeople.size() - 1).setName(args[i]);
                                        Date dateBirth = new Date(year - 1900, mounth - 1, day);
                                        allPeople.get(allPeople.size() - 1).setBirthDay(dateBirth);
                                        int index = allPeople.size() - 1;
                                        System.out.println(index);
                                        allPeople.get(allPeople.size() - 1).setSex(Sex.FEMALE);
                                    }
                                }
                            }
                        }

                        break;

                        case "-i": {

                            for (int i = 1; i < args.length; i++) {
                                int index = Integer.parseInt(args[i]);
                                SimpleDateFormat dateFormat = new SimpleDateFormat("dd'-'MMM'-'YYYY", Locale.ENGLISH);
                                synchronized (allPeople){
                                    if (allPeople.get(index).getSex() == Sex.MALE) {
                                        sex = "м";
                                    } else if (allPeople.get(index).getSex() == Sex.FEMALE) {
                                        sex = "ж";
                                    } else if (allPeople.get(index).getSex() == null) {
                                        sex = null;
                                    }

                                    System.out.println(String.format(allPeople.get(index).getName() + " "
                                            + sex + " " + dateFormat.format(allPeople.get(index).getBirthDay())));
                                }
                            }

                        }
                        break;

                        case "-d": {
                            for (int i = 1; i < args.length; i++) {
                                int delIndex = Integer.parseInt(args[i]);
                               synchronized (allPeople){
                                   allPeople.get(delIndex).setName(null);
                                   allPeople.get(delIndex).setSex(null);
                                   allPeople.get(delIndex).setBirthDay(null);
                                   allPeople.set(delIndex, allPeople.get(delIndex));
                               }
                            }
                        }
                        break;

                        case "-u": {
                            for (int i = 1; i < args.length; i += 4) {
                                int updIndex = Integer.parseInt(args[i]);
                                int updDay = Integer.parseInt(args[i + 3].split("/")[0]);
                                int updMounth = Integer.parseInt(args[i + 3].split("/")[1]);
                                int updYear = Integer.parseInt(args[i + 3].split("/")[2]);
                                synchronized (allPeople) {
                                    if (args[i + 2].equals("м")) {

                                        allPeople.set(updIndex, Person.createMale(args[i + 1], new Date(updYear - 1900, updMounth - 1, updDay)));

                                    } else if (args[i + 2].equals("ж")) {
                                        allPeople.set(updIndex, Person.createFemale(args[i + 1], new Date(updYear - 1900, updMounth - 1, updDay)));

                                    }
                                }
                            }
                        }
                    }


                } catch (ArrayIndexOutOfBoundsException e) {
                    System.out.println("Программа запущена без аргументов args метода main()");
                }
            }
    }
}

