package com.javarush.task.task17.task1721;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/* 
Транзакционность
*/

public class Solution {
    public static List<String> allLines = new ArrayList<String>();
    public static List<String> forRemoveLines = new ArrayList<String>();

    public static void main(String[] args) throws IOException{
    joinData();
    }

    public static void joinData() throws CorruptedDataException {
       try{
           BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
           String fileName1;
           String fileName2;
           fileName1=reader.readLine();
          // fileName2=reader.readLine();
           InputStream file1 = new FileInputStream(fileName1);
           //InputStream file2 = new FileInputStream(fileName2);
        //   byte[] buffer1 = new byte[file1.available()];
          // byte[] buffer2 = new byte[file2.available()];
       //    file1.read(buffer1, 0, file1.available());
       /*    int i=0;
           try{
               String newLine = System.getProperty("line.separator");
               while (!(buffer1[i] ==  Byte.parseByte("line.separator"))){
                   System.out.print((char) buffer1[i]);
                   i++;
               }
           }catch (NumberFormatException e){}*/
         int i = 0;
         byte[] stringInputArr = new byte[file1.available()];
         byte[] stringOutputArr = new byte[file1.available()];

         int sizeFile = file1.available();
         while(file1.available() > 0){
               //char text1= (char) file1.read();

               stringInputArr[i] = Byte.parseByte(Integer.toString(file1.read()));
               i++;
         //      allLines.add(string);
               //  System.out.print(text1);
           }
           for (int k = 0; k < stringInputArr.length; k++) {
               System.out.println(stringInputArr[k]);
           }
           int j = -1;
          String newLine = System.getProperty("line.separator");

          while(true){
               j++;
               if(j < sizeFile)
               {
                      if(!(stringInputArr[j]=='t'))
                       {
                           stringOutputArr[j] = stringInputArr[j];
                        //   System.out.println(j);

                       }else  break;
               } else break;
           }

          for (int k = 0; k < stringOutputArr.length; k++) {
              System.out.print((char) stringOutputArr[k]);
           }
    /*     while(file2.available() > 0){
               // char text2= (char) file2.read();
               forRemoveLines.add(Integer.toString(file2.read()));
               // System.out.print(text2);
           }

           for (int i = 0; i < allLines.size()-1; i++) {
            System.out.print((char)Integer.parseInt(allLines.get(i)));

           }
           for (int i = 0; i < forRemoveLines.size()-1; i++) {
           System.out.print((char)Integer.parseInt(forRemoveLines.get(i)));

        }*/
           file1.close();
          //file2.close();

       }catch (IOException e){}
    }

}
