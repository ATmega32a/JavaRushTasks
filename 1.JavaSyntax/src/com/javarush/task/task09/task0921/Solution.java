package com.javarush.task.task09.task0921;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.io.IOException;

/* 
Метод в try..catch
*/

public class Solution  extends IOException{
    public static void main(String[] args) {
        try {
            readData();
        }catch(IOException e) {

        }
    }

    public static void readData() throws IOException{
        //напишите тут ваш код
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        List<Integer> list = new ArrayList<Integer>();
        try
        {
            do
            {
             list.add(Integer.parseInt(reader.readLine()));
            } while(!list.isEmpty());

            for (int i = 0; i < list.size(); i++)
            {
                System.out.println(list.get(i));
            }
        }catch(NumberFormatException e)
        {
           //System.out.println("Вы ввели не цифру! " + e.getMessage());
            for (int i = 0; i < list.size(); i++)
            {
                System.out.println(list.get(i));
            }
        }
    }
}
