package ru.netology;

import java.util.concurrent.atomic.LongAdder;

public class GroceryStore extends Thread {
    private final int TIMEOFSALE = 50; // так называемое время продажи
    private int max;
    private int min;
    private LongAdder totalSumm;


    public GroceryStore(int max, int min, LongAdder totalSumm) {
        this.max = max;
        this.min = min;
        this.totalSumm = totalSumm;

    }

    @Override
    public void run() {
        try {
            while (!interrupted()) {
                max -= min;
                int cheque = (int) (Math.random() * ++max) + min;
                //System.out.println(Thread.currentThread().getName() + " продал товар за " + cheque + " рублей");
                totalSumm.add(cheque);
                Thread.sleep(TIMEOFSALE);
            }

        } catch (InterruptedException e) {

        } finally {
            System.out.println(Thread.currentThread().getName() + " закрылся");
        }

    }
}

