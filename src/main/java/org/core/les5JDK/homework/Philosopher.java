package org.core.les5JDK.homework;


import java.util.concurrent.atomic.AtomicInteger;


public class Philosopher extends Thread{
    protected final Fork leftFork;
    protected final Fork rightFork;

    public int eatCount = 0;
    protected Philosopher(Fork leftFork, Fork rightFork) {
        this.leftFork = leftFork;
        this.rightFork = rightFork;
    }

    @Override
    public void run() {
        try {
            while (!Thread.currentThread().isInterrupted()) {
                think();
                synchronized (leftFork) {
                    leftFork.take();
                    synchronized (rightFork) {
                        rightFork.take();
                        eat();
                        rightFork.put();
                        leftFork.put();
                    }
                }
                if(this.eatCount==3){                             //ест не более трех раз
                    Thread.currentThread().interrupt();
                }
            }
        } catch (InterruptedException e) {
            System.out.println(Thread.currentThread().getName() + " прерван");
        }
    }


    protected void think() throws InterruptedException {
       System.out.println(Thread.currentThread().getName() + " размышляет");

        Thread.sleep(getRandomInt());

    }

    protected void eat() throws InterruptedException {
        long t = System.nanoTime();
        System.out.println(t + ": " + Thread.currentThread().getName() + " ест");

        Thread.sleep(getRandomInt());

        eatCount++;

    }

    private int getRandomInt() {
        return (int) (Math.random() * 300);
    }
}