package com.javarush.task.task17.task1710;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/*
CRUD
*/

public class Solution {
    public static List<Person> allPeople = new ArrayList<Person>();

    static {
        allPeople.add(Person.createMale("Иванов Иван", new Date()));  //сегодня родился    id=0
        allPeople.add(Person.createMale("Петров Петр", new Date()));  //сегодня родился    id=1
    }
    public static void main(String[] args) {
        //start here - начни тут
        Pattern p = Pattern.compile("-c\\s\\w+\\s?\\w+\\s?\\w+\\s(м|ж)\\s\\d{2}/\\d{2}/\\d{4}$",Pattern.UNICODE_CHARACTER_CLASS);
        Pattern p1 = Pattern.compile("-u\\s\\d+\\s\\w+\\s?\\w+\\s?\\w+\\s(м|ж)\\s\\d{2}/\\d{2}/\\d{4}$",Pattern.UNICODE_CHARACTER_CLASS);
        Pattern p2 = Pattern.compile("-d\\s\\d+$",Pattern.UNICODE_CHARACTER_CLASS);
        Pattern p3 = Pattern.compile("-i\\s\\d+",Pattern.UNICODE_CHARACTER_CLASS);
        ArrayList<String> arguments = new ArrayList<>();
        String command;
        String sex = null;
        int counter=0;
        try{

            arguments.add(args[0] + " ");
            int j =1;

            if (args.length > 0){
                for (int i = 0; i <= counter; i++) {
                    arguments.add("");
                    while (true){
                        j++;
                        if (j < args.length) {
                            arguments.set(i,arguments.get(i)+args[j-1] + " ");

                            if(!(args[j].equals("-c") || args[j].equals("-i") || args[j].equals("-d") || args[j].equals("-u"))){
                            } else {
                                counter++;
                                break;
                            }
                        } else
                        {
                            break;
                        }
                    }
                }
                arguments.set(counter,arguments.get(counter)+args[args.length-1] + " ");
                arguments.remove(arguments.size()-1);
                for (int i = 0; i <= counter; i++) {
                    arguments.set(i, arguments.get(i).trim());
                }
            }
            for (int indexOfList = 0; indexOfList<= counter;indexOfList++) {
                command = arguments.get(indexOfList);
                String parameter = command.split(" ")[0];
                switch (parameter){
                    case "-c" : {
                        Matcher m = p.matcher(command);
                        String dateFromCommand = null;
                        int day=0;
                        int mounth=0;
                        int year=0;
                        for (String s: command.split(" "))
                        {
                            dateFromCommand = s;
                        }

                        day = Integer.parseInt(dateFromCommand.split("/")[0]);
                        mounth = Integer.parseInt(dateFromCommand.split("/")[1]);
                        year = Integer.parseInt(dateFromCommand.split("/")[2]);

                        if (command.contains(" м ")) {
                            while (m.find()) {

                                allPeople.add(Person.createMale(null, null));
                                allPeople.get(allPeople.size()-1).setName(command.substring(m.start()+3,m.end()-13));
                                Date dateBirth= new Date(year-1900,mounth-1,day);
                                allPeople.get(allPeople.size()-1).setBirthDay(dateBirth);
                                int index = allPeople.size()-1;
                                System.out.println(index);
                                allPeople.get(allPeople.size()-1).setSex(Sex.MALE);
                            }
                        } else
                        if (command.contains(" ж ")) {
                            while (m.find()) {
                                allPeople.add(Person.createFemale(null, null));
                                allPeople.get(allPeople.size()-1).setName(command.substring(m.start()+3,m.end()-13));
                                Date dateBirth = new Date(year-1900,mounth-1,day);
                                allPeople.get(allPeople.size()-1).setBirthDay(dateBirth);
                                int index = allPeople.size()-1;
                                System.out.println(index);
                                allPeople.get(allPeople.size()-1).setSex(Sex.FEMALE);
                            }
                        }
                    }

                    break;

                    case "-i" : {
                        Matcher m3 = p3.matcher(command);
                        while (m3.find()) {
                            int index = Integer.parseInt(command.substring(3));
                            SimpleDateFormat dateFormat = new SimpleDateFormat("dd'-'MMM'-'YYYY",Locale.ENGLISH);
                            if (allPeople.get(index).getSex() == Sex.MALE) {
                                sex = "м";
                            }
                            else if (allPeople.get(index).getSex() == Sex.FEMALE){
                                sex = "ж";
                            } else
                            if (allPeople.get(index).getSex() == null){
                                sex = null;
                            }

                            System.out.println(String.format(allPeople.get(index).getName() + " "
                                    + sex + " " + dateFormat.format(allPeople.get(index).getBirthDay())));
                        }
                    }
                    break;

                    case "-d" : {
                        Matcher m2 = p2.matcher(command);
                        while (m2.find()){
                            int delIndex = Integer.parseInt(command.substring(m2.start()+3,m2.end()));
                            allPeople.get(delIndex).setName(null);
                            allPeople.get(delIndex).setSex(null);
                            allPeople.get(delIndex).setBirthDay(null);
                         //   allPeople.set(delIndex,allPeople.get(delIndex));
                        }
                    }
                    break;

                    case "-u" : {
                        Matcher m1 = p1.matcher(command);

                        int  updIndex = Integer.parseInt(command.split(" ")[1]);
                        String updDate = null;

                        for (String s: command.split(" "))
                        {
                            updDate = s;
                        }

                        int updDay = Integer.parseInt(updDate.split("/")[0]);
                        int updMounth = Integer.parseInt(updDate.split("/")[1]);
                        int updYear = Integer.parseInt(updDate.split("/")[2]);

                        if (command.contains(" м ")) {
                            while (m1.find()) {
                                allPeople.set(updIndex, Person.createMale(command.substring(m1.start() + 5, m1.end() - 13), new Date(updYear - 1900, updMounth - 1, updDay)));
                            }
                        } else if (command.contains(" ж ")){
                            while (m1.find()) {
                                allPeople.set(updIndex, Person.createFemale(command.substring(m1.start() + 5, m1.end() - 13), new Date(updYear - 1900, updMounth - 1, updDay)));
                            }
                        }
                    }
                }
            }
        }catch (ArrayIndexOutOfBoundsException e){
            System.out.println("Программа запущена без аргументов args метода main()");
        }catch (NullPointerException e){

        }
    }
}

