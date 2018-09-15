package com.javarush.task.task19.task1916;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/* 
Отслеживаем изменения
*/

public class Solution {
    public static List<LineItem> lines = new ArrayList<LineItem>();

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String file1 = reader.readLine();
        String file2 = reader.readLine();
        reader.close();
        FileReader file1Reader = new FileReader(file1);
        FileReader file2Reader = new FileReader(file2);
        BufferedReader file1BufferedReader = new BufferedReader(file1Reader);
        BufferedReader file2BufferedReader = new BufferedReader(file2Reader);
        ArrayList<Integer> arrayList1 = new ArrayList<>();
        ArrayList<Integer> arrayList2 = new ArrayList<>();
        String strLine1 = "";
        String strLine2 = "";
        while (file1BufferedReader.ready()||file2BufferedReader.ready()) {
            strLine1 = file1BufferedReader.readLine();
            strLine2 = file2BufferedReader.readLine();
            if (!(strLine1.isEmpty() && strLine2.isEmpty())){
            if (strLine1.equals(strLine2)) {
                LineItem lineItemSame = new LineItem(Type.SAME, strLine1);
                lines.add(lineItemSame);
            } else if (strLine1.isEmpty() && !strLine2.isEmpty()) {
                LineItem lineItemEmpty = new LineItem(Type.ADDED, strLine2);
                lines.add(lineItemEmpty);
            } else if (!strLine1.isEmpty() && strLine2.isEmpty()) {
                LineItem lineItemEmpty = new LineItem(Type.REMOVED, strLine1);
                lines.add(lineItemEmpty);
            }
            //    System.out.println(strLine1 + "   -  " + strLine2);
        }
        }
        file2Reader.close();
        file1Reader.close();

        for (LineItem line : lines) {
            System.out.println(line.type + " " +line.line);
        }

    }


    public static enum Type {
        ADDED,        //добавлена новая строка
        REMOVED,      //удалена строка
        SAME          //без изменений
    }

    public static class LineItem {
        public Type type;
        public String line;

        public LineItem(Type type, String line) {
            this.type = type;
            this.line = line;
        }
    }
}