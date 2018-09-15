package com.javarush.task.task18.task1812;

import java.io.*;

/* 
Расширяем AmigoOutputStream
*/

public class QuestionFileOutputStream implements AmigoOutputStream {
    private AmigoOutputStream amigoOutputStr;
    public QuestionFileOutputStream(AmigoOutputStream amigoOutputStr){
        this.amigoOutputStr = amigoOutputStr;
}
    @Override
    public void flush() throws IOException{
        amigoOutputStr.flush();
    }
    @Override
    public void write(int b) throws IOException{
        amigoOutputStr.write(b);
    }
    @Override
    public void write(byte[] b) throws IOException{
        amigoOutputStr.write(b);
    }
    @Override
    public void write(byte[] b, int off, int len) throws IOException{
        amigoOutputStr.write(b,off,len);
    }
    @Override
    public void close() throws IOException {
        System.out.println("Вы действительно хотите закрыть поток? Д/Н");
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String answer = reader.readLine();
            if(answer.equals("Д")) {
                amigoOutputStr.close();
            } else if (answer.equals("Н")){
            }
    }
}

