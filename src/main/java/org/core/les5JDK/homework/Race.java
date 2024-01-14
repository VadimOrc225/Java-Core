package org.core.les5JDK.homework;


public class Race extends Thread {
    protected static Thread[] threads = new Thread[5];
    int totalCount = 0;
    boolean flag = true;
    int counter = 0;

    protected static void waitMillis(long millis) {
        if (millis <= 0) {
            return;
        }
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    protected static void stopThreads(Thread[] threads) {
        for (Thread thread : threads) {
            if (!thread.isInterrupted()) {
                thread.interrupt();
            }
        }
        waitMillis(100);
    }


    @Override
    public void run() {
        System.out.println("Застолье началось");

        Fork[] forks = new Fork[5];
        for (int i = 0; i < forks.length; i++) {
            forks[i] = new Fork(i + 1);
        }

        Philosopher[] philosophers = new Philosopher[5];
        for (int i = 0; i < philosophers.length; i++) {
            Fork leftFork = forks[i];
            Fork rightFork = forks[(i + 1) % forks.length];

            if (leftFork.getId() < rightFork.getId()) {
                philosophers[i] = new Philosopher(leftFork, rightFork);
            } else {
                philosophers[i] = new Philosopher(rightFork, leftFork);
            }

            threads[i] = new Thread(philosophers[i], "Философ " + (i + 1));
            threads[i].start();
        }
        waitMillis(1000);
while(flag){
    counter=0;
        for (Thread thread : threads) {
            if (thread.isInterrupted()) {
                counter++;
                if(counter==5){flag=false;System.out.println("Все закончили есть");}
            }
        }
        waitMillis(1000);
    }

        for (Philosopher philosopher : philosophers) {
            totalCount += philosopher.eatCount;
        }
        if (totalCount == 15) {
            printStats(philosophers, totalCount);
        }
    }

    protected static void printStats(Philosopher[] philosophers, int totalCount) {


        System.out.println("Статистика:");
        System.out.println("Всего приемов пищи : " + totalCount);
        for (int i = 0; i < philosophers.length; i++) {
            System.out.println(
                    "Философ " + (i + 1) + ": " + (100.0 * philosophers[i].eatCount / totalCount) + "%.");
            System.out.println(
                    "Философ " + (i + 1) + " поел " + philosophers[i].eatCount + " раза.");

        }
    }
}