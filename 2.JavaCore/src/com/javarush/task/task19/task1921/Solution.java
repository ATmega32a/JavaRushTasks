package com.javarush.task.task19.task1921;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/*
Хуан Хуанович
*/

public class Solution {
    public static final List<Person> PEOPLE = new ArrayList<Person>();

    public static void main(String[] args) throws IOException, ParseException {
        FileReader file = new FileReader(args[0]);
        BufferedReader reader = new BufferedReader(file);
        String s;
        Pattern patternName = Pattern.compile("([а-яА-Яa-zA-Z-]*\\s?){1,}\\s",Pattern.UNICODE_CASE|Pattern.UNICODE_CHARACTER_CLASS);
        Pattern patternBirthday = Pattern.compile("\\d{1,2}\\s\\d{1,2}\\s\\d{4}");
        System.out.println();
        while (reader.ready()){
            s = reader.readLine();
            Matcher matcherName = patternName.matcher(s);
            Matcher matcherBirthday= patternBirthday.matcher(s);
            while (matcherName.find() & matcherBirthday.find()){
                String name = matcherName.group().trim();
                Date date = new SimpleDateFormat("dd MM yyyy").parse(matcherBirthday.group());
                Person person = new Person(name, date);
                PEOPLE.add(person);
            }
        }
        file.close();
        for (Person aPEOPLE : PEOPLE) {
            System.out.println(aPEOPLE.getName() + " " + aPEOPLE.getBirthday());
        }
    }
}
