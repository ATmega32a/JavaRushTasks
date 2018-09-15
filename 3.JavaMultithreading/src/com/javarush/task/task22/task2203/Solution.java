package com.javarush.task.task22.task2203;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/*
Между табуляциями
*/
public class Solution {
    public static String getPartOfString(String string) throws TooShortStringException {
        if (string == null || string.isEmpty()) throw new TooShortStringException();
        String str;
        String[] qSpace = string.split("\\t");
        Pattern pattern = Pattern.compile("\\t");
        Matcher matcher = pattern.matcher(string);
        Pattern patternEnd = Pattern.compile("$");
        Matcher matcherEnd = patternEnd.matcher(string);
        ArrayList<Integer> indexes = new ArrayList<>();
        int spaceCount = 0;
        int indStart = 0;
        int indEnd = 0;
        if (matcherEnd.find()) indEnd = matcherEnd.start();
        while (matcher.find()) {
            spaceCount++;
            indexes.add(matcher.start());
            if (spaceCount == 1) indStart = indexes.get(spaceCount - 1);
            if (spaceCount == 2) indEnd = indexes.get(spaceCount - 1);
        }
        if (qSpace.length  >= 3)  str = string.substring(indStart + 1, indEnd);
        else throw new TooShortStringException();
        return str;
    }

    public static class TooShortStringException extends Exception {
    }

    public static void main(String[] args) throws TooShortStringException {
        System.out.println(getPartOfString("\tJavaRush - лучший сервис \tобучения Java\t."));
    }
}
