package com.javarush.task.task09.task0926;

import java.util.ArrayList;

/* 
Список из массивов чисел
*/

public class Solution {
    public static void main(String[] args) {
        ArrayList<int[]> list = createList();
        printList(list);
    }

    public static ArrayList<int[]> createList() {
        //напишите тут ваш код
        ArrayList<int[]> list = new ArrayList<int[]>();
        int[] a = new int[]{2,5,4,7,1};
        int[] b = new int[]{23,64};
        int[] c = new int[]{12,65,48,0};
        int[] d = new int[]{4,7,12,875,34,10,2};
        int[] e = new int[]{};

        list.add(a);
        list.add(b);
        list.add(c);
        list.add(d);
        list.add(e);
      return list;
    }

    public static void printList(ArrayList<int[]> list) {
        for (int[] array : list) {
            for (int x : array) {
                System.out.println(x);
            }
        }
    }
}
