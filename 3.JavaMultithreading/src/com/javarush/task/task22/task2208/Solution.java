package com.javarush.task.task22.task2208;

import java.util.HashMap;
import java.util.Map;

/*
Формируем WHERE
*/
public class Solution {
    public static void main(String[] args){
        Map<String, String> map = new HashMap<>();

        map.put("name", "Ivanov");
        map.put("age", null);
        map.put("age1", null);
        map.put("country", "Ukraine");
        map.put("city", "Kiev");
        map.put("site", "vk.com");
        map.put("IP address", "192.168.0.1");
        System.out.println(getQuery(map));
    }
    public static String getQuery(Map<String, String> params){
        StringBuilder sb = new StringBuilder();

        for (Map.Entry<String, String> stStMap: params.entrySet()) {
            if(stStMap.getValue()!=null) {
                sb.append(stStMap.getKey()).append(" = ").
                        append("'").append(stStMap.getValue()).append("'").append(" and ");
            }
        }
        int count = 0;
        String result;
        for (String s :params.values()){
            if(s == null) count++;
        }
        if (count == params.size()) {
            result = "";
        } else result = sb.substring(0,sb.length()-5);
        return result;
    }
}
