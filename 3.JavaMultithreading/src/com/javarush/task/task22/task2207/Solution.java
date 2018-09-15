package com.javarush.task.task22.task2207;

import java.io.*;
import java.util.*;

/* 
Обращенные слова
*/
public class Solution {
    public static List<Pair> result = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        InputStream fis = new FileInputStream(reader.readLine());
        BufferedReader file = new BufferedReader(new InputStreamReader(fis));
        StringBuilder sb = new StringBuilder();
        StringBuilder str = new StringBuilder();
        String s[] = new String[fis.available()];

        while (file.ready()){
          s = file.readLine().split(" ");
            for (int i = 0; i < s.length; i++) {
                str.append(s[i]);
                for (int j = 0; j < s.length; j++) {
                    if(i==j) continue;
                    sb.append(s[j]).reverse();
                    if(str.toString().equals(sb.toString())) System.out.println(sb);
                    sb.delete(0,sb.length());
                    str.delete(0,str.length());
                }
            }
        }
    }

    public static class Pair {
        String first;
        String second;

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Pair pair = (Pair) o;

            if (first != null ? !first.equals(pair.first) : pair.first != null) return false;
            return second != null ? second.equals(pair.second) : pair.second == null;

        }

        @Override
        public int hashCode() {
            int result = first != null ? first.hashCode() : 0;
            result = 31 * result + (second != null ? second.hashCode() : 0);
            return result;
        }

        @Override
        public String toString() {
            return  first == null && second == null ? "" :
                    first == null && second != null ? second :
                    second == null && first != null ? first :
                    first.compareTo(second) < 0 ? first + " " + second : second + " " + first;

        }
    }

}
// F:\forTests\for2207\for2207.txt
// F:\forTests\for2207\for2207_0.txt
// F:\forTests\for2207\for2207_00.txt
// F:\forTests\for2207\for2207_1.txt