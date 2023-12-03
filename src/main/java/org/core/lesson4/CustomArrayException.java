package org.core.lesson4;

public abstract class CustomArrayException extends Exception {

    private final int sum;


    public int getSum() {
        return sum;
    }



    public CustomArrayException(String message, int sum) {
        super(message);
        this.sum = sum;

    }
}
