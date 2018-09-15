package com.javarush.task.task15.task1527;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/*
Парсер реквестов
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        //add your code here
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<String> parameters = new ArrayList<>();
        ArrayList<Object> list = new ArrayList<>();
        String URL = reader.readLine();
        URL += "&";
        Pattern p = Pattern.compile("[?&]\\w+|\\W+[=&$]");
        Matcher m = p.matcher(URL);
        Pattern p1 = Pattern.compile("((\\?||&)obj=((\\d+\\.?\\d+?)||(\\w+))&)");
        Matcher m1 = p1.matcher(URL);
        Pattern p3 = Pattern.compile("^\\d+\\.?\\d+?$");
        Pattern p4 = Pattern.compile("^\\w+|\\W+$");
        Pattern p5 = Pattern.compile("^=\\d+\\.?\\d+?$");
        Pattern p6 = Pattern.compile("^=\\w+|\\W+$");

        while (m.find()) {
            parameters.add(URL.substring(m.start() + 1, m.end()));
        }
        for (int k = 0; k < parameters.size(); k++) {
            System.out.print(parameters.get(k));
            if (k == parameters.size() - 1) break;
            System.out.print(" ");
        }
        System.out.println();
        String subStr;
        while (m1.find()) {
            subStr = URL.substring(m1.start() + 4, m1.end() - 1);
            list.add(subStr);
        }

        //for (int i = 0; i < list.size(); i++) {
       /*     Matcher m4 = p4.matcher(list.get(i));
            Matcher m3 = p3.matcher(list.get(i));
            Matcher m5 = p5.matcher(list.get(i));
            Matcher m6 = p6.matcher(list.get(i));*/
          /*  if (m4.matches()) {
                alert(list.get(i));
            } else if (m3.matches()) {
                alert(Double.parseDouble(list.get(i)));
            }
            else if (m5.matches()) {
                subStr = list.get(i);
                subStr = subStr.substring(m5.start()+1, m5.end());
                alert(Double.parseDouble(subStr));
            } else if (m6.matches()) {
                subStr = list.get(i);
                subStr = subStr.substring(m6.start() + 1, m6.end() );
                alert(subStr);
            }*/
            for (int j = 0; j < list.size(); j++) {
                Matcher m4 = p4.matcher((String)list.get(j));
                Matcher m3 = p3.matcher((String)list.get(j));
                Matcher m5 = p5.matcher((String)list.get(j));
                Matcher m6 = p6.matcher((String)list.get(j));
           if (list.get(j) instanceof Number) {
               alert(((Double) list.get(j)).doubleValue());
           }
         //  else alert((String) list.get(j));
            }

        }
   // }
    public static void alert(double value) {
        System.out.println("double " + value);
    }


    public static void alert(String value) {
        System.out.println("String " + value);
    }
}

