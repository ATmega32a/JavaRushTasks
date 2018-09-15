package com.javarush.task.task19.task1925;

/* 
Длинные слова
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader fileReader = new BufferedReader(new FileReader(args[0]));
        BufferedWriter fileWriter = new BufferedWriter(new FileWriter(args[1]));
        String[] strArray;
        String str;
        String stringWrite ="";
        while (fileReader.ready()){
            str = fileReader.readLine();
            str +="#";
            strArray = str.split(" ");
                for (int i = 0; i < strArray.length; i++) {
                    if (strArray[i].length() > 7) {
                        if(i == strArray.length-1) {
                            stringWrite += strArray[i];
                            stringWrite = stringWrite.replaceAll("#",",");
                        } else {
                            stringWrite += strArray[i]+" ";
                            stringWrite = stringWrite.replaceAll(" ",",");
                        }
                    }
                }
        }
        if(stringWrite.endsWith(",")) fileWriter.write(stringWrite.substring(0,stringWrite.lastIndexOf(",")));
            else fileWriter.write(stringWrite);
        fileReader.close();
        fileWriter.close();
    }
}
