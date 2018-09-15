package com.javarush.task.task18.task1814;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* 
UnsupportedFileName
*/

public class TxtInputStream extends FileInputStream {
private String fileName;
    public TxtInputStream(String fileName) throws IOException, UnsupportedFileNameException {
        super(fileName);
        this.fileName = fileName;
        Pattern pattern = Pattern.compile("^.+\\.txt$");
        Matcher matcher = pattern.matcher(fileName);
        if(!matcher.find()){
            super.close();
            throw new UnsupportedFileNameException();
        }

    }

    public static void main(String[] args) throws IOException, UnsupportedFileNameException{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = reader.readLine();
        TxtInputStream txtInputStream = new TxtInputStream(fileName);
        int index = 0;
        int[] data = new int[txtInputStream.available()];
        while (txtInputStream.available() > 0){
            data[index] = txtInputStream.read();
            index++;
        }

        txtInputStream.close();
        for (int i = 0; i < data.length; i++) {
            System.out.print((char) data[i]);
        }
    }
}

