package com.javarush.task.task27.task2709;

public class TransferObject {
    private int value;
    protected volatile boolean isValuePresent = false; //use this variable

    public synchronized int get() {
        while (!isValuePresent) {
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        isValuePresent = false;
        this.notifyAll();
        System.out.println("Got: " + value);
       return value;
    }

    public synchronized void put(int value) {
        this.value = value;
        while (isValuePresent) {
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        isValuePresent = true;
        this.notifyAll();
        System.out.println("Put: " + value);
    }
}
