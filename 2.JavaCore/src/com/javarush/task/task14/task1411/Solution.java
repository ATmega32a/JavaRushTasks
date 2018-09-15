package com.javarush.task.task14.task1411;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* 
User, Looser, Coder and Proger
*/

public class Solution implements Person{
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Person person = null;
        String key = null;
        ArrayList<Person> keys = new ArrayList<>();
        while(true){
            key = reader.readLine();
            if(!(key.equals("user")||key.equals("loser")||key.equals("coder")||key.equals("proger"))) break;
               switch (key){
                    case "user": {
                        keys.add(new User());
                    }
                        break;
                    case "loser": {
                        keys.add(new Loser());
                    }
                        break;
                    case "coder": {
                        keys.add(new Coder());
                    }
                        break;
                    case "proger": {
                        keys.add(new Proger());
                    }
                        break;
            }

        }
        //тут цикл по чтению ключей, пункт 1
        {
            //создаем объект, пункт 2
            for (int j = 0; j < keys.size() ; j++) {
                person = keys.get(j);
                doWork(person); //вызываем doWork
            }

       }
    }


    public static void doWork(Person person) {
        // пункт 3

        if (person instanceof User) ((User) person).live();
          else if (person instanceof Loser) ((Loser) person).doNothing();
             else if (person instanceof Coder) ((Coder) person).coding();
                else if (person instanceof Proger) ((Proger) person).enjoy();
    }
}
