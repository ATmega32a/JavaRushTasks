package com.javarush.task.task21.task2104;

import java.util.HashSet;
import java.util.Set;

/* 
Equals and HashCode
*/
public class Solution {
    private final String first, last;

    public Solution(String first, String last) {
        this.first = first;
        this.last = last;
    }

    public boolean equals(Solution n) {
        if(this == n)
            return true;

        if(n == null)
            return false;

        if(this.getClass() != n.getClass())
            return false;

        Solution solution =  n;

        if(solution.first == null)
            return false;

        if(solution.last==null)
            return false;

        if(this.first != solution.first)
                return false;
        if (this.last != solution.last)
                return false;

        return true;
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
        s.add(new Solution("Donald", "Duck"));
        System.out.println(s.contains(new Solution("Donald", "Duck")));
        System.out.println(s.hashCode());
    }
}
