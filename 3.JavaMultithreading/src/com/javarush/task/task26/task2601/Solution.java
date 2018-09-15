package com.javarush.task.task26.task2601;

import java.sql.Array;
import java.util.*;

/*
Почитать в инете про медиану выборки
*/
public class Solution {

    public static void main(String[] args) {
        Integer[] arr = new Integer[]{13, 8, 15, 5, 17};
        System.out.println(Arrays.toString(arr));
        System.out.println(Arrays.toString(sort(arr)));
    }

    public static Integer[] sort(Integer[] array) {
        //implement logic here
        Integer mediana;
        ArrayList<Integer> list = new ArrayList<>(Arrays.asList(array));
        Collections.sort(list);

        if(list.size()%2==0) mediana = (list.get(list.size()/2-1)+list.get(list.size()/2))/2;
                 else mediana = list.get((list.size()-1)/2);
        Integer[] integers = new Integer[list.size()];
class Comp implements Comparable<Integer>{

    @Override
    public int compareTo(Integer o) {
        return mediana - list.get(list.indexOf(o));
    }
    List<Integer> sorting(ArrayList<Integer> arrayList){
        Collections.sort(arrayList);
        return arrayList;
    }
}

       for (int i = 0; i < new Comp().sorting(list).size(); i++) {
            integers[i] =list.get(i);
        }

        return integers;
    }

}
