package org.core.lesson4;

public class IllegalArgumentException extends CustomArrayException{
    public IllegalArgumentException(String message, int sum) {
        super(message, sum);
    }
}
