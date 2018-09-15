package com.javarush.task.task18.task1813;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.channels.FileChannel;

/* 
AmigoOutputStream
*/

public class AmigoOutputStream extends FileOutputStream{
    public static String fileName = "C:/tmp/result.txt";
    private FileOutputStream fileOutputStreamOrig;
    public AmigoOutputStream(FileOutputStream fileOutputStreamOrig) throws FileNotFoundException {
        super(fileName);
        this.fileOutputStreamOrig = fileOutputStreamOrig;
    }
    @Override
    public void write(int b) throws IOException {
        fileOutputStreamOrig.write(b);
    }

    @Override
    public void write(byte[] b) throws IOException {
        fileOutputStreamOrig.write(b);
    }

    @Override
    public void write(byte[] b, int off, int len) throws IOException {
        fileOutputStreamOrig.write(b, off, len);
    }



    @Override
    public void close(){
        try {
            String data = "JavaRush © All rights reserved.";
            fileOutputStreamOrig.flush();
            fileOutputStreamOrig.write(data.getBytes());
            fileOutputStreamOrig.close();
        }catch (IOException e){}

    }

    @Override
    public FileChannel getChannel() {
        return fileOutputStreamOrig.getChannel();
    }


    @Override
    public void flush() throws IOException {
        fileOutputStreamOrig.flush();
    }

    public static void main(String[] args) throws FileNotFoundException {
        new AmigoOutputStream(new FileOutputStream(fileName));
    }
}