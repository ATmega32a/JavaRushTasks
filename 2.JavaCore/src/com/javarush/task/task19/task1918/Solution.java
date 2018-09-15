package com.javarush.task.task19.task1918;

/* 
Знакомство с тегами
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String filename = reader.readLine();
        String tag = args[0];
        Pattern patternTagHTML = Pattern.compile("<" + tag + "[\\r\n\\w\\W\\d\\D]*>[\\r\n\\w\\W\\d\\D]*</" + tag + ">");
        Pattern patternTagInString = Pattern.compile("<" + tag + "[\\r\n\\w\\W\\d\\D]*>[\\r\n\\w\\W\\d\\D]*</" + tag + ">");
        Pattern patTag = Pattern.compile("<" + tag + ">");

        reader.close();
        FileReader fileReader = new FileReader(filename);
        BufferedReader bufferedFileReader = new BufferedReader(fileReader);
        String s = "";

        while (bufferedFileReader.ready()) {
            s = bufferedFileReader.readLine();
            findPrintTag(patternTagHTML,s,tag);
        }
        fileReader.close();
       }
    private static String findingFormating(String s,String tag){
        String listOfTags = "";
        Pattern patternAllTagHTML = Pattern.compile("(\\<(/?[^\\>]+)\\>)");
        //Pattern patternTagHTML = Pattern.compile("<\\w+[\\r\n\\w\\W\\d\\D]*>[\\r\n\\w\\W\\d\\D]*</\\w+>");
        Pattern patternTagHTML = Pattern.compile("<" + tag + "[\\r\n\\w\\W\\d\\D]*>[\\r\n\\w\\W\\d\\D]*</" + tag + ">");
        Matcher matcherAllTagHTML = patternTagHTML.matcher(s);
        while (matcherAllTagHTML.find()){
            listOfTags=matcherAllTagHTML.group();

        }
        return listOfTags;
    }
    private static String deleteTag(String strTag, String tag){
        strTag = "del" + strTag + "del";
        strTag = strTag.replaceAll("del<" + tag + Pattern.compile("[\\r\n\\w\\W\\d\\D]*?")+">", "");
        strTag = strTag.replaceAll("</" + tag + ">del", "");
        return strTag;
    }
    private static void findPrintTag(Pattern patternTagHTML, String strTag, String tag) {
        Matcher matcherTagHTML = patternTagHTML.matcher(strTag);
        if (matcherTagHTML.find()) {
            strTag = matcherTagHTML.group();
            System.out.println(strTag);
            String editStr = deleteTag(strTag, tag);
            if (editStr.contains(tag))
                findPrintTag(patternTagHTML,editStr,tag);
        }
    }
}
