package com.javarush.task.task21.task2105;

import java.util.HashSet;
import java.util.Set;

/* 
Исправить ошибку. Сравнение объектов
*/
public class Solution {
    private final String first, last;

    public Solution(String first, String last) {
        this.first = first;
        this.last = last;
    }

    public boolean equals(Object o) {
        if (this.hashCode() == o.hashCode()) return true;
        if (this == o) return true;

        if (!(o instanceof Solution))
            return false;
        Solution n = (Solution) o;

         return last != null ? last.equals(n.last) : n.last == null;

    }
    public int hashCode() {
        int chars = 0;
        for (int i = 0; i < first.length() ; i++) {
            chars += (int)first.charAt(i);
        }
        for (int i = 0; i < last.length() ; i++) {
            chars += (int)last.charAt(i);
        }
        return 31 * chars;
    }

    public static void main(String[] args) {
        Set<Solution> s = new HashSet<>();
        s.add(new Solution("Mickey", "Mouse"));
        System.out.println(s.contains(new Solution("Mickey", "Mouse")));
    }
}
