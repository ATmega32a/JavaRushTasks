package com.javarush.task.task18.task1826;

/*
Шифровка
*/

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;

public class Solution {

    public static void main(String[] args) throws IOException {
        String argument = args[0];
        String fileName = args[1];
        String fileOutputName = args[2];

        final int KEY = 9;

        switch (argument) {
            case "-e": writingFile(fileOutputName, cryptingData(readindFile(fileName), KEY));
            break;
            case "-d": writingFile(fileOutputName, enCryptingData(readindFile(fileOutputName), KEY));
            break;
        }
    }
    private static ArrayList<Integer> readindFile(String fileName) throws IOException{
        ArrayList<Integer> arrayList = new ArrayList<>();

        try {
            FileInputStream fileInputStream = new FileInputStream(fileName);
            while (fileInputStream.available() > 0) {
                int data = fileInputStream.read();
                arrayList.add(data);
            }
            fileInputStream.close();
        } catch (FileNotFoundException e) {
            e.getStackTrace();
        }
        return arrayList;
    }
    private static void writingFile(String fileOutputName, ArrayList<Integer> dataForWrite) throws IOException{

        try {
            FileOutputStream fileOutputStream = new FileOutputStream(fileOutputName);
            for (Integer aDataForWrite : dataForWrite) {
                fileOutputStream.write(aDataForWrite);
            }
            fileOutputStream.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
    private static ArrayList<Integer> cryptingData(ArrayList<Integer> dataForCrypt, int KEY){
        ArrayList<Integer> dataCrypted = new ArrayList<>();

        int dataCrypt;
        for (Integer data : dataForCrypt
                ) {
            dataCrypt = data + KEY;
            dataCrypted.add(dataCrypt);
        }
        return dataCrypted;
    }
    private static ArrayList<Integer> enCryptingData(ArrayList<Integer> dataForEncrypt, int KEY){
        ArrayList<Integer> dataEncrypted = new ArrayList<>();
        int dataEncrypt;
        for (Integer data : dataForEncrypt
                ) {
            dataEncrypt = data - KEY;
            dataEncrypted.add(dataEncrypt);
        }
        return dataEncrypted;
    }
}