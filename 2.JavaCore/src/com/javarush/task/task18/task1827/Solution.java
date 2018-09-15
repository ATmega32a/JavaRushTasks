package com.javarush.task.task18.task1827;

/* 
Прайсы
*/


import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Solution {
    public static void main(String[] args) throws Exception, NumberFormatException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = reader.readLine();
        FileInputStream file = new FileInputStream(fileName);
        BufferedOutputStream outputStream = new BufferedOutputStream(new FileOutputStream(new File(fileName), true));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream));
        Pattern p = Pattern.compile("\\d{1,8}\\s{1,8}\\D{1,30}\\s{1,30}\\d+\\.?\\d+\\s{1,8}\\d{1,8}");
        String _c = "";
        String productName = "" ;
        String price  = "";
        String quantity  = "";
        int idInt = 0;

        try{
          _c = args[0];
          for (int i = 1; i <args.length-3 ; i++) {
                productName += args[i]+" ";
            }
            productName+=args[args.length-2];
           productName = strLength(productName,30);
            price = args[args.length-1];
          quantity = args[args.length];
        } catch (ArrayIndexOutOfBoundsException e){e.getStackTrace();}

        String id = "0";
        String lastID ="";
        if (_c.equals("-c")) {
           if(!file.toString().isEmpty()){
              try{
                  lastID =lastIDCounter(fileName,p);
                  idInt = Integer.parseInt(lastID);
                  idInt++;
              } catch (NumberFormatException e) {e.getStackTrace();}
          }
            id = String.valueOf(idInt);
            String string = strLength(id,8)  + productName  + strLength(price, 8) + strLength(quantity, 4);

            bufferedWriter.write(string, 0, string.length());
            bufferedWriter.newLine();
        }
        bufferedWriter.close();
        outputStream.close();
        file.close();
    }

    private static String strLength(String origString, int length){
        for (int j = 0; j < length; j++) {
            if (origString.length() < length) {
                for (int k = 0; k < length - origString.length(); k++) {
                    origString += " ";
                }
            } else if (origString.length() > length) {
                origString = origString.substring(0, length);
            }
        }
        return origString;
    }
    private static String lastIDCounter(String fileName,Pattern p) throws IOException{

        FileInputStream file = new FileInputStream(fileName);
        Pattern findLastIDPattern =  Pattern.compile("^\\d+");
        String perviousData="";
        String lastID ="";
        while (file.available() > 0 ){
           perviousData += String.valueOf((char)(int)file.read());
        }
        Matcher m = p.matcher(perviousData);
        String findPatt = "";
        while (m.find()){
            findPatt = m.group();
        }
        Matcher findLastIDMatcher = findLastIDPattern.matcher(findPatt);
        if(findLastIDMatcher.find()){
            lastID = findLastIDMatcher.group();
        }
        return lastID;
    }
}
