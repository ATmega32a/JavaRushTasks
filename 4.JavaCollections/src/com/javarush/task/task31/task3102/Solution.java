package com.javarush.task.task31.task3102;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


/* 
Находим все файлы
*/
public class Solution {
//    public static List<String> getFileTree(String root) throws IOException {
//        File file = new File(root);
//        List<String> list = new ArrayList<>();
//        Queue<File>  queue = new ArrayBlockingQueue<File>(100);
//        for (File f :file.listFiles()) {
//            if (f.isDirectory())
//                getFileTree(f.getAbsolutePath());
//            if (f.isFile())
//                list.add(f.getAbsolutePath());
//        }
//        for (String st : list)
//            System.out.println(st);
//        return list;
//    }
//
    public static void main(String[] args){
        for (String s:getFileTree("D:\\Music")) {
            System.out.println(s);
        }
    }

    public static List<String> getFileTree(String root) {
        List<String> list = new ArrayList<>();
        File file = new File(root);
        File[] files = file.listFiles();
        int i = 0;

        while(i < files.length) {
            File firstElement = files[i];
            File[] subFiles = null;

            if (firstElement.isDirectory()) {
                subFiles = firstElement.listFiles();
            }
            else {
                i++;
                continue;
            }
            File[] temp = new File[files.length + subFiles.length];
            for (int j = 0; j<=i; j++)
                temp[j] = files[j];
            for (int k = 0; k<subFiles.length; k++)
                temp[i+1+k] = subFiles[k];
            for (int m = i+1; m<files.length; m++)
                temp[m+subFiles.length] = files[m];

            files = temp;
            i++;
        }

        for (File f : files) {
            if(f.isDirectory()) continue;
            list.add(f.getAbsolutePath());
        }
        return list;
    }
}
