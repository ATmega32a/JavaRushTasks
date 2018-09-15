package com.javarush.task.task15.task1522;

public final class Sun implements Planet {
    private static Sun instance = null;
    Sun(){}
    public static Sun getInstance(){
        if (instance==null)
        instance = new Sun();
        return instance;
    }
}

