package com.javarush.task.task14.task1417;

public class USD extends Money{
    public USD(double amount) {
        super(amount);
    }
    public String getCurrencyName(){
        String USD = "USD";
        return USD;
    }
}
