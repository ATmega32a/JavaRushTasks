package com.javarush.task.task13.task1327;

import java.util.List;

public class RepkaStory {
   public static void tell(List<Person> items) {
        Person first;
        Person second;

        for (int i = items.size()-1; i > 0  ; i--) {
            first = items.get(i);
            second = items.get(i);
            first.pull(second);
        }
    }
}
