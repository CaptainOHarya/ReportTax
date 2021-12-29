package ru.netology;

import java.util.concurrent.atomic.LongAdder;

public class Main {

    public static void main(String[] args) throws InterruptedException{

        final int WORKINGHOURS = 4000; // время работы наших магазинов
        int maxLimit = 3500; // Максимальная стоимость товара, которое продают магазины
        int minLimit = 10; // Минимальное стоимость товара, которое продают магазины

        LongAdder totalAllSumm = new LongAdder();

        ThreadGroup gloceryStores = new ThreadGroup("Гастрономы");

        Thread gloceryStore1 = new Thread(gloceryStores, new GroceryStore(maxLimit, minLimit, totalAllSumm), "Гастроном на Кутузовском проспекте");
        Thread gloceryStore2 = new Thread(gloceryStores, new GroceryStore(maxLimit, minLimit, totalAllSumm), "Гастроном на Варшавском шоссе");
        Thread gloceryStore3 = new Thread(gloceryStores, new GroceryStore(maxLimit, minLimit, totalAllSumm), "Гастроном на Липецкой улице");
        gloceryStore1.start();
        gloceryStore2.start();
        gloceryStore3.start();

        Thread.sleep(WORKINGHOURS);

        gloceryStores.interrupt();
        System.err.println("Общая выручка составила " + totalAllSumm.sum() + " рублей ");



    }

}
