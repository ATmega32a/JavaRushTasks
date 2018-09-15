package com.javarush.task.task27.task2709;

public class ConsumerTask implements Runnable {
    private TransferObject transferObject;
    protected volatile boolean stopped;

    public ConsumerTask(TransferObject transferObject) {
        this.transferObject = transferObject;
        new Thread(this, "ConsumerTask").start();
    }

    public void run() {
        while (!stopped) {
            if (transferObject != null)
                synchronized (transferObject) {
                    while (!transferObject.isValuePresent) {
                        try {
                            transferObject.wait();
                        } catch (InterruptedException ignore) {

                        }
                    }
                    transferObject.get();
                    transferObject.isValuePresent = false;
                    transferObject.notifyAll();
                }
        }
    }

    public void stop() {
        stopped = true;
    }
}