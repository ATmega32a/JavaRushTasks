package com.javarush.task.task28.task2802;


import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

/* 
Пишем свою ThreadFactory
*/
public class Solution {

    public static void main(String[] args) {
        class EmulateThreadFactoryTask implements Runnable {
            @Override
            public void run() {
                emulateThreadFactory();
            }
        }

        ThreadGroup group = new ThreadGroup("firstGroup");
        Thread thread = new Thread(group, new EmulateThreadFactoryTask());

        ThreadGroup group2 = new ThreadGroup("secondGroup");
        Thread thread2 = new Thread(group2, new EmulateThreadFactoryTask());

        thread.start();
        thread2.start();
    }

    private static void emulateThreadFactory() {
        AmigoThreadFactory factory = new AmigoThreadFactory();
        Runnable r = new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName());
            }
        };
        factory.newThread(r).start();
        factory.newThread(r).start();
        factory.newThread(r).start();
    }

//  В классе Solution создай публичный статический класс AmigoThreadFactory, реализующий интерфейс ThreadFactor
    public static class AmigoThreadFactory implements ThreadFactory{
         AtomicInteger factoryNumber = new AtomicInteger(0);
         AtomicInteger threadNumber = new AtomicInteger(0);
         static AtomicInteger factoryCount=new AtomicInteger(0);
         public AmigoThreadFactory(){
             factoryNumber.set(factoryCount.incrementAndGet());
         }

        @Override
        public Thread newThread(Runnable r) {
            Thread thread = new Thread(); // 1. Реализация интерфейсного метода - создайте и верните трэд,
                                          //    который должен:
            thread.setDaemon(false);      // 1.1. не быть демоном
            thread.setPriority(Thread.NORM_PRIORITY);  // 1.2. иметь нормальный приоритет,
                                          // 1.3. имя трэда должно иметь шаблон "GN-pool-A-thread-B",
                                          // где GN - это имя группы,
                                          // A - это номер фабрики инкрементируется в пределах класса начиная с 1,
                                          // используйте AtomicInteger,
                                          // B - номер треда инкрементируется в пределах конкретной фабрики
                                          // начиная с 1, используйте AtomicInteger.
            StringBuffer sb = new StringBuffer()
                    .append(Thread.currentThread().getThreadGroup().getName())
                    .append("-pool-")
                    .append(factoryNumber)
                    .append("-thread-")
                    .append(threadNumber.incrementAndGet());
            thread.setName(sb.toString());
                                          //2. Каждая фабрика должна иметь ту группу тредов (ThreadGroup),
                                          // в которой она была создана.
            return thread;
        }
    }
}
