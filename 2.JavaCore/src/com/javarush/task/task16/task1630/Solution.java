package com.javarush.task.task16.task1630;

import java.io.*;
import java.util.ArrayList;

public class Solution {
    public static String firstFileName;
    public static String secondFileName;
    public static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    public static ArrayList<Character> list = new ArrayList<Character>();
    public static InputStream fileRead;


    static{
        try{
            firstFileName=reader.readLine();
            secondFileName=reader.readLine();
        }catch (IOException e){
            e.getStackTrace();
        }
    }

    //add your code here - добавьте код тут

    public static void main(String[] args) throws InterruptedException {
        systemOutPrintln(firstFileName);
        systemOutPrintln(secondFileName);
    }

    public static void systemOutPrintln(String fileName) throws InterruptedException {
        try{  ReadFileInterface f = new ReadFileThread();
            f.setFileName(fileName);
            f.start();
            f.join();
            //add your code here - добавьте код тут
            System.out.println(f.getFileContent());
            Thread.currentThread().interrupt();
        }catch (InterruptedException e){
            e.getStackTrace();
        }

    }

    public interface ReadFileInterface {

        void setFileName(String fullFileName);

        String getFileContent();

        void join() throws InterruptedException;

        void start();
    }
    public static class ReadFileThread extends Thread implements ReadFileInterface{
        public void setFileName(String fullFileName) {
            try {
                fileRead = new FileInputStream(fullFileName);
            } catch (FileNotFoundException e2) {
                e2.getStackTrace();
            }

        }
        public String getFileContent(){
            

            try{
                while(fileRead.available()!=0){
                    list.add((char)fileRead.read());
                }
            }catch (IOException e3){
                e3.getStackTrace();
            }
            String s="";
            for (int i = 0; i < list.size(); i++) {
                s += list.get(i);
            }
            interrupt();
            return s;
        }
        public void run (){

      //     try{
               setFileName(firstFileName);
               getFileContent();

     //      }catch (InterruptedException e){
               setFileName(secondFileName);
               getFileContent();
   //        }
        }
    }
    //add your code here - добавьте код тут
}
