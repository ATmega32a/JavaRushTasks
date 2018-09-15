package com.javarush.task.task19.task1915;

/* 
Дублируем текст
*/

import java.io.*;

public class Solution {
    public static TestString testString = new TestString();

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String string = reader.readLine();
        FileOutputStream fileOutputStream = null;
        fileOutputStream = new FileOutputStream(string);
        reader.close();
        PrintStream streamConsole = System.out;
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream stream = new PrintStream(outputStream);
        System.setOut(stream);
        testString.printSomething();
        String str = outputStream.toString();
        System.setOut(streamConsole);

       fileOutputStream.write(str.getBytes());
       fileOutputStream.close();
       System.out.print(str);

    }

    public static class TestString {
        public void printSomething() {
            System.out.println("it's a text for testing");
        }
    }
}

