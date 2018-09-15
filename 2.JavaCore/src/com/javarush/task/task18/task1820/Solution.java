package com.javarush.task.task18.task1820;

/*
Округление чисел
*/

import java.io.*;
import java.util.ArrayList;

public class Solution {
    public static void main(String[] args) throws IOException{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName1 = reader.readLine();
        String fileName2 = reader.readLine();

        FileInputStream file1 = new FileInputStream(fileName1);
        FileOutputStream file2 = new FileOutputStream(fileName2);
        ArrayList<Double> result = new ArrayList<>();
        char[] data = new char[file1.available()];

        int index = 0;
        while(file1.available() > 0){
            data[index] = (char) file1.read();
            index++;

        }

        try{
            String stringPars = "";
            Double doubleBuff;
            for (int i = 0; i < data.length ; i++) {
                if(data[i] != 32) {
                    stringPars += data[i];
                } else{
                    doubleBuff = Double.parseDouble(stringPars);
                    stringPars = String.format("%.0f", doubleBuff);
                    doubleBuff = Double.parseDouble(stringPars);
                    result.add(doubleBuff);
                    stringPars = "";
                }
            }
            doubleBuff = Double.parseDouble(stringPars);
            stringPars = String.format("%.0f", doubleBuff);
            doubleBuff = Double.parseDouble(stringPars);
            result.add(doubleBuff);
        }catch (NumberFormatException e){

        } finally {
        int dataOut;
        for (int i = 0; i < result.size(); i++) {
            dataOut = (int) (double) result.get(i);
            file2.write(dataOut);
            System.out.println((int) (double) result.get(i));
        }
                file1.close();
                file2.close();
        }
    }
}
