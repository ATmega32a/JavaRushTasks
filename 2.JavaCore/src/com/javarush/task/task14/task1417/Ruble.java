package com.javarush.task.task14.task1417;

public class Ruble extends Money{
    public Ruble(double amount) {
    super(amount);
    }
   public String getCurrencyName(){
       String RUB = "RUB";
       return RUB;
   }
}
