package org.core.lesson4;

public class InsufficientFundsException extends CustomArrayException {
    public InsufficientFundsException(String message, int sum) {
        super(message, sum);
    }
}
