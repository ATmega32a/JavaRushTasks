package com.javarush.task.task24.task2401;

public class SelfInterfaceMarkerImpl implements SelfInterfaceMarker{

    public String Hello(){
        return "Hello!";
    }
    public void SayHello(){
        System.out.println(Hello());
    }
}
