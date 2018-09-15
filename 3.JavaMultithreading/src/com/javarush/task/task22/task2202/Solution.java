package com.javarush.task.task22.task2202;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/*
Найти подстроку
*/
public class Solution {
    public static void main(String[] args) {
        System.out.println(getPartOfString("JavaRush - лучший сервис обучения Java."));
    }

    public static String getPartOfString(String string) {
        if (string == null || string.isEmpty()) throw new TooShortStringException();
        String str;
        String[] qSpace = string.split(" ");
        Pattern pattern = Pattern.compile("\\s");
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
            if (spaceCount == 5) indEnd = indexes.get(spaceCount - 1);
        }
        if (qSpace.length  >= 5)  str = string.substring(indStart + 1, indEnd);
        else throw new TooShortStringException();
          return str;
    }
    public static class TooShortStringException extends RuntimeException {
    }
}
